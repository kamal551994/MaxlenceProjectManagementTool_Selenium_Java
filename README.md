Project Name: Project Management Tool Automation Framework

## Technology Stack / Tools Used
- Java 11
- Selenium WebDriver 4.18.1
- Cucumber BDD 7.15.0
- TestNG 7.9.0
- WebDriverManager 5.7.0
- Maven (build and dependency management)
- Page Object Model (POM) design
- Configurable via config.properties
- Explicit waits implemented

Framework Design:
- Page Object Model (POM) for maintainable code
- Cucumber BDD feature files with Background for reusable login steps
- Project creation scenarios automated
- Multi-browser support (Chrome, Firefox, Edge)
- Configurable browser and URL via `config.properties`

## How to Run
1. Clone or import the project into your IDE (IntelliJ/Eclipse)
2. Ensure Maven is installed and project dependencies are downloaded (`mvn clean install`)
3. Update `config.properties` with required `browser`, `url`, and credentials
4. Run `TestRunner.java` as a JUnit/TestNG test
5. Test results and Cucumber reports will be generated in `target/cucumber-reports.html`

## Assumptions
- Valid credentials exist
- Application URL is accessible
- Chrome browser installed if using Chrome