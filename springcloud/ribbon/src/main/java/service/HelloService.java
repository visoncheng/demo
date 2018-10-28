package service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by weicheng on 2018/9/2.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hifail")
    public String hiService(String name) {
        return restTemplate.getForObject("http://client/hi?name=" + name,String.class);
    }

    public String hifail(String name) {
        return "hi fail";
    }
}
