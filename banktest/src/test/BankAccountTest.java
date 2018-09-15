package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bank.BankAccount;

public class BankAccountTest {
	private BankAccount theAccount;

	@Before
	public void setUp() throws Exception {
		theAccount = new BankAccount();
	}

	@After
	public void tearDown() throws Exception {
		theAccount = null;
	}

	@Test
	public final void testGetBalance() {
		assertEquals("New account, balance not 0", 0, theAccount.getBalance());

	}

	@Test
	public final void testDeposit() {
		theAccount.deposit(100);
		assertEquals("Wrong balance after deposit", 100, theAccount
				.getBalance());
	}

	@Test
	public final void testWithdraw() {
		theAccount.deposit(100);
		theAccount.withdraw(20);
		assertEquals("Wrong balance after withdraw", 80, theAccount
				.getBalance());
	}

	@Test(expected=IllegalArgumentException.class) 
	public final void testOverDraft() {
		theAccount.deposit(100); theAccount.withdraw(200);
	}

}
