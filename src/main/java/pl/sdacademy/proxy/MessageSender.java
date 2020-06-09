package pl.sdacademy.proxy;

public interface MessageSender {
  void sendMessage(String channelName, String username, String message);
}
