package in.conceptarchitect.machines;

import java.util.Date;
import java.text.SimpleDateFormat;

import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.Transaction;
import in.conceptarchitect.finance.exceptions.BankingException;
import in.conceptarchitect.finance.exceptions.InsufficientBalanceException;
import in.conceptarchitect.finance.exceptions.InvalidAccountException;
import in.conceptarchitect.finance.exceptions.InvalidCredentialsException;
import in.conceptarchitect.finance.exceptions.InvalidDenominationException;

public class ATM {
	
	Input keyboard=new Input();
	private int accountNumber;
	private String date;
	private String description;
	Bank bank;
	String desc[];
	
	public ATM(Bank bank) {
		super();
		this.bank = bank;
	}

	public void start() {
		
		while(true) {
			System.out.println("Welcome to "+bank.getName()+" bank");
			accountNumber= keyboard.readInt("account number? ");
			if(accountNumber==-1) {
				String password=keyboard.readString("CHALLENGE? ");
				if(password.equals("NIMDA"))
					adminMenu();
			}
			else
				mainMenu();	
		}
		
	}

	private void mainMenu() {
		// TODO Auto-generated method stub
		
			while(true) {
				try {
					int choice= keyboard.readInt("1. Deposit 2. Withdraw 3. Transfer 4. Show Balance 5. Transaction Details 6. Close Account 0. Exit :");
					switch(choice) {
					case 1:
						doDeposit(); break;
					case 2:
						doWithdraw(); break;
					case 3:
						doTransfer(); break;
					case 4:
						doShowBalance(); break;
					case 5:
						getTransactionDetails(); break;
					case 6:
						doCloseAccount(); break;
					case 0:
						return;
					}
				}  catch(InsufficientBalanceException ex) {
					
					printMessage("Insufficient Balance in account:"+ex.getAccountNumber()+"\tDeficit:"+ex.getDeficit());
					
				} catch(BankingException ex) {
					
					printMessage("Error with Account:"+ex.getAccountNumber()+" : "+ex.getMessage());
					
				} 
			}
		
	}
	
	private void doWithdraw() {
		// TODO Auto-generated method stub
		
		int amount=keyboard.readInt("amount to withdraw? ");
		String password=keyboard.readString("password? ");
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
		String str=formatter.format(date);
		bank.withdraw(accountNumber, amount, password, str, description);
		//you reach here only if withdraw succeeds
		dispenseCash(amount);
		printSlip("Withdraw "+amount+" on "+str);
		
		
	}



	private void doCloseAccount() {
		// TODO Auto-generated method stub
		String password=keyboard.readString("ENTER YOUR PASSWORD:");
		double amount=bank.getAccountBalance(accountNumber,password);
		bank.closeAccount(accountNumber, password);
		printSlip("Account Closed. Cash Returned");
		dispenseCash((int)amount);
		
			
	}

	private void doShowBalance() {
		// TODO Auto-generated method stub
		String password=keyboard.readString("password?");
		var response= bank.getAccountBalance(accountNumber,password);
		printSlip("Your total balance : "+response);
	}

	

	private void doTransfer() {
		// TODO Auto-generated method stub
		int amount=keyboard.readInt("amount to transfer? ");
		String password=keyboard.readString("password? ");
		int targetAccount=keyboard.readInt("target account?");
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
		String str=formatter.format(date);
		bank.transfer(accountNumber, amount, password, targetAccount, str, description);
		printSlip("Transferred "+amount+" rupees to account "+targetAccount+" on "+str);
		printSlip("Received "+amount+" rupees from account "+accountNumber+" on "+str);
	
	}

	public String doDeposit() {
		// TODO Auto-generated method stub

		int amount=keyboard.readInt("amount to transfer? ");
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yy");
		String str=formatter.format(date);
		bank.deposit(accountNumber, amount, str, description);
		String desc=(printSlip("Deposited "+amount+" rupees on "+str));
		return desc;
	}
	
		
		
	private void adminMenu() {
		// TODO Auto-generated method stub
		while(true) {
			try {
			int choice= keyboard.readInt("1. Open Account 2. Credit Interest 3. Show Account 0. Exit :");
			switch(choice) {
			case 1:
				doOpenAccount(); break;
			case 2:
				doCreditInterest(); break;
			case 3:
				doShowAccount();break;
			
			case 0:
				return;
			}
			} 
			catch(BankingException ex) {
				printMessage("error with account "+ex.getAccountNumber()+":"+ex.getMessage());
			}
		}
	}

	private void doShowAccount() {
		// TODO Auto-generated method stub
		var report= bank.getAccountList();
		printMessage(report);
	}

	private void doCreditInterest() {
		// TODO Auto-generated method stub
		bank.creditInterst();
	}

	private void doOpenAccount() {
		// TODO Auto-generated method stub
		String accountType=keyboard.readString("account type [savings/current/od] ?");
		String name=keyboard.readString("Name? ");
		String password=keyboard.readString("Password:");
		int amount=keyboard.readInt("Amount?");
		
		int accountNumber=bank.openAccount(accountType,name, password, amount);
		printSlip("Your new account number is "+accountNumber);
	}

	private void getTransactionDetails() {
		// TODO Auto-generated method stub
		String password=keyboard.readString("password?");
		var response= Transaction.getTransactionDetails(accountNumber,password);
		System.out.println(""+response);
	
	}
			
	
	//ATM hardware methods
	private void printMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}
	
	private String printSlip(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		return message;
	}
	
	
	private void dispenseCash(int amount) {
		System.out.println("Please collect your cash: "+amount);
	}
	
	
	private void mainMenuV1() {
		// TODO Auto-generated method stub
		
			while(true) {
				try {
					int choice= keyboard.readInt("1. Deposit 2. Withdraw 3. Transfer 4. Show Balance 5. Trasaction Details 6. Close Account 0. Exit :");
					switch(choice) {
					case 1:
						doDeposit(); break;
					case 2:
						doWithdraw(); break;
					case 3:
						doTransfer(); break;
					case 4:
						doShowBalance(); break;
					case 5:
						getTransactionDetails(); break;
					case 6:
						doCloseAccount(); return;
					case 0:
						return;
					}
				}  catch(InsufficientBalanceException ex) {
					
					printMessage("Insufficient Balance in account:"+ex.getAccountNumber()+"\tDeficit:"+ex.getDeficit());
					
				} catch(InvalidCredentialsException ex) {
					
					printMessage(ex.getMessage()+":"+ex.getAccountNumber());
					
				} catch(InvalidAccountException | InvalidDenominationException ex) {
					
					printMessage(ex.getMessage()+":"+ex.getAccountNumber());
				} 
			}
		
	}


}

