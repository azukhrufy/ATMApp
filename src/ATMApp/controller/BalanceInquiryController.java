/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.controller;

import ATMApp.Screen;
import ATMApp.view.BalanceInquiryView;

/**
 *
 * @author Azukhrufy
 */
public class BalanceInquiryController extends Transaction {
    BalanceInquiryView view;
   // BalanceInquiry constructor
   public BalanceInquiryController(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase) {

      super(userAccountNumber, atmScreen, atmBankDatabase);
      view = new BalanceInquiryView();
   } 

   // performs the transaction
   @Override
   public void execute() {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance(getAccountNumber());

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance(getAccountNumber());
      
      // display the balance information on the screen
      view.displayBalanceInquiry("available");
      screen.displayDollarAmount(availableBalance);
      view.displayBalanceInquiry("total");
      screen.displayDollarAmount(totalBalance);
      
   }
} 
