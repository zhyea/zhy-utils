package org.chobit.common.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robin
 */
public class UrlHelperTest {


    private static final String URL = "";

    @Test
    public void parseQueryParams() {
        Map<String, String> params = UrlHelper.parseQueryParams(URL);
        System.out.println(params);
    }


    @Test
    public void parse() {
        UrlHelper.GetReq params = UrlHelper.parse(URL);
        System.out.println(params);
    }


    @Test
    public void encode() {
        System.out.println(UrlHelper.encode("12:12"));
    }


    @Test
    public void buildQueryStr() {
        String url = "baidu.com?d=4";
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("a", "1");
                put("b", "2");
                put("c", "3");
            }
        };
        String s = UrlHelper.buildQueryStr(url, params);
        System.out.println(s);
    }

}
