package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsGrolls {

	private WebDriver driver;

	@Given("I have browsed to the t-shirt page")
	public void i_have_browsed_to_the_t_shirt_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html\r\n");
		driver.manage().window().maximize();
	}

	@Given("I have chosen S in size SelectByValue")
	public void i_have_chosen_s_in_size_select_by_value() throws InterruptedException {
		Select dropDown = new Select(driver.findElement(By.name("super_attribute[400]")));
		dropDown.selectByValue("1419");
		Thread.sleep(2000);
	}

	@Given("I have clicked the plus button to get {int} in amount")
	public void i_have_clicked_the_plus_button_to_get_in_amount(Integer int1) throws InterruptedException {
		driver.findElement(By.className("qty-plus")).click();
		Thread.sleep(2000);
		WebElement amount = driver.findElement(By.cssSelector("input.input-text.qty"));
		assertEquals("2", amount.getAttribute("value"));
	}

	@Given("I have chosen S in size SelectByIndex")
	public void i_have_chosen_s_in_size_select_by_index() {
		Select dropDown = new Select(driver.findElement(By.name("super_attribute[400]")));
		dropDown.selectByIndex(3);
	}

	@Given("I have entered {int} in amount")
	public void i_have_entered_in_amount(Integer int1) throws InterruptedException {
		WebElement amount = driver.findElement(By.cssSelector("input.input-text.qty"));
		amount.clear();
		amount.sendKeys("2");
		assertEquals("2", amount.getAttribute("value"));
		Thread.sleep(2000);
	}

	@When("I add to cart")
	public void i_add_to_cart() {
		driver.findElement(By.id("product-addtocart-button")).click();
	}

	@Then("I should see 2 in the cart icon")
	public void i_should_see_in_the_cart_icon() throws InterruptedException {
		Thread.sleep(2000);
		WebElement numberInCart = driver.findElement(By.xpath("/html/body/div[4]/header/div[3]/div[4]/a/span/span[1]"));
		assertEquals("2", numberInCart.getAttribute("outerText"));
		driver.quit();
	}

}
