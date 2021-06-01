package com.green.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.bank.model.AccountModel;

public class CreateAccountServlet extends HttpServlet {
	String account_no, first_name, last_name, address, city, branch, zip, username, password, re_password, phone_number,
			email, account_type;
	int amount;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		first_name = request.getParameter("first_name");
		last_name = request.getParameter("last_name");
		address = request.getParameter("address");
		city = request.getParameter("city");
		branch = request.getParameter("branch");
		zip = request.getParameter("zip");
		username = request.getParameter("username");
		
		if(username.contains(" ")) {
			request.setAttribute("errorusername", "Username must not have spaces");
			request.getRequestDispatcher("create_account.jsp").forward(request, response);
		} else {
			username = request.getParameter("username");
		}
		
		password = request.getParameter("password");
		re_password = request.getParameter("re_password");
		phone_number = request.getParameter("phone");
		email = request.getParameter("email");
		account_type = request.getParameter("account_type");
		if (amount < 100000) {
			request.setAttribute("fail", "Amount must greater than 1M");
			request.getRequestDispatcher("create_account.jsp").forward(request, response);
			amount = Integer.parseInt(request.getParameter("amount"));
		} else {
			if (amount % 100000 != 0) {
				request.setAttribute("error", "The amount must be even hundred thousand");
				request.getRequestDispatcher("create_account.jsp").forward(request, response);
			} else {
				amount = Integer.parseInt(request.getParameter("amount"));
			}
		}
		// Generating account number
		account_no = username;
		System.out.println(account_no);

		// Getting Current date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String reg_date = df.format(new Date());

		// Setting all variables to model class
		AccountModel am = new AccountModel();
		am.setAccount_no(account_no);
		am.setFirst_name(first_name);
		am.setLast_name(last_name);
		am.setAddress(address);
		am.setCity(city);
		am.setBranch(branch);
		am.setZip(zip);
		am.setUsername(username);
		am.setPassword(password);
		am.setPhone_number(phone_number);
		am.setEmail(email);
		am.setAccount_type(account_type);
		am.setAmount(amount);
		am.setReg_date(reg_date);

		if (password.equals(re_password)) {
			request.setAttribute("Account_details", am);
			RequestDispatcher rd = request.getRequestDispatcher("create_account_progress.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("not_match", "yes");
			RequestDispatcher rd = request.getRequestDispatcher("create_account.jsp");
			rd.forward(request, response);
		}
	}

}
