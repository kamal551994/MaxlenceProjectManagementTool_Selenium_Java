package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	// ====== Locators ======

	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit']");
	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

	// ====== Constructor ======

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// ====== Methods ======

	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

	public boolean isLoginSuccessful() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
	}
}
