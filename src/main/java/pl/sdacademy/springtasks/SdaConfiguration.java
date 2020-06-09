package pl.sdacademy.springtasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated(SdaConfiguration.class)
@Data
@Configuration
@ConfigurationProperties(prefix = "pl.sdacademy.zad6")
@NoArgsConstructor
@AllArgsConstructor
public class SdaConfiguration {

  private Boolean enabled;
  private String key;
  private String value;
}
