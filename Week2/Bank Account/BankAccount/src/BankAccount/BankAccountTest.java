package BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {

		BankAccount Jerry = new BankAccount(100, 200);
		Jerry.deposit(100);
		Jerry.accountBalances();
		Jerry.withdraw(50);
		Jerry.accountBalances();
		System.out.println("Your account number is: " + Jerry.accessAccountNumber());
		System.out.println("Number of accounts: \t" + BankAccount.numOfAccounts);
	}

}
