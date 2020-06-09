package pl.sdacademy.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeaPurchase implements DrinkPurchase {

  @Override
  public Drink buy(final Double cost) {
    log.info("Buying a a tea for {}", cost);
    return new Tea();
  }
}
