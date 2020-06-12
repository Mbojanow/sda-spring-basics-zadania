package pl.sdacademy.state;

public class UnavailableState implements ParkingTicketVendingMachineState {

  private final ParkingTicketVendingMachine machine;

  public UnavailableState(final ParkingTicketVendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void moveCreditCardToSensor() {

  }

  @Override
  public void pressPrintingButton() {

  }

  @Override
  public void openMachineAndAddPrintingPaperPieces() {

  }
}
