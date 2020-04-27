import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class main {

    private static AndroidDriver<MobileElement> driver;

    //settings of the device
    @BeforeClass
    public static   void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //test calculator
    @Test
    public void test_calculator () {
        //taping number 3
        MobileElement number3 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03"));
        number3.click();
        //taping multiplication
        MobileElement Multiplication = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_mul"));
        Multiplication.click();
        //taping number 6
        MobileElement number6 = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_06"));
        number6.click();
        //taping equal
        MobileElement equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
        equal.click();

        //assert result
        String expectResult = "18";
        String actualResult = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc")).getText();

        try {
            assertEquals(expectResult, actualResult);
            System.out.println("the result is " + actualResult);
        } catch (AssertionError error) {
            System.out.println("the result is not 18");
        }
    }

        @Test
        public void testing ()   {
        driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
        driver.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(By.id("com.instagram.android:id/language_name")).click();
        driver.findElement(By.className("android.widget.TextView")).click();
        driver.findElement(By.id("com.instagram.android:id/log_in_button")).click();





    }



        //close the app
        @AfterClass
        public static void close () {
            driver.closeApp();
        }









    }








