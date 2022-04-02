package org.chobit.common.codec;

import org.junit.Test;

/**
 * @author robin
 */
public class UnicodeTest {

    @Test
    public void encode() {
        String s = "世界,你好";
        String result = Unicode.encode(s);
        System.out.println(result);

    }


    @Test
    public void decode() {
        String src = "{\"code\":80101,\"message\":\"\\u8d26\\u6237\\u4e0d\\u5b58\\u5728\\uff1b\"}";
        String origen = Unicode.decode(src);
        System.out.println(origen);
    }
}
