package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import vo.Condition;
import vo.ReturnVO;

import java.util.logging.Logger;

/**
 * TODO
 *
 * @author Patrick.ho
 */
@RestController
@RefreshScope
public class HelloWorldCrontoller {

    @Value("${music}")
    private String music;

    private final Logger logger = Logger.getLogger(HelloWorldCrontoller.class.getName());

    @RequestMapping("/hi")
    public String index(@RequestParam String name){
        return "App name == " + name;
    }

    @GetMapping("/config")
    public String testConfig() {
        return music;
    }

    @PostMapping("/post")
    public ReturnVO post(@RequestBody Condition condition) {
        ReturnVO returnVO = new ReturnVO();
        returnVO.setSuccess(true);
        returnVO.setMsg("哈哈");
        return returnVO;
    }
}
