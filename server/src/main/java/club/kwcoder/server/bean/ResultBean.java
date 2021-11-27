package club.kwcoder.server.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultBean<T> {

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> ResultBean<T> getForbid(String message) {
        return new ResultBean<>(false, 403, message, null);
    }

    public static <T> ResultBean<T> getSuccess(String message, T data) {
        return new ResultBean<>(true, 200, message, data);
    }

}
