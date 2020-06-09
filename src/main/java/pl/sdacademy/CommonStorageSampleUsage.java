package pl.sdacademy;

public class CommonStorageSampleUsage {
  public static void main(String[] args) {
    CommonStorage commonStorageA = CommonStorage.getInstance();
    CommonStorage commonStorageB = CommonStorage.getInstance();
    System.out.println(commonStorageA == commonStorageB); // true

    commonStorageA.addValue(1);
    commonStorageB.addValue(2);
    System.out.println(commonStorageA.getValues().size()); // rozmiar listy wynosi 2
  }
}
