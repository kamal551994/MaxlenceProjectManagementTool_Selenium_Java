package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage {

    WebDriver driver;
    WebDriverWait wait;

    // ====== Locators ======

    private By projectModuleMenu = By.xpath("//span[text()='PIM']"); 
    private By addProjectButton = By.xpath("//button[text()=' Add ']");

    private By projectNameField = By.name("firstName"); 
    private By lastNameField = By.name("lastName"); 
    private By saveButton = By.xpath("//button[@type='submit']");

    private By successToast = By.xpath("//div[contains(@class,'oxd-toast')]");

    // ====== Constructor ======

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ====== Methods ======

    public void navigateToProjectModule() {
        wait.until(ExpectedConditions.elementToBeClickable(projectModuleMenu)).click();
    }

    public String createProject() {

        wait.until(ExpectedConditions.elementToBeClickable(addProjectButton)).click();

        String uniqueProjectName = "AutoProject_" + System.currentTimeMillis();

        wait.until(ExpectedConditions.visibilityOfElementLocated(projectNameField))
                .sendKeys(uniqueProjectName);

        // Dummy field 
        driver.findElement(lastNameField).sendKeys("Test");

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        return uniqueProjectName;
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement toast = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successToast));
        return toast.isDisplayed();
    }

    public boolean isProjectPresentInList(String projectName) {

        By projectLocator = By.xpath("//a[text()='" + projectName + "']");

        try {
            WebElement project = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(projectLocator));
            return project.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
