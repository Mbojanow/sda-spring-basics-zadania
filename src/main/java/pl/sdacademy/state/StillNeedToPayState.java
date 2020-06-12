package pl.sdacademy.state;

public class StillNeedToPayState implements ParkingTicketVendingMachineState {

  private final ParkingTicketVendingMachine machine;

  public StillNeedToPayState(final ParkingTicketVendingMachine machine) {
    this.machine = machine;
  }

  @Override
  public void moveCreditCardToSensor() {
    machine.payForOneHourWithCreditCard();
  }

  @Override
  public void pressPrintingButton() {
    machine.setMessage("You to pay first");
  }

  @Override
  public void openMachineAndAddPrintingPaperPieces() {
    machine.setMessage("Only authorized personel can add paper");
  }
}
