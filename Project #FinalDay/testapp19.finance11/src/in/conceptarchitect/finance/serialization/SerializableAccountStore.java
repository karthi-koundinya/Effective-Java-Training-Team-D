package in.conceptarchitect.finance.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import in.conceptarchitect.finance.BankAccount;

public class SerializableAccountStore {
	
	
	public static void main(String []args)
	{
		BankAccount account=null;
		account.getName();
		account.getAccountNumber();
		account.getBalance();
		try
		{
			FileOutputStream fileOut=new FileOutputStream("/testapp19.finance11/src/in/conceptarchitect/finance/BankAccount.java");
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			out.writeObject(account);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is stored in /testapp19.finance11/src/in/conceptarchitect/finance/BankAccount.java");	
		
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		
	}
	

}
