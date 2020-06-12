package pl.sdacademy.state;

public class PaidState implements ParkingTicketVendingMachineState {

  private final ParkingTicketVendingMachine machine;

  public PaidState(final ParkingTicketVendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void moveCreditCardToSensor() {
    machine.setMessage("Already paid. Please press button for printout");
  }

  @Override
  public void pressPrintingButton() {
    machine.printTicket();
  }

  @Override
  public void openMachineAndAddPrintingPaperPieces() {
    machine.setMessage("Only authorized personel can add paper");
  }
}
