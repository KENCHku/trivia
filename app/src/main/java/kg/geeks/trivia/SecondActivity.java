package kg.geeks.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {

    EditText edit_text_email;
    EditText edit_text_password;

    MaterialButton btn_login;

    TextView tv_login;
    TextView tv_warn;
    TextView tv_forgetPassword;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        edit_text_email = findViewById(R.id.et_email);
        edit_text_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        tv_login=findViewById(R.id.tv_vhod);
        tv_warn=findViewById(R.id.tv_warn);
        tv_forgetPassword=findViewById(R.id.tv_forgot);



        edit_text_email.addTextChangedListener(loginTextWatcher);
        edit_text_password.addTextChangedListener(loginTextWatcher);
//        if (et_email.getText().toString().isEmpty()&&et_password.getText().toString().isEmpty()){
//            btn_login.setBackgroundColor(ContextCompat.getColor(SecondActivity.this,R.color.gray));
//        }else {
//            btn_login.setBackgroundColor(ContextCompat.getColor(SecondActivity.this,R.color.yellow));
//        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(edit_text_email.getText().toString(), edit_text_password.getText().toString());


            }
        });
    }

    public void validate(String etEmail, String etPassword) {
        if (etEmail.equals("admin") && etPassword.equals("admin")) {
            Toast.makeText(this, "Successfully log in!", Toast.LENGTH_SHORT).show();
            tv_login.setVisibility(View.GONE);
            tv_forgetPassword.setVisibility(View.GONE);
            tv_warn.setVisibility(View.GONE);
            edit_text_email.setVisibility(View.GONE);
            edit_text_password.setVisibility(View.GONE);
            btn_login.setVisibility(View.GONE);

            //btn_login.setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.yellow));
        } else {
            Toast.makeText(this, "Wrong value!", Toast.LENGTH_SHORT).show();
        }
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String emailInput = edit_text_email.getText().toString().trim();
            String passwordInput = edit_text_password.getText().toString().trim();


            if (!emailInput.isEmpty() && !passwordInput.isEmpty()) {
                btn_login.setBackgroundColor(ContextCompat.getColor(SecondActivity.this, R.color.yellow));
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
