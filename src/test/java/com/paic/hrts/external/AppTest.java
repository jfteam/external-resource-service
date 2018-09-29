package com.paic.hrts.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paic.hrts.external.dto.ArticleDTO;
import com.paic.hrts.external.dto.ArticleItemsDTO;
import com.paic.hrts.external.dto.RestResponse;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseTest {

    String json ="{\n" +
            "  \"code\": 20000,\n" +
            "  \"message\": \"OK\",\n" +
            "  \"data\": {\n" +
            "    \"items\": [\n" +
            "      {\n" +
            "        \"author\": {\n" +
            "          \"avatar\": \"https://wpimg.wallstcn.com/6f/23/e2/1912586948.jpg\",\n" +
            "          \"display_name\": \"付鹏\",\n" +
            "          \"id\": 100001415753,\n" +
            "          \"uri\": \"https://wallstreetcn.com/authors/100001415753\"\n" +
            "        },\n" +
            "        \"content_short\": \"付鹏认为，银 被资产、负债端同时挤压实际是在赌博，赌 众会像 港当   样为房地产买单，各银 也赌同业中有 率先爆掉，然后监管部 会出台政策拯救 家，牺牲 两个银 救活 其他 。\",\n" +
            "        \"display_time\": 1492403892,\n" +
            "        \"id\": 3004522,\n" +
            "        \"image_uri\": \"https://wpimg.wallstcn.com/c6dd35ec-9abe-4a14-85b3-9637814dd\",\n" +
            "        \"source_name\": \"\",\n" +
            "        \"source_uri\": \"\",\n" +
            "        \"title\": \"资产荒和负债荒的反馈\",\n" +
            "        \"uri\": \"https://wallstreetcn.com/articles/3004522\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"author\": {\n" +
            "          \"avatar\": \"https://dn-wscn-avatar.qbox.me/8d/da/1f/img328775867.jpg\",\n" +
            "          \"display_name\": \"欧薏\",\n" +
            "          \"id\": 100001374297,\n" +
            "          \"uri\": \"https://wallstreetcn.com/authors/100001374297\"\n" +
            "        },\n" +
            "        \"content_short\": \"媒体称，特朗普可能会提名前财政部副部 Randy Quarles为美联储副主席 ，主管银 监管。这可能意味着，特朗普政府或将以务实的态度来去除银 监管，  选择 个 想主义者来执  去监管任务。 17916\",\n" +
            "        \"display_time\": 1492402805,\n" +
            "        \"id\": 3004465,\n" +
            "        \"image_uri\": \"https://wpimg.wallstcn.com/e4b8be3d-3c77-40bc-842c-4f9ac6ad6\",\n" +
            "        \"source_name\": \"\",\n" +
            "        \"source_uri\": \"\",\n" +
            "        \"title\": \"空缺 7 的美联储副主席终于有  选:特朗普拟提名凯 合伙 Quarles\",\n" +
            "        \"uri\": \"https://wallstreetcn.com/articles/3004465\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"author\": {\n" +
            "          \"avatar\": \"https://dn-wscn-avatar.qbox.me/25/98/f2/4LFOp6.jpg\",\n" +
            "          \"display_name\": \"谢亚轩\",\n" +
            "          \"id\": 100001623202,\n" +
            "          \"uri\": \"https://wallstreetcn.com/authors/100001623202\"\n" +
            "        },\n" +
            "        \"content_short\": \"感谢各位对招商宏观的关注、 持和帮助!我们会努 做到最好!\",\n" +
            "        \"display_time\": 1492401917,\n" +
            "        \"id\": 3004520,\n" +
            "        \"image_uri\": \"http://7xjd9a.com2.z0.glb.qiniucdn.com/mmbiz_jpg/sjKbG2Bj8LmGvFVHDzMZqdSJibmtZBfno8dLcyKwXSfBY0ZD8ia2j4E3Y5X8fzCO1Lo0tzZCjh5v9mL9SQ3sXvtw/0?wx_fmt=jpeg\",\n" +
            "        \"source_name\": \"轩 全球宏观\",\n" +
            "        \"source_uri\": \"\",\n" +
            "        \"title\": \"【招商宏观】总 的视野:宏观固收策  融地产联席电话会议纪要2017.04.16\",\n" +
            "        \"uri\": \"https://wallstreetcn.com/articles/3004520\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"next_cursor\": \"1492406593,1492401282\"\n" +
            "  }\n" +
            "}";

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test_01() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("platform", "wscn-platform");
        params.put("category", "china");
        params.put("limit", "200");
        final RestResponse<ArticleItemsDTO> response = restTemplate.exchange("https://dedicated-sit.wallstreetcn.com/api/v2/free/padx/articles", HttpMethod.GET, null, new ParameterizedTypeReference<RestResponse<ArticleItemsDTO>>() {
        }).getBody();
        LOGGER.info("call http code: {}", response.getCode());
        LOGGER.info("call http message: {}", response.getMessage());
        if (response != null && !CollectionUtils.isEmpty(response.getData().getItems())) {
            response.getData().getItems().forEach(item -> LOGGER.info("id: {}, title: {}", item.getId(), item.getTitle()));
        }
    }

    @Test
    public void test_02() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("platform", "wscn-platform");
        params.put("category", "china");
        params.put("limit", "200");
        final RestResponse<ArticleItemsDTO> response = restTemplate.exchange("https://dedicated-sit.wallstreetcn.com/api/v2/free/padx/articles/updates", HttpMethod.GET, new HttpEntity<>(params), new ParameterizedTypeReference<RestResponse<ArticleItemsDTO>>() {
        }).getBody();
        LOGGER.info("call http code: {}", response.getCode());
        LOGGER.info("call http message: {}", response.getMessage());
        if (response != null && !CollectionUtils.isEmpty(response.getData().getItems())) {
            response.getData().getItems().forEach(item -> LOGGER.info("id: {}, title: {}", item.getId(), item.getTitle()));
        }
    }

    @Test
    public void test_03() throws Exception {
        final RestResponse<ArticleDTO> response = restTemplate.exchange("https://dedicated-sit.wallstreetcn.com/api/v2/free/padx/articles/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<RestResponse<ArticleDTO>>() {
        }, "100000350101").getBody();
        LOGGER.info("call http code: {}", response.getCode());
        LOGGER.info("call http message: {}", response.getMessage());
        LOGGER.info("文章详情: {}", response.getData().getContent());
    }

    @Test
    public void test_04() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        final RestResponse restResponse = objectMapper.readValue(json, RestResponse.class);
        LOGGER.info(restResponse.getCode());
    }

    public static String getStringFromStream(InputStream in) throws Exception {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
        reader.close();
        return buffer.toString();
    }
}
