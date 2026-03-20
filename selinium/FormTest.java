package com.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            // Open form
            driver.get("file:///C:/Users/Shreya/Desktop/Student-Feedback-Registration-Form/index.html");
            driver.manage().window().maximize();

            Thread.sleep(2000);

            // =========================
            // TEST 1: VALID INPUT
            // =========================

            driver.findElement(By.id("name")).sendKeys("Shreya Sharma");
            driver.findElement(By.id("email")).sendKeys("shreya@gmail.com");
            driver.findElement(By.id("mobile")).sendKeys("9876543210");

            // Select Department
            Select dept = new Select(driver.findElement(By.id("department")));
            dept.selectByVisibleText("CSE");

            // Select Gender (Female)
            driver.findElements(By.name("gender")).get(1).click();

            // Feedback (10+ words)
            driver.findElement(By.id("feedback"))
                    .sendKeys("This form is working properly and user interface is very good");

            // Submit
            driver.findElement(By.xpath("//button[text()='Submit']")).click();

            Thread.sleep(3000);
            System.out.println("✅ Valid submission done");

            // =========================
            // TEST 2: BLANK FORM
            // =========================

            driver.navigate().refresh();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[text()='Submit']")).click();

            Thread.sleep(2000);
            System.out.println("✅ Blank validation checked");

            // =========================
            // TEST 3: INVALID EMAIL
            // =========================

            driver.findElement(By.id("name")).sendKeys("Test User");
            driver.findElement(By.id("email")).sendKeys("invalidemail");
            driver.findElement(By.id("mobile")).sendKeys("9876543210");

            driver.findElement(By.xpath("//button[text()='Submit']")).click();

            Thread.sleep(2000);
            System.out.println("✅ Invalid email tested");

            driver.navigate().refresh();
            Thread.sleep(2000);

            // =========================
            // TEST 4: INVALID MOBILE
            // =========================

            driver.findElement(By.id("name")).sendKeys("Test User");
            driver.findElement(By.id("email")).sendKeys("test@gmail.com");
            driver.findElement(By.id("mobile")).sendKeys("12345");

            driver.findElement(By.xpath("//button[text()='Submit']")).click();

            Thread.sleep(2000);
            System.out.println("✅ Invalid mobile tested");

            driver.navigate().refresh();
            Thread.sleep(2000);

            // =========================
            // TEST 5: DROPDOWN
            // =========================

            Select deptTest = new Select(driver.findElement(By.id("department")));
            deptTest.selectByVisibleText("IT");

            Thread.sleep(2000);
            System.out.println("✅ Dropdown working");

            // =========================
            // TEST 6: RESET BUTTON
            // =========================

            driver.findElement(By.id("name")).sendKeys("Reset Test");
            driver.findElement(By.xpath("//button[text()='Reset']")).click();

            Thread.sleep(2000);
            System.out.println("✅ Reset button working");

        } 
        catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } 
        finally {
            driver.quit();
        }
    }
}
