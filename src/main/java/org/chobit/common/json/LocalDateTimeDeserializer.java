package org.chobit.common.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.chobit.common.utils.JsonKit;
import org.chobit.common.utils.LocalDateKit;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robin
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    /**
     * 时间起始标识符
     */
    private static final String ISO_FLAG_TIME = "T";

    /**
     * 含ISO时间起始标识符的字符串的长度
     */
    private static final int ISO_FLAG_TIME_LENGTH = "2021-06-24T17:02:43".length();

    /**
     * 含ISO时间起始标识符及毫秒时间的字符串的长度
     */
    private static final int ISO_FLAG_TIME_MILLIS_LENGTH = "2021-06-24T17:02:43.425".length();

    /**
     * LocalDateTime序列化后的数组字符串
     */
    private static final int ORIGEN_LOCALTIME_STR_LENGTH = "[2021,6,29,12,18,39,97000000]".length();

    /**
     * LocalDateTime序列化后的数组
     */
    private static final int LOCALTIME_ARR_LENGTH = 7;
    /**
     * 时区标识符
     */
    private static final String ISO_FLAG_TIMEZONE = "Z";

    /**
     * 含ISO时间起始标识符及毫秒的日期时间格式
     */
    private static final String PATTERN_DATETIME_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    /**
     * 含ISO时间起始标识符的日期时间格式
     */
    private static final String PATTERN_DATETIME_ISO_FLAG = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * 含ISO时间起始标识符及时区标识符的日期时间格式
     */
    private static final String PATTERN_DATETIME_ISO_FLAG_TZ = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * 数组起始标识符
     */
    private static final String FLAG_ARRAY_START = "[";

    /**
     * 数组结束标识符
     */
    private static final String FLAG_ARRAY_END = "]";

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctx) throws IOException {

        if (p.getCurrentToken() == JsonToken.START_ARRAY) {
            return deserializeFromArray(p);
        }
        if (p.getCurrentToken().isNumeric()) {
            return LocalDateKit.fromEpochMilli(p.getLongValue());
        }
        String str = p.getText();

        return deserializeFromStr(str.trim());
    }

    /**
     * 从字符串反序列化LocalDateTime
     *
     * @param str 原始字符串
     * @return LocalDateTime实例
     */
    private LocalDateTime deserializeFromStr(String str) {
        if (str.contains(ISO_FLAG_TIME) && str.contains(ISO_FLAG_TIMEZONE)) {
            return LocalDateKit.parseTime(PATTERN_DATETIME_ISO_FLAG_TZ, str);
        }
        if (str.contains(ISO_FLAG_TIME) && str.length() == ISO_FLAG_TIME_LENGTH) {
            return LocalDateKit.parseTime(PATTERN_DATETIME_ISO_FLAG, str);
        }
        if (str.contains(ISO_FLAG_TIME) && str.length() == ISO_FLAG_TIME_MILLIS_LENGTH) {
            return LocalDateKit.parseTime(PATTERN_DATETIME_MILLIS, str);
        }
        if (str.startsWith(FLAG_ARRAY_START) && str.endsWith(FLAG_ARRAY_END) && str.length() == ORIGEN_LOCALTIME_STR_LENGTH) {
            List<Integer> arr = JsonKit.fromJson(str, new TypeReference<List<Integer>>() {
            });
            return localDateTimeOf(arr);
        }
        return LocalDateKit.parseTime(str);
    }


    /**
     * 从整型数组反序列化LocalDateTime
     *
     * @param p JsonParser实例
     * @return LocalDateTime实例
     * @throws IOException 异常
     */
    private LocalDateTime deserializeFromArray(JsonParser p) throws IOException {
        List<Integer> arr = new LinkedList<>();
        while (true) {
            JsonToken t = p.nextToken();
            switch (t) {
                case VALUE_NUMBER_INT:
                    arr.add(p.getIntValue());
                    break;
                case END_ARRAY:
                    return localDateTimeOf(arr);
                default:
                    return null;
            }
        }
    }


    /**
     * 通过数组创建LocalDateTime实例
     *
     * @param arr 数组
     * @return LocalDateTime实例
     */
    private LocalDateTime localDateTimeOf(List<Integer> arr) {
        if (null == arr || arr.size() != LOCALTIME_ARR_LENGTH) {
            return null;
        }
        return LocalDateTime.of(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), arr.get(5), arr.get(6));
    }
}
