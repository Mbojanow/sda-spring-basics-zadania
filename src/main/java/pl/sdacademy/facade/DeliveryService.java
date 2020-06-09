package pl.sdacademy.facade;

public interface DeliveryService {
  void deliverProduct(Long productsId, int amount, String recipient);
}
