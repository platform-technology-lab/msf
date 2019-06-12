import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HttpConnectionExample {
    /**
     * POST 요청
     * @param url       요청할 url
     * @param params    파라메터
     * @param encoding  파라메터 Encoding
     * @return 서버 응답결과 문자열
     */
    public String post(String url, Map params, String encoding){
        HttpClient client = new DefaultHttpClient();
         
        try{
            
//        	 String encod = Base64Encoder.encode("foo:bar");
        	 String encod = Base64.getEncoder().encodeToString(("foo:bar").getBytes());
            HttpPost post = new HttpPost(url);
            System.out.println("POST : " + post.getURI());
            post.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + encod);
             
//            post.addHeader("grant_type", "password");
//            post.addHeader("client_id", "foo");
//            post.addHeader("username", "user");
//            post.addHeader("password", "test");
//            post.addHeader("scope", "read");
             
            List<NameValuePair> paramList = convertParam(params);
            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
             
            System.out.println("executing request " + post.getRequestLine());
 //           ResponseHandler<String> rh = new BasicResponseHandler();
 
//            return client.execute(post, rh);
              HttpResponse response = client.execute(post);
              
              BufferedReader breader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
              StringBuilder responseString = new StringBuilder();
              String line = "";
              while ((line = breader.readLine()) != null) {
                  responseString.append(line);
              }
              breader.close();
              String repsonseStr = responseString.toString();

              System.out.println("repsonseStr = " + repsonseStr);
              
            return response.toString();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            client.getConnectionManager().shutdown();
        }
        return "error";
    }
     
    public String post(String url, Map params){
        return post(url, params, "UTF-8");
    }
 
     
     
     
    /**
     * GET 요청
     * POST 와 동일
     */
    public String get(String url, Map params, String encoding){
        HttpClient client = new DefaultHttpClient();
 
        try{
            List<NameValuePair> paramList = convertParam(params);
            HttpGet get = new HttpGet(url+"?"+URLEncodedUtils.format(paramList, encoding));
            System.out.println("GET : " + get.getURI());
             
            ResponseHandler<String> rh = new BasicResponseHandler();
             
            return client.execute(get, rh);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            client.getConnectionManager().shutdown();
        }
        return "error";
    }
     
    public String get(String url, Map params){
        return get(url, params, "UTF-8");
    }
     
     
     
    private List<NameValuePair> convertParam(Map params){
        List<NameValuePair> paramList = new ArrayList<NameValuePair>();
        Iterator<String> keys = params.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            paramList.add(new BasicNameValuePair(key, params.get(key).toString()));
        }
         
        return paramList;
    }
     
     
 
    // Test
    public static void main(String[] args) {
    	HttpConnectionExample p = new HttpConnectionExample();
         
//        Map params = new HashMap();
//        System.out.println(p.post("http://localhost:9999/login", params));
        
    	 Map params = new HashMap();
    	 params.put("grant_type", "password");
    	 params.put("client_id", "foo");
    	 params.put("client_secret", "bar");
    	 params.put("username", "user");
    	 params.put("password", "test");
    	 params.put("scope", "read");
         
        System.out.println(p.post("http://localhost:9999/oauth/token", params));
    }
}
