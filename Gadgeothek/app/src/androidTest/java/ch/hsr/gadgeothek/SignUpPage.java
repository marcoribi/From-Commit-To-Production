package ch.hsr.gadgeothek;

import ch.hsr.mge.gadgeothek.R;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.String.valueOf;

/**
 * Created by marcoribi on 28.10.17.
 */

public class SignUpPage {
    public String name;
    public String email;
    public String matNumber;
    public String password;


    public void SignUpPage(String name, String email, String matNumber, String password) {
        this.email = email;
        this.name = name;
        this.matNumber = matNumber;
        this.password = password;
    }

    public void verify() {

    }
}
