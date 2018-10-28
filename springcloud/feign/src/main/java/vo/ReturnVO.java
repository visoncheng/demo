package vo;

import java.io.Serializable;

/**
 * Created by weicheng on 2018/9/4.
 */
public class ReturnVO implements Serializable {

    private boolean success;

    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
