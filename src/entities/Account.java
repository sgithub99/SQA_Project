package entities;

public class Account {
	protected String accountNo, customerName;
	protected float balance;

	public Account() {

	}

	public Account(String accountNo, String customerName, float balance) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public float getBalance() {
		return balance;
	}



	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", customerName=" + customerName + ", balance=" + balance + "]";
	}

}
