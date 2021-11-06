package in.conceptarchitect.finance.jdbcAccountStore;


import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Scanner;
import java.util.List;

import java.util.Scanner;

public class AccountStoreMain {
	public static void main(String [] args) throws Exception
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the account number");
		int accountNumber=s.nextInt();
		System.out.println("Enter the Name");
		String name=s.next();
		System.out.println("Enter the password");
		String password=s.next();
		System.out.println("Enter the balance");
		double balance=s.nextDouble();
		JdbcAccountStore  m=new JdbcAccountStore (accountNumber,name,password,balance);
		AccountStoreBo  mb=new AccountStoreBo();
		boolean b=mb.addAccount(m);
				
		
		if(b== false) {
			System.out.println("Value inserted Successfully");
		}

		
		List<JdbcAccountStore> li=mb.getAllMembers();

		for(JdbcAccountStore m1:li) {
			System.out.println(m1);
		}
		
	}
	
	

}
