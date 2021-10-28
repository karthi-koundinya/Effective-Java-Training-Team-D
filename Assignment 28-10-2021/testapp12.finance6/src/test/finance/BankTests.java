package test.finance;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.finance.BankAccount;
public class BankTests {
	
		String password="password";
		double amount=20000;
		double wiitdrawamt=5000;
		BankAccount account;
		double insterestRate;
		Bank accounts;
		
		@Before
		public void init() {
			account =new BankAccount(1, "Vivek", password, amount);
			
			System.out.println("@Before called");
				
		}
		
		
		@Test
		public void DepositShouldFailForNegativeAmount() {
		
			boolean result=account.deposit(-1);		
			assertEquals(true,result);
		}
		@Test
		public void depositShouldFailForInvalidAmount()
		{
			double amount=0;
			boolean result=account.deposit(amount);
			assertEquals(true,result);
		}
		@Test
		public void depositShouldFailForInvalidAccountNumber()
		{
			//double amount=20000;
			int accountNumber=123456;
			//boolean result=account.deposit(amount);
			//boolean result=account.getAccountNumber();
			assertEquals(true,account.getAccountByNumber(accountNumber));
		}
		@Test
		public void depositShouldPassForValidAmountAndAccountNumber()
		{
			//String password="password";
			double amount=20000;
			int accountNumber=123456;
			boolean result=account.deposit(amount);
			assertTrue(result);
			assertEquals(true,account.getAccountByNumber(accountNumber));
			assertEquals(true,account.getBalance());
		}
		@Test
		public void withdrawShouldFailForInvalidExcessAmount()
		{
			boolean result=account.withdraw(amount+1,password);
			assertEquals(false,result);
			
		}
		@Test
		public void withdrawShouldFailForInvalidPassword()
		{
			boolean result=account.withdraw(amount," ");
			assertEquals(false,result);
		}
		@Test
		public void withdrawShouldFailForInvalidAmount()
		{
			boolean result=account.withdraw(0000,password);
			assertEquals(false,result);
		}
		@Test
		public void withdrawShouldFailForInvalidAccountNumber()
		{
			String password="password";
			double amount=20000;
			int accountNumber=0000;
			boolean result=account.withdraw(amount,password);
			assertEquals(result,account.getAccountByNumber(accountNumber));
		}

		@Test
		public void withdrawShouldFailForNegativeAmount() {
			boolean result=account.withdraw(-1, password);		
			assertEquals(false, result);
		}	
		
		@Test public void withdrawShouldFailForExcessAmount() {
			boolean result=account.withdraw(amount+1, password);
			assertEquals(false,result);
		}
		@Test
		public void withdrawShouldPassForValidAmountAndPassword() {
			String password="password";
			double amount=20000;
			BankAccount account=new BankAccount(1,"Vivek",password, amount);
			boolean result=account.withdraw(amount, password);
			assertTrue(result);
			assertEquals(0, account.getBalance(),0.001);
		 }
		
			@Test
			public void transferShouldFailForInvalidExcessAmount()
			{
				int fromAccount=12345;
				int toAccount=12345;
				String password="password";
				double amount=3000;
				//String name="SBI";
				boolean result=account.transfer(fromAccount,amount+1,password,toAccount);
				assertEquals(false,result);
				
			}
			public void transferShouldFailForInvalidPassword()
			{
				int fromAccount=12345;
				int toAccount=12346;
			    String password="pass";
				double amount=3000;
				boolean result=account.transfer(fromAccount,amount,password,toAccount);
				assertEquals(false,result);
			}
			@Test
			public void transferShouldFailForInvalidAmount()
			{
				
				String password="password";
				int fromAccount=12345;
				int toAccount=12346;
				double amount=00;
				boolean result=account.transfer(fromAccount,amount,password,toAccount);
				assertEquals(false,result);
			}

			@Test
			public void transferShouldFailForInvalidAccountnumber()
			{
				String password="password";
				int fromAccount=-12345;
				int toAccount=12346;
				double amount=1000;
				boolean result=account.transfer(fromAccount,amount,password,toAccount);
				assertEquals(false,result);
			}
		 @Test
			public void creditInterestShouldFailForInvalidAccount() {
				double interestRate = 11;
				BankAccount account=new BankAccount(-12,"Vivek",password, amount);
				boolean result=account.creditInterest(interestRate);
			    assertEquals(true,result);
			}
		 @Test
			public void creditInterestShouldPassForAllValidAccount() {
				double interestRate = 11;
				BankAccount account=new BankAccount(1,"Vivek",password, amount);
				boolean result=account.creditInterest(interestRate);
			    assertEquals(true,result);
			}
}
