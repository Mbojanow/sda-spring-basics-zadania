package pl.sdacademy.wzorce.zad8;

public abstract class Observer {

  protected Subject subject;

  public Observer(final Subject subject) {
    this.subject = subject;
    subject.subscribe(this);
  }

  public abstract void update();
}
