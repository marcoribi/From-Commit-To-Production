package ch.hsr.gadgeothek;

import android.content.SharedPreferences;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.hsr.mge.gadgeothek.R;
import ch.hsr.mge.gadgeothek.ui.RegisterActivity;

import static android.content.Context.MODE_PRIVATE;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static ch.hsr.mge.gadgeothek.ui.AbstractAuthenticationActivity.PREFERENCES;
import static java.lang.String.valueOf;


/**
 * Created by marcoribi on 28.10.17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignUpTest {
    /*@Rule
    public ActivityTestRule<RegisterActivity> activityTestRule = new ActivityTestRule<>(RegisterActivity.class);

    @Before
    public void setUp() {
        SharedPreferences preferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        String url = preferences.getString(
                getString(R.string.settings_server_address),
                getString(R.string.settings_default_server));

        libraryService = createLibraryService(url);
    }

    @Test
    public void signUpSuccessfully() {
        onView(withId(R.id.name)).perform(typeText("Marco Ribi"));
        onView(withId(R.id.email)).perform(typeText("marco.ribi@hsr.ch"));
        onView(withId(R.id.matrikelnr)).perform(typeText(valueOf("1234568393")));
        onView(withId(R.id.password)).perform(typeText("abcde"));
        onView(withId(R.id.registerButton)).perform(click());

        onView(withId(R.id.viewpager)).check(matches(isDisplayed()));
    }*/
}
