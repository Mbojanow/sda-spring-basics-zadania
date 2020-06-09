package pl.sdacademy.facade2;

public class BCryptEncryptor implements Encryptor {
  @Override
  public String encrypt(final String toEncrypt) {
    return "encrypting " + toEncrypt + "with BCrypt";
  }
}
