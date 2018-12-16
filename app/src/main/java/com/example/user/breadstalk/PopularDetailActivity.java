package com.example.user.breadstalk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PopularDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_detail);

        String itemname = getIntent().getStringExtra("itemname");
        String itemdesc = getIntent().getStringExtra("itemdesc");
        int itemimage = Integer.parseInt(getIntent().getStringExtra("itemimage"));

        TextView popDetailTitle = findViewById(R.id.popDetailTitle);
        TextView popDetailDesc = findViewById(R.id.popDetailDesc);
        ImageView popDetailImage = findViewById(R.id.popDetailImage);
        ImageButton btnLogout = findViewById(R.id.btnLogout);
        ImageButton btnBack = findViewById(R.id.btnBack);

        popDetailTitle.setText(itemname);
        popDetailDesc.setText(itemdesc);
        popDetailImage.setImageResource(itemimage);

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
