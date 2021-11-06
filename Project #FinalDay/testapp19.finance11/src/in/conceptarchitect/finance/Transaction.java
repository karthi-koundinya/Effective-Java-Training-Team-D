package in.conceptarchitect.finance;

import in.conceptarchitect.finance.storage.AccountStorage;
import in.conceptarchitect.machines.ATM;

public class Transaction {
	
	String date;
	String description;
	String amount;
	AccountStorage storage;
	
	public Transaction(String date, String description) {
		super();
		this.date = date;
		this.description = description;
	}
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}


	public static String getTransactionDetails(int accountNumber, String password) {
		// TODO Auto-generated method stub
		String desc=null;
		return desc;
		
	}	
}
