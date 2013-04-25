import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import ohtu.miniohtu.testhelpers.UsefulMethods;

description 'User can add citations to the system'

scenario "user can add citations", {
    given 'went to the webpage', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("Add citation")).click();  
    }
    when 'citation info is filled', {
        driver = UsefulMethods.addCitation(driver, "cs101", "Computer Science 101");
    }
    then 'citation is listed', {
        driver.getPageSource().contains("cs101").shouldBe true
        driver.getPageSource().contains("Computer Science 101").shouldBe true

        driver.findElement(By.linkText("Remove")).click();
    }
}

scenario 'Also the link at listing page works', {
    given 'went to the webpage', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("List citations")).click();
        driver.findElement(By.linkText("Add another")).click();
    }
    when 'citation info is filled', {
        driver = UsefulMethods.addCitation(driver, "asdf", "new book");
    }
    then 'citation is listed', {
        driver.getPageSource().contains("asdf").shouldBe true
        driver.getPageSource().contains("new book").shouldBe true
        
        driver.findElement(By.linkText("Remove")).click();
    }
}