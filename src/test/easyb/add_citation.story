import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

description 'User can add citations to the system'

scenario "user can add citations", {
    given 'add citation is selected', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("Add citation")).click();  
    }
    when 'citation info is filled', {
        new Select(driver.findElement(By.name("type"))).selectByIndex(1);
        driver.findElement(By.name("entries['title']")).sendKeys("Computer Science 101");
        driver.findElement(By.name("entries['author']")).sendKeys("Mluukkai");
        driver.findElement(By.name("entries['year']")).sendKeys("1999");
        driver.findElement(By.name("entries['publisher']")).sendKeys("HY");
        driver.findElement(By.id("add")).submit();
    }
    then 'citation is listed', {
        driver.getPageSource().contains("Computer Science 101").shouldBe true
    }
}

scenario "Invalid citation will not be added", {
    given 'add citation is selected', { 
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("Add citation")).click();  
    }
    when 'citation info is filled with nonnumeric year', {
        new Select(driver.findElement(By.name("type"))).selectByIndex(1);
        driver.findElement(By.name("entries['title']")).sendKeys("Computer Science 101");
        driver.findElement(By.name("entries['author']")).sendKeys("Mluukkai");
        driver.findElement(By.name("entries['year']")).sendKeys("asdf");
        driver.findElement(By.name("entries['publisher']")).sendKeys("HY");
        driver.findElement(By.id("add")).submit();
    }
    then 'Citation adding fails.', {
        driver.getPageSource().contains("Computer Science 101").shouldBe false;
        /*driver.getPageSource().contains("Invalid year. Please try again.").shouldBe true*/
    }
}