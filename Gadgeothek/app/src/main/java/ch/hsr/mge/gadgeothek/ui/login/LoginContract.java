package ch.hsr.mge.gadgeothek.ui.login;

/**
 * Created by marcoribi on 28.10.17.
 */

public interface LoginContract {

    interface View {
        void setPasswordError();
        void setEmailError();
        void setFocusToPasswordView();
        void setFocusToEmailView();
    }

    interface UserActionsListener {
        boolean isInputValid(String email, String password);
    }
}
