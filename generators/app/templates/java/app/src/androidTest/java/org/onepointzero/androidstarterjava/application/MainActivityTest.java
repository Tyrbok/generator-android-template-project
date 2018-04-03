package <%= packageName %>.application;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import <%= packageName %>.support.BaseActivityTest;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends BaseActivityTest {

    @Test
    public void should_display_custom_mock_message() {

        getAppModule().setMessage("Foo");

        activity.launchActivity(null);

        assertDisplayed("Foo");
    }

    @Test
    public void should_display_default_mock_message() {

        getAppModule().setMessage("Foo");

        activity.launchActivity(null);

        assertDisplayed("Foo");
    }
}