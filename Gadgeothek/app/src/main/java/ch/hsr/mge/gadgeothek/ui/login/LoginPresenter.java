package ch.hsr.mge.gadgeothek.ui.login;

/**
 * Created by marcoribi on 28.10.17.
 */

public class LoginPresenter implements LoginContract.UserActionsListener {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }
}
