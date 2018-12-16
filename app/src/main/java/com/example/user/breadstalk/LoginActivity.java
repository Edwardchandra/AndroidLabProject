package com.example.user.breadstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.etusername);
        password = findViewById(R.id.etpassword);
        Button login = findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();

                if(valid){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("email", username.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    private void validate(){

        String userid = username.getText().toString();
        String userpass = password.getText().toString();

        if(userid.isEmpty()){
            Toast.makeText(this, "Email must not be empty", Toast.LENGTH_SHORT).show();
            valid = false;
        }else if(userid.length()<7){
            Toast.makeText(this, "Email must be longer than 6 characters", Toast.LENGTH_SHORT).show();
            valid = false;
        }else if(userpass.isEmpty()){
            Toast.makeText(this, "Password must not be empty", Toast.LENGTH_SHORT).show();
            valid = false;
        }else{
            valid = true;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
