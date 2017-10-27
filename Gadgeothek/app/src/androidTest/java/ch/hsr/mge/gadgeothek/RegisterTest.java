package ch.hsr.mge.gadgeothek;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import ch.hsr.mge.gadgeothek.http.Endpoint;
import ch.hsr.mge.gadgeothek.http.HttpProxy;
import ch.hsr.mge.gadgeothek.ui.RegisterActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest {

    private HttpProxy httpProxy;

    @Before
    public void setUp() {
        httpProxy = GadgeothekTestApplication.httpProxy;
    }


    @Rule
    public ActivityTestRule<RegisterActivity> activityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void showsRegisterActivity() throws InterruptedException {
        // This sleep is needed because SplashActivity uses postDelayed with a delay of 2000 ms
        onView(withId(R.id.registerButton)).check(matches(isDisplayed()));
    }
}
