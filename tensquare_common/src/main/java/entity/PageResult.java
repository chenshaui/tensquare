package entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;


/**
 * 分页返回结果
 * @author chenshuai
 */
@Data
@ToString
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
}
