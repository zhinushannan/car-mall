package club.kwcoder.server.bean;

import lombok.Data;

@Data
public class ResultBean<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

}
