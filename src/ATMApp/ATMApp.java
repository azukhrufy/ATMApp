/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp;

import ATMApp.controller.ATMController;
import ATMApp.view.ATMView;

/**
 *
 * @author Azukhrufy
 */
public class ATMApp {
   // main method creates and runs the ATM
   public static void main(String[] args) {
      ATMController theATM = new ATMController();    
      theATM.run();
   }
}
