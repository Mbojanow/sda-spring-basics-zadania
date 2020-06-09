package pl.sdacademy;

public class LombokBuilderUsage {
  public static void main(String[] args) {
    GraphicsCard graphicsCard = GraphicsCard.builder()
        .memoryInMb(2048)
        .modelName("GF1660")
        .producer("Asus")
        .series("1xxx")
        .build();
  }
}
