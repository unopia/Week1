package com.dev.app.week1.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dev.app.week1.R;
import com.dev.app.week1.member.LoginActivity;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        bt_regist = (Button) findViewById(R.id.bt_regist);
        bt_regist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
        this.startActivity(intent);
    }
}
