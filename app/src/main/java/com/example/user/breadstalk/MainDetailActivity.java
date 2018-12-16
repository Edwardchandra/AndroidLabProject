package com.example.user.breadstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);

        String itemname = getIntent().getStringExtra("itemname");
        String itemdesc = getIntent().getStringExtra("itemdesc");
        int itemimage = Integer.parseInt(getIntent().getStringExtra("itemimage"));

        TextView mainDetailTitle = findViewById(R.id.mainDetailTitle);
        TextView mainDetailDesc = findViewById(R.id.mainDetailDesc);
        ImageView mainDetailImage = findViewById(R.id.mainDetailImage);

        mainDetailTitle.setText(itemname);
        mainDetailDesc.setText(itemdesc);
        mainDetailImage.setImageResource(itemimage);

        ImageButton btnLogout = findViewById(R.id.btnLogout);
        ImageButton btnBack = findViewById(R.id.btnBack);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
