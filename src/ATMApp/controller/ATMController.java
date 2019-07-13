/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMApp.controller;

/**
 *
 * @author Azukhrufy
 */
import ATMApp.model.CashDispenser;
import ATMApp.DepositSlot;
import ATMApp.Keypad;
import ATMApp.Screen;
import ATMApp.Transfer;
import ATMApp.view.ATMView;


public class ATMController {
    private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot;
   private int AccountNumberTujuan;
   private BankDatabase bankDatabase; // account information database
   private ATMView view;
   
   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int TRANSFER = 4;
   private static final int EXIT = 5;
   
   public ATMController(){
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 1; // no current account number to start
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
      view = new ATMView();
   }
    
    public void run() {
      // welcome and authenticate user; perform transactions
      while (true) {
         // loop while user is not yet authenticated
         while (!userAuthenticated) {
            view.displayMessage("welcome");
            authenticateUser(); // authenticate user
         }
         
         performTransactions(); // user is now authenticated
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session
         view.displayMessage("goodbye");
      }
   }
    
    private void authenticateUser() {
      view.displayMessage("accnumber");
      int accountNumber = keypad.getInput(); // input account number
      view.displayMessage("pin");
      int pin = keypad.getInput(); // input PIN
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser(accountNumber, pin);
      // check whether authentication succeeded
      if (userAuthenticated) {
         currentAccountNumber = accountNumber; // save user's account #
      } 
      else {
         view.displayMessage("invalid");
      } 
   } 
    
    private void performTransactions() {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while (!userExited) {
         // show main menu and get user selection
         int mainMenuSelection = MainMenu();

         // decide how to proceed based on user's menu selection
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY:         

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
               break; 
            
               //Langkah 3 Menambahkan case untuk menu kedua
               //dengan format isi seperti case yang pertama
            case WITHDRAWAL:
                //create transaction masih belum dibuat casenya sehingga tambahkan dulu
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute();
            break;
            
            case DEPOSIT:
                //create transaction masih belum dibuat casenya sehingga tambahkan dulu
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute();
            break;
            case TRANSFER:
                //create transaction masih belum dibuat casenya sehingga tambahkan dulu
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute();
            break;
            case EXIT: // user chose to terminate session
                view.displayMessage("exit");
               userExited = true; // this ATM session should end
               break;
            default: // 
               view.displayMessage("ulangi");
               break;
         }
      } 
   } 
    
    private int MainMenu() {
      view.displayMainMenu();
      return keypad.getInput(); // return user's selection
   } 
    
    private Transaction createTransaction(int type) {
      Transaction temp = null; 
          
      switch (type) {
         case BALANCE_INQUIRY: 
            temp = new BalanceInquiryController(
               currentAccountNumber, screen, bankDatabase);
            break;
         //langkah 4 
         //menambahkan withdrawal dan menginstansiasikan temp sebagai withdrawal.
         case WITHDRAWAL:
             temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
             break;
         
         case DEPOSIT:
             temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad,depositSlot);
             break;
             
         case TRANSFER:
             temp = new Transfer(currentAccountNumber, screen, bankDatabase, keypad, AccountNumberTujuan);
             break;
      }

      return temp;
   } 
}
