import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'User wants citations to be listed in a friendly way'

scenario "At first there are no citations", {
    given 'We are in the page', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
    }
    when 'Listing is selected', {
        driver.findElement(By.linkText("List citations")).click();
    }
    then 'No citations are listed', {
        driver.getPageSource().contains("</li>").shouldBe false
    }
}