# TestAutomationWebExcercise
This is solution from the coding task
If you want to execute the test you need to have
installed any version of "Google chrome" browser.

####Tools
* Java 11
* Gradle
* Allure
* Cucumber 5

####Dependencies
* JUnit 5.7
* Selenium-java 3.141.59
* Webdrivermanager 5.0.3
* Allure-report-plugin 2.9.6
* Cucumber 6.9.0

####Design Patterns
* POM

####Precondition: If you want to generate an allure report you must install allure on your machine.
- MacOS: brew install allure
- Windows:
  - Download the latest version as zip archive from Maven Central.
  - Unpack the archive to allure-commandline directory.
  - Navigate to bin directory.
  - Use allure.bat for Windows or allure for other Unix platforms.
  - Add allure to system PATH.
  

####Test Execution with Gradle and Generate Allure Report
- ./gradlew clean test
- ./gradlew allureReport
- ./gradlew allureServe

####To consider:
- Do not execute scenarios from feature file

