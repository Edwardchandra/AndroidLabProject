package com.example.user.breadstalk;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    int currPage = 0;
    Timer timer;
    final long DELAY = 500;
    final long PERIOD = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String email = String.format(getResources().getString(R.string.welcome), getIntent().getStringExtra("email"));

        TextView tvemail = findViewById(R.id.tvwelcome);
        viewPager = findViewById(R.id.viewpager);
        ImageView aboutImageView = findViewById(R.id.aboutImgView);
        ImageButton btnLogout = findViewById(R.id.btnLogout);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        aboutImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        tvemail.setText(email);
        viewPager.setAdapter(adapter);

        carousel();

    }

    private void carousel(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currPage == 3) {
                    currPage = 0;
                }
                viewPager.setCurrentItem(currPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, DELAY, PERIOD);
    }

}
