/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.view;

import ATMApp.controller.BalanceInquiryController;
import ATMApp.controller.BankDatabase;
import ATMApp.model.CashDispenser;
import ATMApp.controller.Deposit;
import ATMApp.DepositSlot;
import ATMApp.Keypad;
import ATMApp.Screen;
import ATMApp.controller.Transaction;
import ATMApp.Transfer;
import ATMApp.controller.Withdrawal;

/**
 *
 * @author Azukhrufy
 */
public class ATMView {
   private Screen screen; // ATM's screen
 
   // no-argument ATM constructor initializes instance variables
   public ATMView() {
      screen = new Screen(); // create screen
   }   
   public void displayMessage(String type){
       if(type == "welcome"){
           screen.displayMessageLine("\nWelcome!"); 
       } else if(type == "goodbye"){
           screen.displayMessageLine("\nThank you! Goodbye!");
       } else if(type == "accnumber"){
           screen.displayMessage("\nPlease enter your account number: ");
       } else if(type == "pin"){
           screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
       } else if(type == "invalid"){
           screen.displayMessageLine(
            "Invalid account number or PIN. Please try again.");
       } else if(type == "exit"){
           screen.displayMessageLine("\nExiting the system...");
       } else if(type == "ulangi"){
           screen.displayMessageLine(
                  "\nYou did not enter a valid selection. Try again.");
       }
   }
   
//   public void run2(){
//       searchUser();
//   }


//   private void searchUser(){
//       screen.displayMessage("\nPlease enter account number Tujuan: ");
//      int accountNumber = keypad.getInput();
//      
//      userAuthenticated = 
//         bankDatabase.hasilSearchAccount(accountNumber);
//      if(userAuthenticated){
//          screen.displayMessageLine(
//            "Account Ditemukan.");
//      }else{
//          screen.displayMessageLine(
//            "Account Tidak Ditemukan.");
//      }
//   }

   // display the main menu and return an input selection
   public void displayMainMenu() {
      screen.displayMessageLine("\nMain menu:");
      screen.displayMessageLine("1 - View my balance");
      screen.displayMessageLine("2 - Withdraw cash");
      screen.displayMessageLine("3 - Deposit funds");
      screen.displayMessageLine("4 - Transfer");
      screen.displayMessageLine("5 - Exit\n");
      screen.displayMessage("Enter a choice: ");
   } 
         
}
