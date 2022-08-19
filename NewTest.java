import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class NewTest {
  WebDriver driver;
	@BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\4142\\Documents\\chromedriver_win32/chromedriver.exe");
		//Step 0
		driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.in/");
		driver.manage().window().maximize();
	  }

	
	@Test(priority=0)
  public void initialTextField() {
		driver.findElement(By.xpath("//textarea[contains(@id,'ta1')]")).sendKeys("Rooh Ullah");
		String abc = driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).getText();
		System.out.println(abc);
        driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).clear();
        driver.findElement(By.xpath("//textarea[contains(text(),'The cat was playing in the garden.')]")).sendKeys("My name is Rooh Ullah");
        
  }
@Test(priority=1)
public void Table() {
	String  innerText = driver.findElement(By.xpath("//table[contains(@id,'table1')]")).getText();
    System.out.println(innerText);
	
}
@Test(priority=2){
	 driver.findElement(By.xpath("//form[contains(@name,'form1')]/input[contains(@type,'text')]")).sendKeys("Rooh Ullah");
     driver.findElement(By.xpath("//form[contains(@name,'form1')]/input[contains(@type,'password')]")).sendKeys("Rooh@993");
     driver.findElement(By.xpath("//button[contains(@value,'LogIn')]")).click();
}
@Test(priority=3){
	driver.findElement(By.xpath("//iframe[contains(@id,'iframe1')]")).click();
    driver.findElement(By.xpath("//iframe[contains(@id,'iframe2')]")).click();
    driver.findElement(By.xpath("//input[contains(@name,'userid')]")).sendKeys("Rooh Ullah");
    driver.findElement(By.xpath("//input[contains(@name,'pswrd')]")).sendKeys("Rooh@993");
    driver.findElement(By.xpath("//input[contains(@value,'Login')]")).click();
    driver.switchTo().alert().accept();
}
@Test(priority=4){
	 WebElement opt = driver.findElement(By.xpath("//select[contains(@id,'multiselect1')]"));
     Select select = new Select(opt);
     select.selectByVisibleText("Hyundai");   
     driver.findElement(By.xpath("//select[contains(@name,'SiteMap')]//child::option[(@value='jkl')]")).click();
     
}
@Test(priority=5){
	driver.findElement(By.xpath("//input[contains(@id,'textbox1')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'textbox1')]")).sendKeys("Hello world");
}

@Test(priority=6){
	driver.findElement(By.xpath("//button[contains(@id,'but2')]")).click();
    
    driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
    driver.findElement(By.xpath("//input[contains(@id,'alert2')]")).click();
    driver.switchTo().alert().accept();
}
@Test(priority=7){
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
}
@Test(priority=8){
	driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
    
    Actions actions = new Actions(driver);
    WebElement elementLocator = driver.findElement(By.xpath("//button[contains(text(),' Double click Here   ')]"));
    actions.doubleClick(elementLocator).perform();
    driver.switchTo().alert().accept();
	
}

@Test(priority=9){
	 driver.findElement(By.xpath("//button[contains(text(),'Check this')]")).click();
     Thread.sleep(12000);
     driver.findElement(By.xpath("//input[contains(@id,'dte')]")).click();
     
     driver.findElement(By.xpath("//input[contains(@id,'radio1')]")).click();
     
     driver.findElement(By.xpath("//input[contains(@id,'alert1')]")).click();
     driver.switchTo().alert().accept();
     
     driver.findElement(By.xpath("//input[contains(@id,'prompt')]")).click();
     driver.switchTo().alert().sendKeys("Rooh Ullah");
}

@Test(priority=10){
	 driver.findElement(By.xpath("//div[contains(@id,'HTML24')]//div[contains(@class,'widget-content')]//input[contains(@type,'text')]")).sendKeys("BMW");
     driver.findElement(By.xpath("//div[contains(@id,'HTML28')]//div[contains(@class,'widget-content')]//input[contains(@type,'text')]")).sendKeys("M5 CS");
     
     
     driver.findElement(By.xpath("//input[contains(@value,'Car')]")).click();
     
     driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
     driver.findElement(By.xpath("//input[contains(@value,'Bag')]")).click();
     driver.findElement(By.xpath("//input[contains(@value,'Book')]")).click();
}

@Test(priority=11){
	driver.findElement(By.xpath("//button[contains(text(),'Dropdown')]")).click();
	 Thread.sleep(5000);  
	 driver.findElement(By.xpath("//a[contains(@href,'http://gmail.com/')]")).click();
}
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();

  }

}
