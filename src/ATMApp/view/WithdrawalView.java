/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.view;

import ATMApp.Screen;

/**
 *
 * @author Azukhrufy
 */
public class WithdrawalView {
    Screen screen;
    
    public WithdrawalView(){
        screen = new Screen();
    }
    
    public void display(String type){
        if(type=="cancel"){
            screen.displayMessageLine("Canceling transaction...");
        } else if(type=="success"){
            screen.displayMessageLine("Your cash has been dispensed.");
            screen.displayMessageLine("Please take your cash now.");
        }
    }
    
    public void displayMenu(){
        screen.displayMessageLine("\nWithdrawal Menu:");
         screen.displayMessageLine("1 - $20");
         screen.displayMessageLine("2 - $40");
         screen.displayMessageLine("3 - $60");
         screen.displayMessageLine("4 - $100");
         screen.displayMessageLine("5 - $200");
         screen.displayMessageLine("6 - Cancel transaction");
         screen.displayMessage("\nChoose a withdrawal amount: ");
    }
    
}
