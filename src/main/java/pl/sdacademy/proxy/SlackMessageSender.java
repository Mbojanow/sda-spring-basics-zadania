package pl.sdacademy.proxy;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SlackMessageSender implements MessageSender {

  private final List<Message> messages = new ArrayList<>();

  @Override
  public void sendMessage(final String channelName, final String username, final String messageText) {
    final Message message = new Message(channelName, username, messageText);
    log.info("Sent message {}", message);
    messages.add(message);
    log.info("Messages: {}", messages);
  }
}
