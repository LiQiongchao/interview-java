package com.newlycode.interview;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

/**
 * @author Liqc
 * @date 2020/6/1 11:31
 */
public class JsonUtilTest {

    /**
     * 要解析的字符串不能为空，至少要包含一对大括号，否则会报错
     */
    @Test
    public void gsonParseTest() {
        Gson gson = new Gson();
        BaseResponse response = gson.fromJson("{}", new TypeToken<BaseResponse<String>>() {
        }.getType());
        System.out.println(response.toString());
    }

}

@Setter
@Getter
@ToString
class BaseResponse<T> {
    private String code;
    private String msg;
    private T data;
}
