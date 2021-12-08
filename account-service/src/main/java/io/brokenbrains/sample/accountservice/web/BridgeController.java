package io.brokenbrains.sample.accountservice.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bridge")
public class BridgeController {
    @Value("${config.server.bridge.customer}")
    private String serverUrl;

    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getCustomer(@PathVariable Long id) throws Exception{
        logger.info("URL:/api/customers Method:GET PathVariable= {}", id);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(serverUrl+"/api/customers/"+id)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(response.body().string(), HttpStatus.OK);
        logger.info("URL:/api/accounts Method:GET Response= {}", responseEntity);
        return responseEntity;
    }
}
