package org.chobit.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.chobit.common.utils.LocalDateKit;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author robin
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {


    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(LocalDateKit.formatTime(value));
    }
    
}
