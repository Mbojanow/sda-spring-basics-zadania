package pl.sdacademy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GraphicsCard {
  private int memoryInMb;
  private String producer;
  private String series;
  private String modelName;
}
