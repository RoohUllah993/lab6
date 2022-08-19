package lab5;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class Step1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\4142\\Documents\\chromedriver_win32/chromedriver.exe");
		//Step 0
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.in/");
		driver.manage().window().maximize();
		//SendKeys
		driver.findElement(By.xpath("//textarea[contains(@id,'ta1')]")).sendKeys("Rooh Ullah");
		//Clear Text and Send Keys
		String abc = driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).getText();
		System.out.println(abc);
        driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).clear();
        driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).sendKeys("My name is Rooh Ullah");
        
        //Get Table Data and print on console
        String  innerText = driver.findElement(By.xpath("//table[contains(@id,'table1')]")).getText();
        System.out.println(innerText);
        
        //Send User Name And Password in text Field and hit login button 
        driver.findElement(By.xpath("//form[contains(@name,'form1')]/input[contains(@type,'text')]")).sendKeys("Rooh Ullah");
        driver.findElement(By.xpath("//form[contains(@name,'form1')]/input[contains(@type,'password')]")).sendKeys("Rooh@993");
        driver.findElement(By.xpath("//button[contains(@value,'LogIn')]")).click();
        
        //Switch to both frames one by one
        driver.findElement(By.xpath("//iframe[contains(@id,'iframe1')]")).click();
        driver.findElement(By.xpath("//iframe[contains(@id,'iframe2')]")).click();
        
        ////Send User Name And Password in text Field and hit login button 
        //Handle that alert
        driver.findElement(By.xpath("//input[contains(@name,'userid')]")).sendKeys("Rooh Ullah");
        driver.findElement(By.xpath("//input[contains(@name,'pswrd')]")).sendKeys("Rooh@993");
        driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
        driver.switchTo().alert().accept();
        
        //Select Hyundai and select doc3 
        WebElement opt = driver.findElement(By.xpath("//select[contains(@id,'multiselect1')]"));
        Select select = new Select(opt);
        select.selectByVisibleText("Hyundai");   
        driver.findElement(By.xpath("//select[contains(@name,'SiteMap')]//child::option[(@value='jkl')]")).click();
        
        //Clear the text box and enter hello world
        driver.findElement(By.xpath("//input[contains(@id,'textbox1')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'textbox1')]")).sendKeys("Hello world");
        
        //Lick on enables button
        driver.findElement(By.xpath("//button[contains(@id,'but2')]")).click();
        
        //Try clicking all three buttons
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
        
        //Click on this button and handle alert
        driver.findElement(By.xpath("//input[contains(@id,'alert2')]")).click();
        driver.switchTo().alert().accept();
        
        //Click on Open Popup window and get text
        driver.findElement(By.xpath("//a[contains(text(),'Open a popup window')]")).click();
        String defaultFrame = driver.getWindowHandle();
        for (String openwindow : driver.getWindowHandles())
        {
        	driver.switchTo().window(openwindow);
        }
        
        String get = driver.findElement(By.xpath("//p[contains(@id,'para1')]")).getText();
        String get2 = driver.findElement(By.xpath("//p[contains(@id,'para1')]")).getText();
        System.out.println(get);
        System.out.println(get2);
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(defaultFrame);
        
        //Click on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        
        //double click on the button ‘Double click here’ 
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//button[contains(text(),' Double click Here   ')]"));
        actions.doubleClick(elementLocator).perform();
        driver.switchTo().alert().accept();
       
        //wait for the Mr. option to get enabled and click it
        driver.findElement(By.xpath("//button[contains(text(),'Check this')]")).click();
        Thread.sleep(12000);
        driver.findElement(By.xpath("//input[contains(@id,'dte')]")).click();
        
        //, Select your gender, click on the button ‘ClickToGetAlert’ handle alert
        driver.findElement(By.xpath("//input[contains(@id,'radio1')]")).click();
        
        driver.findElement(By.xpath("//input[contains(@id,'alert1')]")).click();
        driver.switchTo().alert().accept();
        
        //Click on ‘GetPrompt’
        driver.findElement(By.xpath("//input[contains(@id,'prompt')]")).click();
        driver.switchTo().alert().sendKeys("Rooh Ullah");
       
        
//      driver.findElement(By.xpath("//input[contains(@id,'confirm')]")) 
//      .click();
//       driver.switchTo().alert().accept();
        
        //Fill the text boxes below 
        driver.findElement(By.xpath("//div[contains(@id,'HTML24')]//div[contains(@class,'widget-content')]//input[contains(@type,'text')]")).sendKeys("BMW");
        driver.findElement(By.xpath("//div[contains(@id,'HTML28')]//div[contains(@class,'widget-content')]//input[contains(@type,'text')]")).sendKeys("M5 CS");
        
        
        driver.findElement(By.xpath("//input[contains(@value,'Car')]")).click();
        
        //Select bag and book and deselect the book
        driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
        driver.findElement(By.xpath("//input[contains(@value,'Bag')]")).click();
        driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
        
        //Double click on the ‘Double-click’ or click on the green dropdown button and select one option
        driver.findElement(By.xpath("//button[contains(text(),'Dropdown')]")).click();
    //    WebDriverWait wait = new WebDriverWait(driver, 30);
      Thread.sleep(5000);  
     //   wait.until(ExpectedConditions.presenceOfElementLocated("//a[contains(@href,'http://gmail.com/')]"));
        driver.findElement(By.xpath("//a[contains(@href,'http://gmail.com/')]")).click();
        
        
        		}       

}
