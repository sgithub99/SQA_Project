
import java.util.List;
import java.util.Scanner;

import dao.AccountDAOImpl;
import entities.Account;

public class Main {

	public static void main(String[] args) {
		float accountDAOImpl = new AccountDAOImpl().calculateInterest(200000000, 400000000, -4, 1);
		System.out.println(accountDAOImpl);
	}
}
