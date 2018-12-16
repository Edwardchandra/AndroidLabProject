package com.example.user.breadstalk;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ProductActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener
        , PopularFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TabLayout productTabLayout = findViewById(R.id.productTabLayout);
        ViewPager productViewPager = findViewById(R.id.productViewPager);
        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageButton btnLogout = findViewById(R.id.btnLogout);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new MainFragment(), "All Breads");
        tabAdapter.addFragment(new PopularFragment(), "Popular Breads");

        productViewPager.setAdapter(tabAdapter);
        productTabLayout.setupWithViewPager(productViewPager);

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

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
