package cc.orcl.obj.model;

import lombok.Data;

import java.util.List;

/**
 * @author：czx.me 2024/7/28
 */
@Data
public class PagedResult<T> {
    private List<T> records;
    private int current;
    private int size;
    private long total;
    private long pages;

}
