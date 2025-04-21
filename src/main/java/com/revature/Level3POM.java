package com.revature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Level3POM {
    private WebDriver driver;
    @FindBy(css = "input[placeholder='something']")
    private List<WebElement> inputFields;
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;
    public Level3POM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void openLevel3(){
        driver.get("C:\\Users\\havisha\\jyoti-selenium-project\\Important Resources\\InFormed\\level-3.html");
    }
    public void fillform(String val1,String val2,String val3,String val4){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for(int i = 0;i<inputFields.size();i++){
            WebElement fields = wait.until(ExpectedConditions.elementToBeClickable(inputFields.get(i)));
            switch (i){
                case 0:fields.sendKeys(val1);
                case 1:fields.sendKeys(val2);
                case 2:fields.sendKeys(val3);
                case 3:fields.sendKeys(val4);
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();


    }
    public void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("src/main/resources/screenshots/level-3.png"));
    }

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            Level3POM pom3 = new Level3POM(driver);
            pom3.openLevel3();
            pom3.fillform("val1","val2","val3","val4");


            driver.switchTo().alert().accept();
            pom3.takeScreenshot();

        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            if(driver != null) driver.quit();
        }
    }


}
