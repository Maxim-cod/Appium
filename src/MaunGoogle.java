import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MaunGoogle {

    private static AndroidDriver<MobileElement> driver;
    //run once before test
    @BeforeClass
    public static void setUp() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");

        capabilities.setCapability("newCommandTimeout", 120);
//        capabilities.setCapability("unicodekeyboard", true);
//        capabilities.setCapability("resetkeyboard", true);

        //ip server
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);

        //waiting function
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    //test google
    @Test
    public void test_chrome() {
        //click on search box
        driver.findElement(MobileBy.id("com.android.chrome:id/search_box_text")).click();
        //tap button f
        driver.pressKey(new KeyEvent(AndroidKey.F));
        //tap button o
        driver.pressKey(new KeyEvent(AndroidKey.O));
        //tap button x
        driver.pressKey(new KeyEvent(AndroidKey.X));
        //press on search button
        driver.findElement(MobileBy.className("android.widget.ImageView")).click();
        //print how many links you got after searching
        List<MobileElement> Links = driver.findElements(MobileBy.className("android.view.View"));
        System.out.println(Links.size());
        //enter to one of the links
        driver.findElement(MobileBy.xpath("//android.view.View[@text='https://www.terminalx.com › brands תוצאות באינטרנט מוצרים מובילים של פוקס - FOX נחתו בטרמינל | TERMINAL X']")).click();

    }
        //close app
        @AfterClass
        public static void close () throws InterruptedException {
        Thread.sleep(2000);
        driver.closeApp();










    }

}
