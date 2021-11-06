package in.conceptarchitect.finance.jdbcAccountStore;

public class JdbcAccountStore {

		
	private int accountNumber;
	private String name;
	private String password;
	protected double balance;
	
	
	@Override
	public String toString() {
		return "JdbcAccountStore [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password
				+ ", balance=" + balance + "]";
	}

	
	public JdbcAccountStore () {
		super();
	}
	
	
		
	public JdbcAccountStore(int accountNumber, String name, String password, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
	}


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
