package org.chobit.common.utils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.chobit.common.json.LocalDateTimeDeserializer;
import org.chobit.common.json.LocalDateTimeSerializer;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author robin
 */
public class LocalDateTimeJsonTest {


    @Test
    public void toJson() {
        Foo foo = new Foo();
        foo.setTime(LocalDateTime.now());
        System.out.println(JsonKit.toJson(foo));
    }


    @Test
    public void fromJson() {
        String json = "{\"time\":[2021,6,29,12,18,39,97000000]}";
        Foo foo = JsonKit.fromJson(json, Foo.class);
        System.out.println(foo);
    }

    private static class Foo {

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime time;

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "time=" + time +
                    '}';
        }
    }

}
