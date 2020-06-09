package pl.sdacademy.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoffeePurchase extends Coffee {

  public Drink buy(final Double cost) {
    log.info("Buying a a coffee for {}", cost);
    return new Coffee();
  }
}
