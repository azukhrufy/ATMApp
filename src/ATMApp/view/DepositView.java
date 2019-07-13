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
public class DepositView {
    Screen screen;
    
    public DepositView(){
        screen = new Screen();
    }

    public void displayMessage(String type){
        if(type == "cancel"){
            screen.displayMessage("Canceling transaction...");
        } else if(type == "insert"){
            screen.displayMessage("Please insert a deposit envelope containing");
        } else if(type == "masukuang"){
            screen.displayMessage("\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): ");
        }
    }
}
