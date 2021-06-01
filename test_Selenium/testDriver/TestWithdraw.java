package testDriver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestWithdraw extends TestDriver{
	

	ChromeDriver driver = getDriver();

	@Before
	public void setUp() {
		
	}

	
	@Test 
	public void visitWithdrawSuccessful() {
		driver.get("http://localhost:8080/BankingProjectSQA");
		
		WebElement loginButton = driver.findElementById("loginHome");
		loginButton.click();
		
		WebElement usernameEditText = driver.findElement(By.id("account_no"));
		WebElement passwordEditText = driver.findElement(By.id("password"));
		
		usernameEditText.sendKeys("xuanson");
		passwordEditText.sendKeys("123");
		
		WebElement signInBtn = driver.findElement(By.id("sign_in_button"));
		signInBtn.click();

	
		
		WebElement withdraw_li = driver.findElement(By.id("withdraw_li"));
		withdraw_li.click();
		
		String title = driver.getTitle();
		String expectedTitle = "Withdraw";

		driver.close();
		
		assertEquals(title, expectedTitle);
	}
	

	@Test 
	public void leavePassword() {
		driver.get("http://localhost:8080/BankingProjectSQA");
		
		WebElement loginButton = driver.findElementById("loginHome");
		loginButton.click();
		
		WebElement usernameEditText = driver.findElement(By.id("account_no"));
		WebElement passwordEditText = driver.findElement(By.id("password"));
		
		usernameEditText.sendKeys("xuanson");
		passwordEditText.sendKeys("123");
		
		WebElement signInBtn = driver.findElement(By.id("sign_in_button"));
		signInBtn.click();

		WebElement withdraw_li = driver.findElement(By.id("withdraw_li"));
		withdraw_li.click();
		
		
		WebElement withdraw_password = driver.findElementById("password");
		WebElement withdraw_amount = driver.findElementById("amount");
		
		withdraw_password.sendKeys("");
		withdraw_amount.sendKeys("100000");
		
		WebElement submit_withdraw = driver.findElementById("submit_withdraw");
		submit_withdraw.click();
		
		String title = driver.getTitle();
		String expectedTitle = "Withdraw";
		
		driver.close();
		
		assertEquals(title, expectedTitle);
	}
	@Test 
	public void leaveAmount() {
		driver.get("http://localhost:8080/BankingProjectSQA");
		
		WebElement loginButton = driver.findElementById("loginHome");
		loginButton.click();
		
		WebElement usernameEditText = driver.findElement(By.id("account_no"));
		WebElement passwordEditText = driver.findElement(By.id("password"));
		
		usernameEditText.sendKeys("xuanson");
		passwordEditText.sendKeys("123");
		
		WebElement signInBtn = driver.findElement(By.id("sign_in_button"));
		signInBtn.click();
		
		
		
		WebElement withdraw_li = driver.findElement(By.id("withdraw_li"));
		withdraw_li.click();
		
		WebElement withdraw_accountNo = driver.findElementById("account_no");
		WebElement withdraw_username = driver.findElementById("username");
		WebElement withdraw_password = driver.findElementById("password");
		WebElement withdraw_amount = driver.findElementById("amount");

		withdraw_password.sendKeys("123");
		withdraw_amount.sendKeys("");
		
		WebElement submit_withdraw = driver.findElementById("submit_withdraw");
		submit_withdraw.click();
		
		String title = driver.getTitle();
		String expectedTitle = "Withdraw";
		
		driver.close();
		
		assertEquals(title, expectedTitle);
	}
	
	@Test 
	public void overAmount() {
		driver.get("http://localhost:8080/BankingProjectSQA");
		
		WebElement loginButton = driver.findElementById("loginHome");
		loginButton.click();
		
		WebElement usernameEditText = driver.findElement(By.id("account_no"));
		WebElement passwordEditText = driver.findElement(By.id("password"));
		
		usernameEditText.sendKeys("xuanson");
		passwordEditText.sendKeys("123");
		
		WebElement signInBtn = driver.findElement(By.id("sign_in_button"));
		signInBtn.click();
		
	
		WebElement withdraw_li = driver.findElement(By.id("withdraw_li"));
		withdraw_li.click();
	
		WebElement withdraw_password = driver.findElementById("password");
		WebElement withdraw_amount = driver.findElementById("amount");

		withdraw_password.sendKeys("123");
		withdraw_amount.sendKeys("900000000");
		
		WebElement submit_withdraw = driver.findElementById("submit_withdraw");
		submit_withdraw.click();
		
		WebElement notification = driver.findElementById("danger_amount");
		
		String alert = notification.getText();
		String expectedAlert = "Sorry! You do not have enough money.";
		
		driver.close();
		
		assertEquals(expectedAlert, alert);
	}
	@Test 
	public void negativeAmount() {
		driver.get("http://localhost:8080/BankingProjectSQA");
		
		WebElement loginButton = driver.findElementById("loginHome");
		loginButton.click();
		
		WebElement usernameEditText = driver.findElement(By.id("account_no"));
		WebElement passwordEditText = driver.findElement(By.id("password"));
		
		usernameEditText.sendKeys("xuanson");
		passwordEditText.sendKeys("123");
		
		WebElement signInBtn = driver.findElement(By.id("sign_in_button"));
		signInBtn.click();
		
		
		WebElement withdraw_li = driver.findElement(By.id("withdraw_li"));
		withdraw_li.click();
		
		WebElement withdraw_password = driver.findElementById("password");
		WebElement withdraw_amount = driver.findElementById("amount");
		
		withdraw_password.sendKeys("123");
		withdraw_amount.sendKeys("-1");
		
		WebElement submit_withdraw = driver.findElementById("submit_withdraw");
		submit_withdraw.click();
		
		WebElement notification = driver.findElementById("danger_amount");
		
		String alert = notification.getText();
		String expectedAlert = "Sorry! You do not have enough money.";
		
		driver.close();
		
		assertEquals(expectedAlert, alert);
	}
	

}
