package ATMApp.controller;

import ATMApp.Screen;
import ATMApp.controller.BankDatabase;

public abstract class Transaction {
   int accountNumber; // indicates account involved
   public Screen screen; // ATM screen
   public BankDatabase bankDatabase; // account database 
   public Transaction(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase) {

      accountNumber = userAccountNumber;
      screen = atmScreen;
      bankDatabase = atmBankDatabase;
   }
   // return account number 
   public int getAccountNumber() {
      return accountNumber; 
   } 
   // return reference to screen
   public Screen getScreen() {
      return screen;
   } 
   // return reference to bank database
   public BankDatabase getBankDatabase() {
      return bankDatabase;
   } 
   // perform the transaction (overridden by each subclass)
   abstract public void execute();
}