package org.chobit.common.utils;

import org.chobit.common.http.HttpResult;
import org.junit.Test;

import java.util.Map;

/**
 * @author robin
 */
public class ReflectionUtilsTest {


    @Test
    public void toMap() {
        HttpResult result = new HttpResult(200, "content");
        result.setErrMsg("12333");

        Map<String, Object> map = ReflectionUtils.toMap(result);
        String json = JsonKit.toJson(map);
        System.out.println(json);
    }


}
