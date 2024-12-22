package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import pageObjects.AcountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AcountRegistrationTest extends BaseClass {
	
	//WebDriver driver;
	

	@Test(groups = {"Regression","Master"})
	public void verify_Account_Registrsation() throws InterruptedException
	{
		try {
		logger.info("**** Starting TC_001_AxountRegistrationTest ****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked MyAccount");
		hp.clickRegister();
		logger.info("Clicked Register");
		
		AcountRegistrationPage AccRegPage=new AcountRegistrationPage(driver);
		
		logger.info("Entering Customer Details...");
		AccRegPage.setFirstName(randomString().toUpperCase());
		AccRegPage.setLastName(randomString().toUpperCase());
		AccRegPage.setEmail(randomString().toUpperCase()+"@gmail.com");
		AccRegPage.setTelePhoneNumber(randomNumber());
		String password=randomAlphaNumeric();
		AccRegPage.setPassword(password);
		AccRegPage.setConfirmPassword(password);
		AccRegPage.clickNewsLetter();
		AccRegPage.clickPrivacyPolicy();
		Thread.sleep(3000);
		AccRegPage.clickContinue();
		
		logger.info("Validating Expected Message....");
		String ConfirmationMsg=AccRegPage.getConfirmMsg();
		/*if(ConfirmationMsg.equals("Your Account Has Been Created!.."))
		{
			Assert.assertTrue(true);
		}else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs.....");
			Assert.assertTrue(false);
			
		}*/
			
		//Assert.assertEquals(ConfirmationMsg, "Your Account Has Been Created!");
		Assert.assertEquals(ConfirmationMsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		logger.info("Test passed");

		}
		catch(Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}

			
		
	}
	
	
	

}
