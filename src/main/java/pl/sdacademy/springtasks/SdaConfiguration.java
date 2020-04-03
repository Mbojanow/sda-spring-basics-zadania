package pl.sdacademy.springtasks;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "pl.sdacademy.zad6")
public class SdaConfiguration {

  private Boolean enabled;
  private String key;
  private String value;
}
