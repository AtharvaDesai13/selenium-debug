package seleniumdebug;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThatNoException;

public class CreateNewSessionTest {

    @Test
    public void createNewSession() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.enableBiDi();

        assertThatNoException().isThrownBy(() -> 
            RemoteWebDriver.builder()
                .address(URI.create("http://localhost:4444")) // FIX: use URI.create
                .oneOf(chromeOptions)
                .build()
        );
    }
}
