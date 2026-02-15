package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class BaseTest {
	protected static WebDriver driver;

	public static void initialization() {

        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();   
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
