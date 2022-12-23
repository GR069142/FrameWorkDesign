package ValueLabs.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import ValueLabs.PageObjects.LandingPage;
import ValueLabs.TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{

	public LandingPage landingPage;
	
	 @Given("^User is landed on subscription page$")
	    public void user_is_landed_on_subscription_page() throws IOException {
		 
		 	landingPage = launchApplication();	
		 	landingPage.selectEngishLanguage();
		 
	    }
	 
	  @When("^User selects country (.+) from the country dropdown$")
	    public void user_selects_country_from_the_country_dropdown(String countrylabel) {
	        
		  landingPage.selectCountry(countrylabel);
	    }


	   @Then("^Country (.+) is selected and Subscription package type (.+), price (.+) and currency (.+) are updated$")
	    public void country_is_selected_and_subscription_package_type_price_and_currency_are_updated(String country, String type, String price, String currency){
	       
		   String actualCountrySelected = landingPage.getCountrySelected();
		   Assert.assertEquals(actualCountrySelected, country);
		   
		   String actualSubscriptionType = landingPage.getSubscriptionType();
		   Assert.assertEquals(actualSubscriptionType, type);
		   
		   String actualPrice = landingPage.getPrice();
		   Assert.assertEquals(actualPrice, price);
		   
		   String actualCurrency = landingPage.getCurrency();
		   Assert.assertEquals(actualCurrency, currency);
		   
	    }

		@After()
		public void tearDown() {
		driver.close();

		}
		
	
}
