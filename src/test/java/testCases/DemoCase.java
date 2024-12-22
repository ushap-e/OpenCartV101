package testCases;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class DemoCase {

	@Test
	public void demoRegis() {
		// TODO Auto-generated method stub
		
		 System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		EdgeDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		//driver.findElement(By.xpath("//a//span[.='My Account']")).click();
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
		
		/*WebElement MyAcc=driver.findElement(By.xpath("//a//span[.='My Account']"));
		MyAcc.click();
		
		WebElement Regis = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
		Regis.click();*/

	}

}
