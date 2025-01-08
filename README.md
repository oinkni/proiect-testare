## 🚀 Getting Started

### 🚧 Prerequisites
Before you can run this project, you must have the following software installed on your computer:

- Java Development Kit (JDK) version 11 or later
- Apache Maven
- Google Chrome web browser
- FireFox web browser

### 🛠️ How to run
1. Navigate to the project directory using the command line.
2. Install the dependencies and run the smoke test plan (configured).   
   ```sh
   mvn clean install
   ```


This project contains 4 sample test cases that demonstrate how to use Selenium to interact with web pages. 

#### 🧪 Test Cases
- `TC001_AddToCart_Checkout`: Adds product to the cart and verifies that checkout is successful.

#### 📝 Test Suites
- `TS-001_SmokeTest.xml`: Includes one test case that covers the basic functionality of the web app.

#### 🏃🏽How to run the tests

#### 🚦 Running a test case
1. Navigate to the project directory using command line.
2. Run the following command but replace `<test_case>` with the name of the test case.   
   ```sh
   mvn test -Dtest=<test_case>
   ```  
   E.g. `mvn test -Dtest=TC004_Logout`

#### 🚦 Running a test plan
1. Navigate to the project directory using command line.
2. Run the following command but replace `<test_plan>` with the file path of the test suite xml files.  
   ```sh
   mvn test -DsuiteXmlFiles=<test_plan>
   ```
   E.g. `mvn test -DsuiteXmlFiles=src/test/java/automation/tests/testng/testsuites/TS-001_Regression.xml`

