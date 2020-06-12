package pl.sdacademy.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectOptions implements Component {

  private Mediator mediator;

  public void setMediator(final Mediator mediator) {
    this.mediator = mediator;
  }

  public void displayOptions() {
    log.info("Options are: Save, Load, Restart");
  }

  public void chooseSave() {
    log.info("Status was saved");
  }

  public void chooseLoad() {
    log.info("Loading previous data");
  }

  public void chooseRestart() {
    log.info("Status is restarting");
  }

  public void hideOptions() {
    log.info("Hiding options");
  }

  @Override
  public void sendRequest() {
    mediator.sendInfo(this, "displayOptions");
  }

  @Override
  public void sendRequest(final String context) {
    mediator.sendInfo(this, context);
  }
}
