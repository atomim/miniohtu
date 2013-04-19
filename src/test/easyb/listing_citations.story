import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.getPageSource().contains("<li><strong>Title: ").shouldBe false
    }
}

scenario "Citations are listed if any exist", {
    given 'We are in the page', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("Add citation")).click();  

        new Select(driver.findElement(By.name("type"))).selectByIndex(1);
        driver.findElement(By.name("entries['title']")).sendKeys("Computer Science 101");
        driver.findElement(By.name("entries['author']")).sendKeys("Mluukkai");
        driver.findElement(By.name("entries['year']")).sendKeys("1999");
        driver.findElement(By.name("entries['publisher']")).sendKeys("HY");
        driver.findElement(By.id("add")).submit();
    }
    when 'Listing is selected', {
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("List citations")).click();
    }
    then 'Citation is listed', {
        driver.getPageSource().contains("<strong>Title: Computer Science 101</strong>").shouldBe true
    }    
}