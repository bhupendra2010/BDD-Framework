package org.lyodspharmacy;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefination {
   static WebDriver driver;
     String baseurl;

    @Before
            public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        baseurl = "http://www.lloydspharmacy.com/";

    }

    @Given("^I am on homepage$")
    public void i_am_on_homepage()  {
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @When("^I search for the product$")
    public void i_search_for_the_product()  {
        driver.findElement(By.xpath("//*[@id=\"catButtons\"]/div[1]/div[1]")).click();
        //*[@id="catButtons"]/div[1]/div[1]/a/span

    }

    @When("^I found my required product$")
    public void i_found_my_required_product()  {
        driver.findElement(By.xpath("//*[@id=\"productThumbNailImage_20600\"]")).click();

    }

    @Then("^I should put it in basket for checkout$")
    public void i_should_put_it_in_basket_for_checkout() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='btnAction']")).click();
        driver.findElement(By.cssSelector("button[data-catentryid='20599']")).click();

    }


}
