package pl.sdacademy.state;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class ParkingTicketVendingMachine {

  private MoneyMachineState state = MoneyMachineState.NEED_PAYMENT;
  private int printingPaperPieces = 100;
  private String message;

  public void setMessage(final String message) {
    this.message = message;
    System.out.println("MESSAGE: " + message);
  }

  public void setState(final MoneyMachineState state) {
    this.state = state;
  }

  public MoneyMachineState getState() {
    return state;
  }

  public int getPrintingPaperPieces() {
    return printingPaperPieces;
  }

  public void addPrintingPaperPieces(final int pieces) {
    if (pieces <= 0) {
      throw new UnsupportedOperationException("Cannot add non positive number of pieces");
    }
    printingPaperPieces += pieces;
    message = "Please pay for the parking";
  }

  public void payForOneHourWithCreditCard() {
    log.info("Paying for parking 5$");
    message = "Please click the button to print the ticket";
  }

  public void printTicket() {
    printingPaperPieces -= 1;
    log.info("Ticket valid thru " + LocalDateTime.now().plusHours(1));
    message = "Ticket printed. Please collect it";
  }

  public void goDown() {
    log.info("Trying to revert last transaction");
    message = "Vending machine is unavailable. Try another one";
  }

}
