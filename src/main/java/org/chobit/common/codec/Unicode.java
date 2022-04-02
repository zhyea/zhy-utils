package org.chobit.common.codec;

import org.chobit.common.utils.StrKit;

/**
 * Unicode 处理工具类
 *
 * @author robin
 */
public final class Unicode {

    private static final String FLAG_UNICODE = "\\u";

    /**
     * 字符串编码成Unicode编码
     *
     * @param str 原始字符串
     * @return 生成的Unicode字符串
     */
    public static String encode(String str) {
        if (StrKit.isBlank(str)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            builder.append(FLAG_UNICODE).append(Integer.toHexString(c));
        }
        return builder.toString();
    }

    /**
     * Unicode解码成字符串
     *
     * @param src （含）Unicode的字符串
     * @return 解码后的字符串
     */
    public static String decode(String src) {
        if (StrKit.isBlank(src)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int idx = -1;
        int pos = 0;
        while ((idx = src.indexOf(FLAG_UNICODE, pos)) != -1) {
            builder.append(src, pos, idx);
            if (idx + 5 < src.length()) {
                pos = idx + 6;
                char c = (char) Integer.parseInt(src.substring(idx + 2, idx + 6), 16);
                builder.append(c);
            }
        }
        if (pos <= src.length() - 1) {
            builder.append(src.substring(pos));
        }
        return builder.toString();
    }


    private Unicode() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }

}
