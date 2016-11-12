package com.dev.app.week1.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dev.app.week1.R;

public class DetailActivity extends AppCompatActivity {
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
    }
}
