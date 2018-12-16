package com.example.user.breadstalk;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    private EditText etFeedback;
    private AlertDialog.Builder alertDialog;
    private String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String about = "BreadStalk is a Zimbabwe franchise product that sells a " +
                "large variety of bread. Indonesia is the first premium " +
                "boutique that presents the concept of an open kitchen with " +
                "a modern style. This concept allows BreadStalk to make bread " +
                "directly in place so that the manufacturing process can be seen " +
                "directly by the customers and the bread that is received will always be fresh.";

        TextView tvAbout = findViewById(R.id.tvAbout);
        ImageButton btnLogout = findViewById(R.id.btnAboutLogout);
        ImageButton btnBack = findViewById(R.id.btnAboutBack);

        tvAbout.setText(about);

        Button btnFeedback = findViewById(R.id.btnFeedback);
        etFeedback = findViewById(R.id.etFeedback);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();

                alertDialog = new AlertDialog.Builder(AboutActivity.this);
                alertDialog.setMessage(message);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alert = alertDialog.create();
                alert.show();
            }
        });
    }

    private void validate(){
        String feedback = etFeedback.getText().toString();

        if(feedback.length() < 25){
            message = "Feedback must be more than 25 characters long";
        }else{
            message = "Thank you for your feedback";
        }
    }
}
