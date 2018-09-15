package bank;

public class BankAccount {
	private int balance;// current balance

	/**
	 * Create new account with balance 0.
	 */
	public BankAccount() {
		balance = 0;
	}

	/**
	 * Returns balance of account
	 * 
	 * @return balance of account
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Deposits the specified amount. pre: The specified amount is >= 0 post:
	 * The specified amount is added to balance
	 * 
	 * @param n
	 *            The amount to deposit
	 * @throws IllegalArgumentException
	 *             if the specified amount is < 0
	 */
	public void deposit(int n) {
		if (n < 0) {
			throw new IllegalArgumentException(
					"deposit called with illegal param value");
		}
		balance = balance + n;
	}

	/**
	 * Withdraws the specified amount. pre: The specified amount is >= 0 and <=
	 * balance post: Balance is decreased by the specified amount
	 * 
	 * @param n
	 *            The amount to withdraw
	 * @throws IllegalArgumentException
	 *             if the specified amount is < 0 or > balance of account
	 */
	public void withdraw(int n) {
		if (n < 0) {
			throw new IllegalArgumentException(
					"withdraws called with illegal param value");
		}
		if (n > balance) {
			throw new IllegalArgumentException("Overdraft");
		}
		balance = balance - n;
	}
}
