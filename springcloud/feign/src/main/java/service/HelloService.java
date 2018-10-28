package service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import service.hystric.HelloServiceHystric;
import vo.Condition;
import vo.ReturnVO;

/**
 * Created by weicheng on 2018/9/2.
 */
@FeignClient(value = "client",fallback = HelloServiceHystric.class)
public interface HelloService {

    @GetMapping(value="hi")
    String hi(@RequestParam(value="name") String name);

    @PostMapping(value="post")
    ReturnVO post(@RequestBody Condition condition);
}
