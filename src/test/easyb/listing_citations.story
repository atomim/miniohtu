import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import ohtu.miniohtu.testhelpers.UsefulMethods;

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
        driver.findElement(By.id(“list”)).shouldBe false;
    }
}

scenario "Citations are listed if any exist", {
    given 'We are in the page', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("Add citation")).click();

        driver = UsefulMethods.addCitation(driver, "", "Computer Science 101");
    }
    when 'Listing is selected', {
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("List citations")).click();
    }
    then 'Citation is listed', {
        driver.getPageSource().contains("Computer Science 101").shouldBe true
        driver.findElement(By.linkText("Remove")).click();
    }
}