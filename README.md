# 🏦 Banking Web Test Automation — Selenium

> A production-grade, end-to-end UI test automation framework for a banking application,
> built with **Java · Selenium WebDriver · TestNG · Maven** following the **Page Object Model** design pattern.

[![Java](https://img.shields.io/badge/Language-Java-orange?style=flat-square&logo=java)](https://www.java.com)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green?style=flat-square&logo=selenium)](https://www.selenium.dev)
[![TestNG](https://img.shields.io/badge/TestNG-Framework-red?style=flat-square)](https://testng.org)
[![Maven](https://img.shields.io/badge/Build-Maven-blue?style=flat-square&logo=apachemaven)](https://maven.apache.org)
[![POM](https://img.shields.io/badge/Pattern-Page%20Object%20Model-purple?style=flat-square)]()
[![CI/CD Ready](https://img.shields.io/badge/CI%2FCD-Jenkins%20%7C%20GitHub%20Actions-yellowgreen?style=flat-square)]()

---

## 📌 Project Overview

This framework automates regression testing for **ParaBank** — a Parasoft demo banking portal that simulates real-world banking operations including user registration, login, account management, fund transfers, bill payments, and transaction history.

The framework is designed to mirror how enterprise QA automation teams operate: modular, scalable, parallel-execution ready, and pluggable into any CI/CD pipeline.

**Application Under Test:** [ParaBank — parabank.parasoft.com](https://parabank.parasoft.com)

---

## 🏗️ Framework Architecture

The framework follows a clean **4-layer Page Object Model** architecture:

```
┌─────────────────────────────────────────────┐
│              TEST LAYER                      │
│   TestNG @Test methods · Assertions ·        │
│   Business scenario flows · Test data        │
├─────────────────────────────────────────────┤
│           PAGE OBJECT LAYER                  │
│   One class per web page · WebElement        │
│   locators · Reusable action methods         │
├─────────────────────────────────────────────┤
│            BASE / CORE LAYER                 │
│   WebDriver management · ThreadLocal ·       │
│   Browser factory · @Before/@After hooks     │
├─────────────────────────────────────────────┤
│            UTILITIES LAYER                   │
│   Explicit Waits · Screenshot capture ·      │
│   Config reader · Logging                    │
└─────────────────────────────────────────────┘
```

### Why This Framework Is Strong

- ✅ **Scalable** — ThreadLocal WebDriver makes tests thread-safe for parallel execution
- ✅ **Maintainable** — POM ensures locator changes require updating only one class, not dozens of tests
- ✅ **Reliable** — Explicit Waits prevent flakiness on dynamic banking pages
- ✅ **CI/CD Ready** — Integrates directly with Jenkins and GitHub Actions via `mvn test`
- ✅ **Cloud Ready** — Supports BrowserStack and SauceLabs for cross-browser/cross-OS execution
- ✅ **Domain Relevant** — Covers all critical banking workflows: login security, transfers, payments, loan application

---

## 🗂️ Repository Structure

```
Banking_Web_Test_Automation_Selenium/
├── README.md
└── parabank-automation-project/
    └── banking-parabank-automation/
        ├── pom.xml                         # Maven dependencies & build config
        ├── testng.xml                      # TestNG suite: parallel settings, groups
        └── src/
            ├── main/java/com/example/banking/core/
            │   ├── BaseTest.java           # WebDriver setup/teardown; all tests extend this
            │   └── DriverFactory.java      # ThreadLocal WebDriver factory
            └── test/java/com/example/banking/
                ├── pages/                  # Page Object classes (one per page)
                └── tests/                  # TestNG test classes
                    ├── LoginTests.java
                    ├── TransferFundsTests.java
                    └── TransactionsTests.java
```

---

## 🧰 Technology Stack

| Tool / Technology | Purpose |
|---|---|
| **Java** | Primary programming language |
| **Selenium WebDriver** | Browser automation — simulates real user interactions |
| **TestNG** | Test execution framework — annotations, grouping, parallel runs, reporting |
| **Maven** | Build automation and dependency management |
| **Page Object Model** | Design pattern — separates locators from test logic |
| **ThreadLocal WebDriver** | Thread-safe parallel execution — each thread gets its own browser session |
| **WebDriverManager** | Automatic ChromeDriver version management — no manual driver downloads needed |
| **Allure Reports** | Rich, visual test reporting with screenshots embedded |
| **Jenkins** | CI/CD — triggers `mvn test` on every code commit |
| **GitHub Actions** | Cloud-native CI/CD pipeline |
| **BrowserStack / SauceLabs** | Cloud execution — cross-browser and cross-OS testing at scale |

---

## 🏦 Banking Modules Covered

| Module | Test Scenarios |
|---|---|
| **User Registration** | Valid registration, duplicate username, required field validation |
| **Login / Authentication** | Valid login, invalid credentials, session persistence |
| **Account Overview** | Balance display, account number visibility, multi-account navigation |
| **Open New Account** | Account type selection (Checking/Savings), minimum deposit, confirmation |
| **Transfer Funds** | Amount entry, source/destination selection, balance verification post-transfer |
| **Bill Payment** | Payee info, amount, source account, payment confirmation |
| **Transaction History** | Search by date range, amount, transaction ID; record validation |
| **Loan Request** | Loan application, approval/denial response verification |
| **Update Profile** | Personal info editing, save confirmation |
| **Logout** | Session termination, redirect to login page |

---

## ⚙️ How to Run

### Prerequisites

- Java JDK 8+ (with `JAVA_HOME` set)
- Apache Maven 3.x
- Google Chrome + matching ChromeDriver
- IntelliJ IDEA or Eclipse (with TestNG plugin)

### Steps

```bash
# 1. Clone the repository
git clone https://github.com/sudharamanujam85/Banking_Web_Test_Automation_Selenium.git

# 2. Navigate to the Maven project
cd Banking_Web_Test_Automation_Selenium/parabank-automation-project/banking-parabank-automation

# 3. Install dependencies
mvn clean install -DskipTests

# 4. Run the full test suite
mvn test

# 5. Run a specific test class
mvn test -Dtest=LoginTests
```

### View Reports

After execution, open the TestNG HTML report:
```
test-output/index.html
```

---

## 🚀 CI/CD Integration

### Jenkins

1. Create a new Maven project job in Jenkins
2. Point it to this repository
3. Set build goal: `mvn clean test`
4. Add a GitHub webhook to trigger on every push to `main`
5. Enable the **Surefire Reports** plugin to display test trend graphs

### GitHub Actions

Add `.github/workflows/test.yml` to your repo:

```yaml
name: Run Selenium Tests

on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'
      - name: Run tests
        run: mvn clean test
        working-directory: parabank-automation-project/banking-parabank-automation
      - name: Upload test report
        uses: actions/upload-artifact@v3
        with:
          name: test-report
          path: parabank-automation-project/banking-parabank-automation/test-output/
```

---

## ☁️ Cloud Execution (BrowserStack / SauceLabs)

To run on BrowserStack, replace the local WebDriver initialisation in `BaseTest.java` with:

```java
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("browser", "Chrome");
caps.setCapability("browser_version", "latest");
caps.setCapability("os", "Windows");
caps.setCapability("os_version", "10");

driver = new RemoteWebDriver(
    new URL("https://YOUR_USERNAME:YOUR_ACCESS_KEY@hub-cloud.browserstack.com/wd/hub"),
    caps
);
```

Store credentials as environment variables or CI/CD secrets — never hardcode them in source.

---

## 🎯 Key Design Decisions

### Page Object Model
Each web page has a dedicated Java class containing all its locators and interaction methods. Test classes call these methods rather than writing raw Selenium code. When the UI changes, only one class needs updating regardless of how many tests use that page.

### ThreadLocal WebDriver
```java
private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

public static WebDriver get() { return DRIVER.get(); }

public static void quit() {
    if (DRIVER.get() != null) {
        DRIVER.get().quit();
        DRIVER.remove();
    }
}
```
This pattern ensures each parallel test thread has its own independent browser session, preventing session collisions and enabling 3–5× faster test suite execution.

### Explicit Waits
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
```
Used throughout instead of `Thread.sleep()` — waits only as long as necessary, reducing flakiness on dynamic banking pages with server-side processing.

---

## 📊 Framework Highlights at a Glance

| Capability | Status |
|---|---|
| Page Object Model | ✅ Implemented |
| Thread-safe parallel execution | ✅ ThreadLocal WebDriver |
| Explicit Waits | ✅ WebDriverWait + ExpectedConditions |
| Screenshot on failure | ✅ Allure @Attachment |
| Environment config externalised | ✅ Configurable via properties |
| Maven build | ✅ pom.xml |
| CI/CD ready | ✅ Jenkins + GitHub Actions |
| Cloud execution | ✅ BrowserStack / SauceLabs |
| Cross-browser support | ✅ Chrome, Firefox, Edge |

---

> 💡 *ParaBank is a demo application maintained by Parasoft, used solely to simulate a realistic online banking environment for testing purposes.*
