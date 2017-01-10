package net.woniper.api.naver;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by woniper on 2017. 1. 10..
 */
public class SearchApiTest {
    private static final String CLIENT_ID = "input your client_id";
    private static final String CLIENT_SECRET = "input your client_secret";
    private static final String URL = "https://openapi.naver.com/v1/search/book_adv.json";

    private HttpEntity<?> headers;
    private RestTemplate template = new RestTemplate();

    @Before
    public void setUp() throws Exception {
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("X-Naver-Client-Id", CLIENT_ID);
        headerMap.add("X-Naver-Client-Secret", CLIENT_SECRET);
        headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        this.headers = new HttpEntity<>(headerMap);
    }

    @Test
    public void requestString() throws Exception {
        String url = URL + "?d_titl=java&display=5";
        ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET, headers, String.class);
        assertThat(responseEntity).isNotNull();

        String body = responseEntity.getBody();
        assertThat(body).isNotNull();
    }

    @Test
    public void requestJson() throws Exception {
        String url = URL + "?d_titl=java&display=5";
        ResponseEntity<NaverBook> responseEntity = template.exchange(url, HttpMethod.GET, headers, NaverBook.class);
        assertThat(responseEntity).isNotNull();

        NaverBook body = responseEntity.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getDisplay()).isNotNull();
        assertThat(body.getDisplay()).isEqualTo(5);
        assertThat(body.getLastBuildDate()).isNotNull();
        assertThat(body.getStart()).isNotNull();
        assertThat(body.getTotal()).isNotNull();
        assertThat(body.getItems()).isNotNull().isNotEmpty();
        assertThat(body.getItems().size()).isEqualTo(5);
    }
}
