package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProjectPage;
import utils.ConfigReader;

public class ProjectSteps extends BaseTest {
	 LoginPage loginPage;
	    ProjectPage projectPage;
	    String generatedProjectName;

	    @Given("User is on Login page")
	    public void user_is_on_login_page() {
	    	driver.get(ConfigReader.getProperty("url"));
	        loginPage = new LoginPage(driver);
	    }

	    @When("User logs in with username {string} and password {string}")
	    public void user_logs_in_with_username_and_password(String username, String password) {
	        loginPage.login(username, password);
	        projectPage = new ProjectPage(driver);
	    }

	    @And("User navigates to Project module")
	    public void user_navigates_to_project_module() {
	        projectPage.navigateToProjectModule();
	    }

	    @When("User creates a new project")
	    public void user_creates_a_new_project() {
	        generatedProjectName = projectPage.createProject();
	    }

	    @Then("Project creation should be successful")
	    public void project_creation_should_be_successful() {
	        Assert.assertTrue(projectPage.isSuccessMessageDisplayed(),
	                "Project creation success message not displayed");
	    }

	    @And("Project should appear in project listing")
	    public void project_should_appear_in_project_listing() {
	        Assert.assertTrue(projectPage.isProjectPresentInList(generatedProjectName),
	                "Created project not found in listing");
	    }
}
