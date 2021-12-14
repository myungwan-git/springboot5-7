package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

  @Test
  void formattingConversionService() {
    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

    conversionService.addConverter(new StringToIpPortConverter());
    conversionService.addConverter(new IpPortToStringConverter());

    conversionService.addFormatter(new MyNumberFormatter());

    IpPort convert = conversionService.convert("127.0.0.1:8080", IpPort.class);
    assertThat(convert).isEqualTo(new IpPort("127.0.0.1", 8080));

    String convert1 = conversionService.convert(1000, String.class);
    assertThat(convert1).isEqualTo("1,000");

    Long convert2 = conversionService.convert("1,000", Long.class);
    assertThat(convert2).isEqualTo(1000);
  }
}
