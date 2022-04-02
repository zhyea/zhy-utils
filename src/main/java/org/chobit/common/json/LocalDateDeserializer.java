package org.chobit.common.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.chobit.common.utils.LocalDateKit;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robin
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {


    private static final int LEN_LOCAL_DATE_ARR = 3;


    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
        if (p.getCurrentToken() == JsonToken.START_ARRAY) {
            return deserializeFromArray(p);
        }
        return LocalDateKit.parseDate(p.getText());
    }


    private LocalDate deserializeFromArray(JsonParser p) throws IOException {
        List<Integer> arr = new LinkedList<>();
        while (true) {
            JsonToken t = p.nextToken();
            switch (t) {
                case VALUE_NUMBER_INT:
                    arr.add(p.getIntValue());
                    break;
                case END_ARRAY:
                    return localDateOf(arr);
                default:
                    return null;
            }
        }
    }


    /**
     * 根据数组生成LocalDate实例
     *
     * @param arr 数组
     * @return LocalDate实例
     */
    private LocalDate localDateOf(List<Integer> arr) {
        if (arr.size() < LEN_LOCAL_DATE_ARR) {
            return null;
        }
        return LocalDate.of(arr.get(0), arr.get(1), arr.get(2));
    }

}
