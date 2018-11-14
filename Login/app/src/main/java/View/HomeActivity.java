package View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.login.R;

import Model.LoginResponse;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LoginResponse session = new LoginResponse(getApplicationContext());

        String name = null;
        if (session.getName() != null) {
            name = session.getName();
        }

        TextView bienvenida = (TextView)findViewById(R.id.bienvenida);

        bienvenida.setText("Hola " + name);
    }

}
