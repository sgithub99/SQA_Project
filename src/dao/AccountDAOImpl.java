package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public float calculateInterest(int sendingMoney, int balance, int sendingDays, int period) {
		float interestMoney = 0;
		if (sendingMoney > balance || sendingMoney < 1000000 || sendingMoney % 100000 != 0) {
			return 0;
		} else {
			if ((sendingDays < 0 && period < 0) || (sendingDays < 0 && period > 0)) {
				return 0;
			} else if (sendingDays % (period * 30) == 0
					&& (period == 1 || period == 2 || period == 3 || period == 6 || period == 12 || period == 24)) {

				int k = sendingDays / (period * 30);
//				interestMoney = sendingMoney * k * (sendingDays / 360f) * 0.029f;

				switch (period) {
				case 1:
					interestMoney = (float) sendingMoney * k * (30 / 360f) * 0.029f;
					break;
				case 2:
					interestMoney = sendingMoney * k * (30 / 360f) * 0.029f;
					break;
				case 3:
					interestMoney = sendingMoney * k * (30 / 360f) * 0.032f;
					break;
				case 6:
					interestMoney = sendingMoney * k * (30 / 360f) * 0.038f;
					break;
				case 12:
					interestMoney = sendingMoney * k * (30 / 360f) * 0.038f;
					break;
				case 24:
					interestMoney = sendingMoney * k * (30 / 360f) * 0.055f;
					break;
				default:
					break;
				}

			} else if (sendingDays % (period * 30) != 0
					&& (period == 1 || period == 2 || period == 3 || period == 6 || period == 12 || period == 24)) {
				int d = sendingDays / (period * 30);
				int m = sendingDays % (period * 30);
//				interestMoney = sendingMoney * d * (30 / 360f) * 0.029f + sendingMoney * (m / 360f) * 0.001f;
				switch (period) {
				case 1:
					interestMoney = (float) (sendingMoney * d * (30 / 360f) * 0.029f + sendingMoney * (m / 360f) * 0.001f);
					break;
				case 2:
					interestMoney = sendingMoney * d * (30 / 360f) * 0.029f + sendingMoney * (m / 360f) * 0.001f;
					break;
				case 3:
					interestMoney = sendingMoney * d * (30 / 360f) * 0.032f + sendingMoney * (m / 360f) * 0.001f;
					break;
				case 6:
					interestMoney = sendingMoney * d * (30 / 360f) * 0.038f + sendingMoney * (m / 360f) * 0.001f;
					break;
				case 12:
					interestMoney = sendingMoney * d * (30 / 360f) * 0.038f + sendingMoney * (m / 360f) * 0.001f;
					break;
				case 24:
					interestMoney = sendingMoney * d * (30 / 360f) * 0.055f + sendingMoney * (m / 360f) * 0.001f;
					break;
				default:
					break;
				}
			}
		}
		return interestMoney;

	}

	


}
