package chhaichivon.com.androiddebugcode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.etEmail)
    EditText mEditTextEmail;
    @BindView(R.id.etPassword)
    EditText mEditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @SuppressLint("NewApi")
    @OnClick(R.id.btnLogin)
    public void onLogin(View view) {
        if (isCorrectEmail(mEditTextEmail.getText().toString()) && isCorrectPassword(mEditTextPassword.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
            resetForm();
            Intent intent = new Intent(getApplicationContext(), NavigationDrawerActivity.class);
            startActivity(intent);
            super.finish();
        } else {
            Toast.makeText(getApplicationContext(), "Login fail", Toast.LENGTH_LONG).show();
            resetForm();
            mEditTextEmail.setShowSoftInputOnFocus(true);
        }
    }


    public Boolean isCorrectEmail(String email) {
        if (email.contains("@")) {
            return true;
        }
        return false;
    }

    public Boolean isCorrectPassword(String password) {
        if (password.length() >= 6) {
            return true;
        }
        return false;
    }

    public void resetForm(){
        mEditTextEmail.setText("");
        mEditTextPassword.setText("");
    }
}
