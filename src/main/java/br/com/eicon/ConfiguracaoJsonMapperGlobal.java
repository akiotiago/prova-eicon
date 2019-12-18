package br.com.eicon;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
public class ConfiguracaoJsonMapperGlobal {

	@Value("${config.default.data.pattern}")
	private String dataDefault;
	@Value("${config.default.datahora.pattern}")
	private String dataHoraDefault;
	 
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer configuracaoJson() {
        return builder -> {
            builder.simpleDateFormat(dataHoraDefault);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dataDefault)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dataHoraDefault)));
        };
    }
	 
}
