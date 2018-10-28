package vo;

import java.io.Serializable;

/**
 * Created by weicheng on 2018/9/4.
 */
public class Condition implements Serializable {

    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
