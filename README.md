AUTOMATED TESTING USING SELENIUM AND JAVA

1. SETUP ENVIRONMENT

- Install JAVA: Go to the https://www.oracle.com/java/technologies/downloads/ and select JDK 8
- Setup JAVA_HOME
- Check java version:
> java -version
- Install ChromeDriver: Go to the https://chromedriver.chromium.org/ and select the ChromeDriver version that matches your Chrome version.
- Install FireFoxDriver: Go to the https://github.com/mozilla/geckodriver/releases and select the FirefoxDriver version that matches your Firefox version.
- Install Allure Report - a flexible lightweight multi-language test report tool

1.1 On Window:
- Install Scoop on PowerShell terminal using two command below:
> Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
> irm get.scoop.sh | iex
- Install Allure
> scoop install allure

1.2 On Mac:
- Install Brew
- Install Allure
> brew install allure

2. GETTING STARTED
- Clone this repository:
> git clone https://github.com/uyen3893/saucelab-demo-project.git
- Unzip ChromeDriver and FirefoxDriver and move them into the /src/test/resources/drivers
- Config and run \src\test\resources\test-suites\RegressionTest.xml

3. GENERATING REPORT
- Open new terminal and move to current directory
- Generate allure
> allure generate
- Open allure report
> allure open


