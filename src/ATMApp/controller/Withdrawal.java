/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.controller;

import ATMApp.Keypad;
import ATMApp.Screen;
import ATMApp.controller.BankDatabase;
import ATMApp.model.CashDispenser;
import ATMApp.view.WithdrawalView;

/**
 *
 * @author Azukhrufy
 */
public class Withdrawal extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser
   private WithdrawalView view;
   

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
      view = new WithdrawalView();
      
   }

   // perform transaction
   @Override
   public void execute() {
       //langkah 5 
       //memanggil function ini untuk menampilkan menu pengambilan uang.
       amount = displayMenuOfAmounts();
       //System.out.println(amount);
      
       if(amount == CANCELED){
           view.display("cancel");
       }
       else{
           if(cashDispenser.isSufficientCashAvailable(amount)){
               if(super.getBankDatabase().getAvailableBalance(super.getAccountNumber())>= amount){
                   cashDispenser.dispenseCash(amount);
                   super.getBankDatabase().debit(super.getAccountNumber(), amount);
               }
           }
           view.display("success");
       }
   } 

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 20, 40, 60, 100, 200};

      
      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the withdrawal menu
         view.displayMenu();
         int input = keypad.getInput(); // get user input through keypad

         // determine how to proceed based on the input value
         //langkah 6
         // mengisi setiap case - case yang ada dengan mengambil contoh case 5.
         switch (input) {
            case 1:
            {
                userChoice = amounts[input];
                break;
            }
            
            case 2: 
            {
                userChoice = amounts[input];
                break;
            }
            case 3: 
            {
                userChoice = amounts[input];
                break;
            }
            case 4:
            {
                userChoice = amounts[input];
                break;
            }
            case 5:
               userChoice = amounts[input]; // save user's choice
               break;       
            case CANCELED: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayMessageLine(
                  "\nInvalid selection. Try again.");
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 
