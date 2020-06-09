package pl.sdacademy.facade;

public interface PaymentService {
  void pay(Long productId, int amount);
}
