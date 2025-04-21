package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Level2POM {
    private WebDriver driver;

    @FindBy(name = ("input1"))
    private WebElement dropDown;
    @FindBy(name = "checkbox1")
    private WebElement checkBox1;
    @FindBy(name = "checkbox2")
    private WebElement checkBox2;
    @FindBy(name = "checkbox3")
    private WebElement checkBox3;
    @FindBy(css = "input[name='radio'][value='2']")
    private WebElement radio;
    @FindBy(name = "dateInput")
    private WebElement date;
    @FindBy(css = "button[type='submit']")
    private WebElement buttonToSubmit;

    public Level2POM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openLevel2(){
        driver.get("C:\\Users\\havisha\\jyoti-selenium-project\\Important Resources\\InFormed\\level-2.html");
    }
    public void selectdropdown(){
        Select select = new Select(dropDown);
        select.selectByVisibleText("2");
    }

    public  void checkBox(){
        checkBox1.click();
        checkBox2.click();
        checkBox3.click();

    }
    public void clickRadio(){
        radio.click();

    }
    public void selectDate(){
        date.sendKeys("2018-07-17");
    }
    public void submitButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buttonToSubmit.click();
    }
    public void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/level-2.png"));
    }

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            Level2POM pom2 = new Level2POM(driver);
            pom2.openLevel2();
            pom2.selectdropdown();
            pom2.checkBox();
            pom2.selectDate();
            pom2.submitButton();
            driver.switchTo().alert().accept();
            pom2.takeScreenshot();

        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if(driver != null) driver.quit();
        }
    }

}
