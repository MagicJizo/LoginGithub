package View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.login.R;

import Controller.Request;
import Model.LoginResponse;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent;
        LoginResponse session = new LoginResponse(getApplicationContext());

        if (session != null && session.getRemember() != null && Boolean.valueOf(session.getRemember())) {
            String token = session.getToken();

            Request request = new Request();
            request.loginTokenRequest(token, getApplicationContext());
            intent = new Intent(this, HomeActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }

        startActivity(intent);
    }
}