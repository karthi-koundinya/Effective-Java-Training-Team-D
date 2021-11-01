package in.conceptarchitect.finance;

import in.conceptarchitect.exceptions.InsufficientFundsException;
import in.conceptarchitect.exceptions.InvalidAccountException;
import in.conceptarchitect.exceptions.InvalidCredentialsException;

public class Bank {
	
	String name; //name of the bank
	int lastId=0;
	int accountCount=0;
	double balance;
	double interestRate;
	
	

	BankAccount [] accounts= new BankAccount[100]; //MAX 100. May not be great for large banks
	
	
	public int getAccountCount() {
		// TODO Auto-generated method stub
		return accountCount;
	}
	
	public void creditInterst() {
		//credit interest to all accounts
		for(int i=1;i<=lastId;i++) {
			
			accounts[i].creditInterest(interestRate);
		}
	}
	
	public  double getInterestRate() {
		return interestRate;
	}

	public  void setInterestRate(double interestRate) {
		
		BankAccount.interestRate = interestRate;
	}
	
	
	
	public Bank(String name, double interestRate,double balance) {
		super();
		this.name = name;
		this.interestRate = interestRate;
		this.balance=balance;
	}
	
	
	public int openAccount(String name,String accountType, String password, double amount) {
		
		BankAccount account= new BankAccount(0, name,accountType,password,amount);
		return addAccount(account);
	}
	
	

	private int addAccount(BankAccount account) {
		int accountNumber= ++ lastId;
		account.accountNumber=accountNumber;
		accounts[accountNumber] = account; //store this account in the array.
		accountCount++;
		return accountNumber;
	}
	
	BankAccount getAccountByNumber(int accountNumber) {
		// TODO Auto-generated method stub
		if(accountNumber>0 && accountNumber<=lastId)
			return accounts[accountNumber];
		else
			return null;
	}
	
	public boolean deposit(int accountNumber, double amount) throws InvalidAccountException,InsufficientFundsException  {
		
		BankAccount account = getAccountByNumber(accountNumber);
		try
		{
			if(account==null)
			{
				throw new InvalidAccountException("Please enter the valid account number");
			}
			else
			{
				if(amount<=0)
				{
					throw new InsufficientFundsException("Please deposit a minimum amount");
				}
				else
				{
				    System.out.println("Successfully "+amount+" deposited !!!! Total amount is "+(balance+amount));
				}
			}
		}
		catch(InsufficientFundsException e)  
        {  
             System.out.println(e.getMessage());  
             System.out.println("TRANSACTION FAILURE");  
        }  
		catch(InvalidAccountException e)
		{
			System.out.println(e.getMessage());  
            System.out.println("TRANSACTION FAILURE");  
		}
		return false;
		
	}

	public double getAccountBalance(int accountNumber) {
		// TODO Auto-generated method stub
		BankAccount account=getAccountByNumber(accountNumber);
		if(account==null)
			return Double.NaN;
		return account.getBalance();
	}

	public boolean transfer(int source, double amount, String password, int target)throws InvalidAccountException  {
		// TODO Auto-generated method stub
		BankAccount s= getAccountByNumber(source);
		BankAccount t= getAccountByNumber(target);
		
		try
		{
			if(s==null)
				throw new InvalidAccountException("Please enter the valid account number");
			if(t==null)
				throw new InvalidAccountException("Please enter the valid account number");
			if(s.withdraw(amount,password))
				return t.deposit(amount);
			else
				return false;

			
		}
		catch(InvalidAccountException e)
		{
			System.out.println(e.getMessage());  
            System.out.println("TRANSACTION FAILURE");  
		}
		return true;
		
		
	}

	public boolean closeAccount(int accountNumber, String password)throws InvalidAccountException,InvalidCredentialsException,InsufficientFundsException {
		// TODO Auto-generated method stub
		var account=getAccountByNumber(accountNumber);
		try
		{
			if(account==null)
				throw new InvalidAccountException("Please enter the valid account number");
			if(!account.authenticate(password))
				throw new InvalidCredentialsException("Invalid Password");
			if(account.getBalance()<0)
				throw new InsufficientFundsException("Please enter the minimum amount");
				
		}
		catch(InsufficientFundsException e)  
        {  
             System.out.println(e.getMessage());  
             System.out.println("TRANSACTION FAILURE");  
        }  
		catch(InvalidCredentialsException e)
		{
			System.out.println(e.getMessage());  
            System.out.println("TRANSACTION FAILURE");  
		}
		catch(InvalidAccountException e)
		{
			System.out.println(e.getMessage());  
            System.out.println("TRANSACTION FAILURE");  
		}
      accounts[accountNumber]=null; //account is actually closed.
		
		accountCount--;
		return true;
		

		
	}

	
	public boolean withdraw(int accountNumber,int amount,String password) throws InvalidCredentialsException,InsufficientFundsException {
		var account=getAccountByNumber(accountNumber);
		try {
			if(!account.authenticate(password))
			{
				throw new InvalidCredentialsException("Invalid Password");
			}
			else
			{
				if(amount>balance)
				{
		         throw new InsufficientFundsException("Current balance "+balance+" is less than requested amount" +amount);
				}
				else if(amount<=0)
				{
					throw new InsufficientFundsException("Please enter the minimum amount");
				}
				else
				{
					System.out.println("Successfully withdraw !!!!!,Available amount is "+(balance-amount));
				}
				
			}
			}
		catch(InsufficientFundsException e)  
        {  
             System.out.println(e.getMessage());  
             System.out.println("TRANSACTION FAILURE");  
        }  
		catch(InvalidCredentialsException e)
		{
			System.out.println(e.getMessage());  
            System.out.println("TRANSACTION FAILURE");  
		}
		return false;
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	

	


}
