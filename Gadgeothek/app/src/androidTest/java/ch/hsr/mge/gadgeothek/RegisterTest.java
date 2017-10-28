package ch.hsr.mge.gadgeothek;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import ch.hsr.mge.gadgeothek.http.HttpProxy;
import ch.hsr.mge.gadgeothek.ui.RegisterActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static ch.hsr.mge.gadgeothek.http.Endpoint.get;
import static ch.hsr.mge.gadgeothek.http.Endpoint.post;
import static java.lang.String.valueOf;

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

    @Test
    public void registerSuccessfully() throws InterruptedException {
        httpProxy.mockCall(post("/public/register"), "true");
        String loginToken = "{\"customerId\": \"1111\", \"securityToken\": \"myToken\" }";
        httpProxy.mockCall(post("/public/login"), loginToken);
        httpProxy.mockCall(get("/public/loans"), "[]");
        httpProxy.mockCall(get("/public/reservations"), "[]");

        onView(withId(R.id.name)).perform(typeText("Marco Ribi"));
        closeSoftKeyboard();
        onView(withId(R.id.email)).perform(typeText("marco.ribi@hsr.ch"));
        closeSoftKeyboard();
        onView(withId(R.id.matrikelnr)).perform(typeText("1234568393"));
        closeSoftKeyboard();
        onView(withId(R.id.password)).perform(typeText("abcde1"));
        closeSoftKeyboard();
        onView(withId(R.id.registerButton)).perform(click());

        onView(withId(R.id.viewpager)).check(matches(isDisplayed()));
    }
}
