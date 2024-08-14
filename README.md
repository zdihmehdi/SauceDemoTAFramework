# SauceDemo Test Automation Framework

Welcome to the SauceDemo Test Automation Framework, an automation suite designed for regression testing on the [SauceDemo](https://www.saucedemo.com/) website. This framework automates key user flows and test cases, including:

- **Login**
- **Logout**
- **Product Filters**
- **Shopping Cart Operations**

## Tools and Technologies

This framework is built using the following technologies:

- **Java 17**: The programming language used for writing test scripts.
- **Maven**: For project management and build automation.
- **Selenium**: For browser automation and interaction.
- **Cucumber**: For Behavior-Driven Development (BDD) and test scenarios.
- **Allure**: For generating test reports.

## Getting Started

### Prerequisites

Before you can run the framework locally, ensure you have the following installed on your machine:

- **Java 17**
- **Maven**
- **Allure** (optional)

### Installation

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/yourusername/SauceDemoTAFramework.git
   cd SauceDemoTAFramework
   ```
2. **Configure the Browser:**
   Open the configuration file config.properties and set the desired browser (e.g., Chrome, Firefox).

Note: remote means that the test cases will be executed remotely, for example in: [<server_address>/wd/hub](<server_address>/wd/hub).

3. **Run the Tests:**

Execute the following Maven command to clean the project and run the test suite:

   ```sh
   mvn clean test
   ```
### Reports

1. **Cucumber Report**

After the test execution, a Cucumber report will be generated in the target directory. You can view it by opening the following file in your browser:

   ```sh
   target/cucumber-reports.html
   ```

2. **Allure Report**

To use allure report, please follow the [Allure installation guide](https://allurereport.org/docs/install/) to install Allure on your machine.

To generate the Allure report, please execute the following command:
  ```sh
   mvn allure:serve
   ```
This command will start a local server and open the Allure report in your default web browser.