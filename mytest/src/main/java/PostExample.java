import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class PostExample {
 
    static final String URL_CREATE_EMPLOYEE = "http://localhost:9999/oauth/token";
    RestTemplate restTemplate = new RestTemplate();
    
    public static void main(String[] args) throws Exception {
		PostExample PE = new PostExample();
		String token = null;
		try {
		PE.requestLogin(token);

		} catch (Exception e) {
			token = PE.getAccessTocken();
			PE.requestLogin(token);
		}
    }
    
    public String getAccessTocken() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        String auth = "foo:bar";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));

        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

 		HttpEntity<String> request = new HttpEntity<String>(headers);

 		String access_token_url = "http://localhost:9999/oauth/token";
 		access_token_url += "?grant_type=password";
 		access_token_url += "&client_id=foo";
 		access_token_url += "&scope=read";
 		access_token_url += "&username=user";
 		access_token_url += "&password=test";

 		ResponseEntity<String> response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

 		System.out.println("Access Token Response ---------" + response.getBody());
 		
 		ObjectMapper mapper = new ObjectMapper();
 		JsonNode node = mapper.readTree(response.getBody());
 		String token = node.path("access_token").asText();

 		System.out.println("Access Token: " + token);
		return token;
    }
    
    public void requestLogin(String token) {
		String url = "http://localhost:9999/login";

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers1);

		ResponseEntity<String> employees = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		System.out.println(employees.getBody());
    }
}