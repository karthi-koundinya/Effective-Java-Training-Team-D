package in.conceptarchitect.financeapp;

import in.conceptarchitect.finance.Bank;
import in.conceptarchitect.machines.ATM;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank icici=new Bank("ICICI",12,30000);
		//lets create some dummy accounts
		icici.openAccount("Vivek","savings", "pass", 10000);
		icici.openAccount("Sanjay","current", "pass", 20000);
		icici.openAccount("Shivanshi","overdraft", "pass", 30000);
		
		ATM atm=new ATM(icici);
		
		atm.start();

	}

}
