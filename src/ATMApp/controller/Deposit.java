/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.controller;

import ATMApp.DepositSlot;
import ATMApp.Keypad;
import ATMApp.Screen;
import ATMApp.controller.BankDatabase;
import ATMApp.view.DepositView;

/**
 *
 * @author Azukhrufy
 */
public class Deposit extends Transaction {
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option
   private DepositView view;

   // Deposit constructor
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
      view = new DepositView();

   } 

   // perform transaction
   @Override
   public void execute() {
       amount = promptForDepositAmount();
       
       if(amount == CANCELED){
           view.displayMessage("cancel");
           
       }
       else{
           super.getBankDatabase().credit(super.getAccountNumber(), amount);
           view.displayMessage("insert");
           super.getScreen().displayDollarAmount(amount);
           screen.displayMessage("Your envelope has been received.\n" +
                   "\n" +"NOTE: The money just deposited will not be available until "
                   + "we verify the amount of any enclosed cash and your checks clear.");

       }
   }

   // prompt user to enter a deposit amount in cents 
   private double promptForDepositAmount() {
      Screen screen = getScreen(); // get reference to screen

      // display the prompt
      view.displayMessage("masukuang");
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return (double) input / 100; // return dollar amount
      }
   }
} 