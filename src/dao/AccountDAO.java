package dao;

import java.util.List;

import entities.Account;

public interface AccountDAO {

	public float calculateInterest(int sendingMoney, int balance, int sendingDays, int period);

}
