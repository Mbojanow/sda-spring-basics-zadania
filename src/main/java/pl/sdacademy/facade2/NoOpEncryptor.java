package pl.sdacademy.facade2;

public class NoOpEncryptor implements Encryptor {
  @Override
  public String encrypt(final String toEncrypt) {
    return toEncrypt;
  }
}
