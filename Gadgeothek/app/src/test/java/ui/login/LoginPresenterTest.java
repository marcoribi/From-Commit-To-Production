package ui.login;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ch.hsr.mge.gadgeothek.ui.login.LoginActivity;
import ch.hsr.mge.gadgeothek.ui.login.LoginContract;
import ch.hsr.mge.gadgeothek.ui.login.LoginPresenter;

import static org.mockito.Mockito.mock;

/**
 * Created by marcoribi on 29.10.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    @Before
    public void setup() {
        LoginContract.View view = mock(LoginContract.View.class);
        LoginPresenter presenter = new LoginPresenter(view);
    }

    @Test
    public void testInputIsValid() {


    }

    @Test
    public void testInputIsInvalid() {

    }
}
