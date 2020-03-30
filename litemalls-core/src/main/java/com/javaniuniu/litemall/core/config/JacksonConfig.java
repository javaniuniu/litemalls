package com.javaniuniu.litemall.core.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 定制 序列化和反序列化，并对返回参考做处理
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/30 12:50 PM
 */
@Configuration
public class JacksonConfig {
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Jackson2ObjectMapperBuilderCustomizer customJackson(){
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
                // 指定序列化于反序列化
                builder.serializerByType(LocalDateTime.class,
                        new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                builder.serializerByType(LocalDate.class,
                        new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                builder.serializerByType(LocalTime.class,
                        new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
                builder.deserializerByType(LocalDateTime.class,
                        new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                builder.deserializerByType(LocalDate.class,
                        new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                builder.deserializerByType(LocalTime.class,
                        new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
                // 返回的value中  null不返回
                builder.serializationInclusion(JsonInclude.Include.NON_NULL);
                // 对陌生的参考不处理
                builder.failOnUnknownProperties(false);//默认开启
                //禁止Date类型转化为时间戳。
                builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            }
        };
    }
}
