package ch.hsr.mge.gadgeothek.ui.login;

import android.text.TextUtils;
import android.view.View;

import ch.hsr.mge.gadgeothek.R;

/**
 * Created by marcoribi on 28.10.17.
 */

public class LoginPresenter implements LoginContract.UserActionsListener {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public boolean isInputValid(String email, String password) {
        if (isPasswordValid(password)) {
            return true;
        } else if (isEmailValid(email)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordValid(String password) {
        if (TextUtils.isEmpty(password)) {
            view.setPasswordError();
            view.setFocusToPasswordView();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailValid(String email) {
        if (TextUtils.isEmpty(email)) {
            view.setEmailError();
            view.setFocusToEmailView();
            return true;
        } else {
            return false;
        }
    }
}
