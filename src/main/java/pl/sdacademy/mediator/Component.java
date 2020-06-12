package pl.sdacademy.mediator;

public interface Component {
  void sendRequest();

  default void sendRequest(String context) {
    sendRequest();
  }
}
