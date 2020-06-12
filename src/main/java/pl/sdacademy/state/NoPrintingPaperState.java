package pl.sdacademy.state;

public class NoPrintingPaperState implements ParkingTicketVendingMachineState {

  private final ParkingTicketVendingMachine machine;

  public NoPrintingPaperState(final ParkingTicketVendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void moveCreditCardToSensor() {
    machine.setMessage("Cannot pay because there is no printing paper");
  }

  @Override
  public void pressPrintingButton() {
    machine.setMessage("Please call 728 123 1234 for additional printing paper");
  }

  @Override
  public void openMachineAndAddPrintingPaperPieces() {
    machine.setMessage("Only authorized personel can add paper");
  }
}
