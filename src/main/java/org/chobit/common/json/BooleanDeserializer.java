package org.chobit.common.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * 自定义Boolean类型异常处理器，处理Boolean类型值异常的问题
 *
 * @author robin
 */
public class BooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext cxt) throws IOException, JsonProcessingException {
        String s = p.getText();
        if ("0".equals(s) || "false".equalsIgnoreCase(s)) {
            return false;
        }
        return "1".equals(s) || "true".equalsIgnoreCase(s);
    }
}
