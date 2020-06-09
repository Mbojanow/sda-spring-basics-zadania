package pl.sdacademy.proxy;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;

@Slf4j
public class SlackMessageSenderProxy implements MessageSender {

  private final MessageSender messageSender;
  private final SessionTokens sessionTokens;
  private final TokenValidator tokenValidator;

  public SlackMessageSenderProxy(final MessageSender messageSender, final SessionTokens sessionTokens, final TokenValidator tokenValidator) {
    this.messageSender = messageSender;
    this.sessionTokens = sessionTokens;
    this.tokenValidator = tokenValidator;
  }

  @Override
  public void sendMessage(final String channelName, final String username, final String message) {
    final Optional<UUID> userTokenOptional = sessionTokens.getUserToken(username);
    if (userTokenOptional.isPresent()) {
      final UUID existingToken = userTokenOptional.get();
      if (!tokenValidator.isExpired(existingToken)) {
        messageSender.sendMessage(channelName, username, message);
      }
    } else {
      log.info("Message from {} not sent to channel {} because user has no valid access token", username, channelName);
    }
  }
}
