package entity;

import lombok.Data;
import lombok.ToString;

/**
 * 返回结果实体
 * @author chenshuai
 */
@Data
@ToString
public class Result {
    /** 是否成功 **/
    private boolean flag;
    /** 返回码 **/
    private Integer code;
    /** 返回信息 **/
    private String message;
    /** 返回数据 **/
    private Object data;

    public Result(boolean flag, Integer code, String message, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {}

    public Result(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
    public boolean isFlag() {
        return flag;
    }
}
