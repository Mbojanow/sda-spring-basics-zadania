package pl.sdacademy.facade2;

public class SCryptEncryptor implements Encryptor {
  @Override
  public String encrypt(final String toEncrypt) {
    return "encrypting " + toEncrypt + "with SCrypt";
  }
}
