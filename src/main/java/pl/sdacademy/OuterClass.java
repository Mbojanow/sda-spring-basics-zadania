package pl.sdacademy;

import java.util.List;

public class OuterClass {

  private int outerClassField;

  protected OuterClass(final int outerClassField) {
    this.outerClassField = outerClassField;
  }

  public int getOuterClassField() {
    return outerClassField;
  }

  public static class InnerClass {

    public void innerClassMethod() {
      System.out.println(new OuterClass(3).getOuterClassField());
    }
  }

}
