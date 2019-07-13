/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.view;

import ATMApp.controller.BalanceInquiryController;
import ATMApp.Screen;

/**
 *
 * @author Azukhrufy
 */
public class BalanceInquiryView {
    private Screen screen;
    private BalanceInquiryController get;
    
    public BalanceInquiryView(){
        screen = new Screen();
    }
    
    public void displayBalanceInquiry(String type){
      if(type == "available"){
      screen.displayMessageLine("\nBalance Information:");
      screen.displayMessage(" - Available balance: "); 
      } else if(type == "total"){
      screen.displayMessage("\n - Total balance:     ");
      }
      screen.displayMessageLine("");
    }
}
