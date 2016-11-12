package com.dev.app.week1.member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dev.app.week1.R;

public class LoginActivity extends AppCompatActivity {
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());
    }
}
