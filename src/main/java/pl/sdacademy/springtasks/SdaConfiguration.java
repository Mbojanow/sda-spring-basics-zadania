package pl.sdacademy.springtasks;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Configuration
@ConfigurationProperties(prefix = "pl.sdacademy.zad6")
@Validated
public class SdaConfiguration {

  private Boolean enabled;

  @Length(min = 3)
  private String key;

  @Length(min = 1, max = 25)
  private String value;

  @NotNull(message = "count cannot be null")
  @Min(3)
  private Integer count;
}
