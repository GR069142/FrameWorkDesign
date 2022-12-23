package ValueLabs.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ValueLabs.ReusableUtils.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "translation-btn")
	private WebElement englishButton;
	
	@FindBy(css = "span#arrow")
	private WebElement countryDropdown;
	
	@FindBy(id = "country-title")
	private WebElement countryTitleHeader;
	
	@FindBy(id = "country-name")
	private WebElement countrySelected;
	
	@FindBy(xpath = "//div[@class='trial-description']/h4")
	private WebElement subscriptionType;
	
	@FindBy(xpath = "//div[@class='trial-cost']/b")
	private WebElement price;
	
	@FindBy(xpath = "//div[@class='trial-cost']")
	private WebElement currencyText;

	public void goTo()
	{
		driver.get("https://subscribe.stctv.com/");
	}
	
	public void selectEngishLanguage()
	{
		englishButton.click();
	}
	
	public void selectCountry(String countryLabel)
	{
		countryDropdown.click();
		waitForWebElementToAppear(countryTitleHeader);
		
		List<WebElement> countries = driver.findElements(By.cssSelector(".country"));
		
		for(int i=0; i<countries.size(); i++)
		{
			if(countries.get(i).getAttribute("id").equalsIgnoreCase(countryLabel))
			{
				countries.get(i).click();
				break;
			}
		}	
	}
	
	public String getCountrySelected()
	{
		return countrySelected.getText();
	}
	
	public String getSubscriptionType()
	{
		return subscriptionType.getText();
	}
	
	public String getPrice()
	{
		return price.getText();
	}
	
	public String getCurrency()
	{
		String[] currencysplit = currencyText.getText().split(" ");
		String[] currency = currencysplit[2].split("/");
		return currency[0].trim();
	}
}
