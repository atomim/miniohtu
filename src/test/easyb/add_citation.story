import miniohtu.*;
import org.seleniumhq.selenium.*;

description 'User can add citations to the system'

scenario "user can add citations", {
    given 'add citation is selected'/*, { 
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/miniohtu");
        element = driver.findElement(By.linkText("Add citation"));       
        element.click();  
    }*/
    when 'citation info is filled'/*, {
        element = driver.findElement(By.name("booktitle"));
        element.sendKeys("Computer Science 101");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Mluukkai");
        element = driver.findElement(By.name("year"));
        element.sendKeys("1999");
        element = driver.findElement(By.name("publisher"));
        element.sendKeys("HY");
        element = driver.findElement(By.id("add"));
        element.submit();
    }*/
    then 'citation is listed'/*, {
        driver.getPageSource().contains("Computer Science 101").shouldBe true
    }*/
}

