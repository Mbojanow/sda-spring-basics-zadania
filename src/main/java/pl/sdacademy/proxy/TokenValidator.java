package pl.sdacademy.proxy;

import java.util.Random;
import java.util.UUID;

public class TokenValidator {
  boolean isExpired(final UUID token) {
    return new Random().nextBoolean();
  }
}
