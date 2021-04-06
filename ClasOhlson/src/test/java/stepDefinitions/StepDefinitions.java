package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;
	
		@Given("I have opened the superlim page")
		public void i_have_opened_the_superlim_page() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.clasohlson.com/se/Superlim-Loctite-Precision,-5-g/p/25-1544");
			driver.manage().window().maximize();
			driver.findElement(By.className("btn-text")).click();
			Thread.sleep(3000);
		}

		@Given("I have changed the amount to {int}")
		public void i_have_changed_the_amount_to(Integer int1) {
			WebElement plusButton = driver.findElement(By.className("plus-button"));
			plusButton.click();
			WebElement amount = driver.findElement(By.className("product-qty"));
			assertEquals("2", amount.getAttribute("value"));	

		}
		
		@When("I press add to cart")
		public void i_press_add_to_cart() throws InterruptedException {
		   WebElement addToCart = driver.findElement(By.xpath("/html/body/main/div[4]/div[1]/div[3]/section[2]/div/div[2]/div[4]/div[2]/div[2]/button"));
		   addToCart.click();
		   Thread.sleep(3000);
		}
		
		@Then("I should see {int} appears in the cart icon")
		public void i_should_see_appears_in_the_cart_icon(Integer int1) {
		    WebElement numberInCart = driver.findElement(By.cssSelector("div.mini-cart-count.js-mini-cart-count"));
			assertEquals("2", numberInCart.getAttribute("outerText"));
			driver.quit();
		}

}
