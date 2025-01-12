## 🚀 Getting Started

### 🚧 Prerequisites
Before you can run this project, you must have the following software installed on your computer:

- Java Development Kit (JDK) version 11 or later
- Apache Maven
- Google Chrome web browser
- FireFox web browser
- 

## 🏃🏽How to run the tests

### 🛠️ How to run all tests
1. Navigate to the project directory using the command line.
2. Install the dependencies and run the smoke test plan (configured).
   ```sh
   mvn clean install
   ```
   OR
    ```sh
   mvn clean test
   ```
   
#### 🚦 Running a test case
1. Navigate to the project directory using command line.
2. Run the following command but replace `<test_case>` with the name of the test case.   
   ```sh
   mvn test -Dtest=<test_case>
   ```  
   E.g. `mvn test -Dtest=TC004_Logout`