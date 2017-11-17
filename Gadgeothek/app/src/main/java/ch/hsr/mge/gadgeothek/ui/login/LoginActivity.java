package ch.hsr.mge.gadgeothek.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import ch.hsr.mge.gadgeothek.R;
import ch.hsr.mge.gadgeothek.ui.AbstractAuthenticationActivity;
import ch.hsr.mge.gadgeothek.ui.RegisterActivity;

public class LoginActivity extends AbstractAuthenticationActivity implements LoginContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText emailView;
    private EditText passwordView;
    private View progressView;
    private View loginFormView;
    private View focusView;
    private LoginContract.UserActionsListener presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new LoginPresenter(this);

        // Set up the login form.
        emailView = (EditText) findViewById(R.id.email);
        passwordView = (EditText) findViewById(R.id.password);

        emailView.setText("m@hsr.ch");
        passwordView.setText("12345");

        SharedPreferences preferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        String email = preferences.getString(EMAIL, null);
        String password = preferences.getString(PASSWORD, null);
        emailView.setText(email);
        passwordView.setText(password);

        findViewById(R.id.signInButton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        loginFormView = findViewById(R.id.login_form);
        progressView = findViewById(R.id.login_progress);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    public void attemptLogin() {
        // Reset errors.
        resetLoginFields();

        // Store values at the time of the login attempt.
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;

        // Validations
        cancel = presenter.isInputValid(email, password);

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            hideSoftKeyboard(loginFormView);
            showProgress(loginFormView, progressView, true);
            login(email, password, false);
        }
    }

    @Override
    public void setFocusToPasswordView() {
        this.focusView = this.passwordView;
    }

    @Override
    public void setFocusToEmailView() {
        this.focusView = this.emailView;
    }

    @Override
    public void setEmailError() {
        emailView.setError(getString(R.string.error_field_required));
    }

    @Override
    public void setPasswordError() {
        passwordView.setError(getString(R.string.error_field_required));
    }

    public void resetLoginFields() {
        emailView.setError(null);
        passwordView.setError(null);
    }

    protected void loginSucceeded(boolean isAutoLogin) {
        startMainActivity(isAutoLogin);
    }

    protected void loginFailed(String message) {
        showProgress(loginFormView, progressView, false);
        showInDismissableSnackbar(loginFormView, message);
    }

    public void onRegisterButton(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right_to_left, R.anim.slide_out_right_to_left);
    }
}
