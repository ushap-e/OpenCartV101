package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void verify_Login() {
		logger.info("**** Starting TC_002_LoginTest ****");
		
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link in HomePage");
		hp.clickLogin();
		logger.info("Clicked on Login link under MyAccount");
		
				
		//Login page
				LoginPage lp=new LoginPage(driver);
				logger.info("Entering valid email and password..");
				lp.setEmail(p.getProperty("email"));
				lp.setPassword(p.getProperty("password"));
				Thread.sleep(3000);
				lp.clickLogin(); //Login button
				logger.info("clicked on ligin button..");

		MyAccountPage macc=new MyAccountPage(driver);
		
		Assert.assertTrue(macc.isMyAccountPageDisplayed());
		logger.info("Test Passed");
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("Test Failed"+ e.getMessage());
		}
		finally
		{
			logger.info("**** Finished TC_002_LoginTest ****");
		}
	}

}
