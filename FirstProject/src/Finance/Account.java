package Finance;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.zetaphase.fp.*;

public class Account {

	private String accountNumber;
	private double balance;
	private Person holder;
	
	private static HashMap<String, Account> accounts = 
			new HashMap<String, Account>();
	
	public Account(String accountNumber, double balance, Person holder) throws Exception {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.holder = holder;
		if (accounts.containsKey(accountNumber)){
			throw new Exception("Account already exists.");
		} else {
			accounts.put(accountNumber, this);
		}
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public static Account getAccountByNumber(String accountNumber){
		return accounts.get(accountNumber);
	}
	
	public synchronized void deposit(double amount){
		this.balance += amount;
	}
	
	public synchronized void withdraw(double amount){
		this.balance -= amount;
	}
	
	public synchronized void transfer(String otherNum, double amount) throws Exception{
		System.out.println(Thread.currentThread().getId() + ": Attempting to get lock of " + otherNum + " , withdraw");
		accounts.get(otherNum).withdraw(amount);
		System.out.println(Thread.currentThread().getId() + ": Lock of " + otherNum + " has been released, withdraw");
		this.deposit(amount);
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", holder=" + holder + "]";
	}
	
	public static void main(String[] args) throws Exception {
		Person dave = new Person("Dave", 15, "M", "12345");
		Person ricky = new Person("Ricky", 50, "M", "09876");
		Person christie = new Person("Christie", 20, "F", "45678");
		Account daveAccount = new Account("12345", 10, dave);
		Account rickyAccount = new Account("09876", 50, ricky);
		Account christieAccount = new Account("45678", 20, christie);
		//Account.transfer("09876",  "12345",  10);
		daveAccount.deposit(30);
		System.out.println(daveAccount);
		System.out.println(rickyAccount);
		System.out.println(christieAccount);
	}

}
