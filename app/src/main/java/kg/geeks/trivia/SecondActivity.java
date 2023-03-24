package kg.geeks.trivia;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {

    EditText et_email;
    EditText et_password;

    MaterialButton btn_login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);

         btn_login =findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(et_email.getText().toString(), et_password.getText().toString());
            }
        });
    }

    public void validate(String etEmail, String etPassword){
        if (etEmail.equals("admin")&&etPassword.equals("admin")){
            btn_login.setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.yellow));
        }else {
            Toast.makeText(this, "Wrong value!", Toast.LENGTH_SHORT).show();
        }


    }
}
