package pl.sdacademy.cor;

public interface AuthenticationHandler {
  boolean authenticate(Credentials credentials);
  boolean supports(Class<?> clazz);
}
