package BankAccount;
import java.util.Random;

public class BankAccount {
	
	//attributes for each bank account
	private double checkingBalance = 0;
	private double savingBalance = 0;
	private int accountNumber;
	
	//generate random acct number
	private static int getAccountId() {
		Random generator = new Random(System.currentTimeMillis());
		int randomId = generator.nextInt(10000000) + 999999999;
		return randomId;
	}
	//static class attributes
	public static int numOfAccounts = 0;
	public static double amtOfMoney = 0;
	
	
	//constructor
	
	public BankAccount(double checkingBalance, double savingBalance) {
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
		BankAccount.numOfAccounts++;
		this.accountNumber = BankAccount.getAccountId();
		
	}

	//getters and setters
	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}
		
	//method to add to checking or savings balance
	public void deposit(double amount) { 
		amtOfMoney = checkingBalance + savingBalance + amount;
	}
	
	
	//method to withdraw money from checking or savings; do not allow withdrawal if insufficient funds
	public void withdraw(double amount) {
		if (amtOfMoney >= amount) {
			amtOfMoney = (checkingBalance + savingBalance) - amount;
			System.out.println("Balance after withdrawal: " + amtOfMoney);
		}
			else {
				System.out.println("Your balance is less than " + amtOfMoney + "\t Cannot withdraw!");
			}
	}
	
	//method to print balances of accounts
	public void accountBalances() {
		System.out.printf("Your total account balance of saving and checking is: %s \n", amtOfMoney);
	}
	

	//method to check account ID
	public int accessAccountNumber() {
		return this.accountNumber;
	}
	
}
