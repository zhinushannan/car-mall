package club.kwcoder.server.bean;

import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {

    private Integer page;

    private Integer size;

    private Long total;

    private List<T> data;

}
