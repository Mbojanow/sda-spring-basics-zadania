package pl.sdacademy.abstractfactory;

public interface CarFactory {
  Car createSedan();
  Car createCombi();
  Car createHatchback();
}
