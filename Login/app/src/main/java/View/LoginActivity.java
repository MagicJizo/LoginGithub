package View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.example.login.R;

import Controller.Request;
import Model.LoginResponse;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intentHome = new Intent(this, HomeActivity.class);

        Button logIn = (Button) findViewById(R.id.logIn);

        logIn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);

                Request request = new Request();
                request.loginCredentialsRequest(username.getText().toString(), password.getText().toString(), getApplicationContext());

                Intent intentHome = new Intent(getApplicationContext(), HomeActivity.class);

                CheckBox remember = (CheckBox) findViewById(R.id.remember);
                LoginResponse session = new LoginResponse(getApplicationContext());
                session.setRemember(String.valueOf(remember.isChecked()));

                startActivity(intentHome);
            }
        });

        EditText username = (EditText) findViewById(R.id.username);

        username.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                EditText password = (EditText) findViewById(R.id.password);
                Button logIn = (Button) findViewById(R.id.logIn);
                if (s.toString().trim().length() != 0 && password.getText().toString().trim().length() != 0) {
                    logIn.setEnabled(true);
                } else {
                    logIn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText password = (EditText) findViewById(R.id.password);

        password.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                EditText username = (EditText) findViewById(R.id.username);
                Button logIn = (Button) findViewById(R.id.logIn);
                if (s.toString().trim().length() != 0 && username.getText().toString().trim().length() != 0) {
                    logIn.setEnabled(true);
                } else {
                    logIn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}