package service.hystric;

import org.springframework.stereotype.Component;
import service.HelloService;
import vo.Condition;
import vo.ReturnVO;

/**
 * Created by weicheng on 2018/9/5.
 */
@Component
public class HelloServiceHystric implements HelloService {
    @Override
    public String hi(String name) {
        return "feign hi fail";
    }

    @Override
    public ReturnVO post(Condition condition) {
        return null;
    }
}
