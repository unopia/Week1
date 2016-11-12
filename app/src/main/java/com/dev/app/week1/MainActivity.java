package com.dev.app.week1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dev.app.week1.calc.CalcActivity;
import com.dev.app.week1.member.JoinActivity;
import com.dev.app.week1.member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt_clac, bt_join, bt_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_clac = (Button) findViewById(R.id.bt_calc);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_login = (Button) findViewById(R.id.bt_login);

        bt_clac.setOnClickListener(this);
        bt_join.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_calc:
                Intent intent_calc = new Intent(this.getApplicationContext(), CalcActivity.class);
                this.startActivity(intent_calc);
                break;
            case R.id.bt_join:
                Intent intent_join = new Intent(this.getApplicationContext(), JoinActivity.class);
                this.startActivity(intent_join);
                break;
            case R.id.bt_login:
                Intent intent_login = new Intent(this.getApplicationContext(), LoginActivity.class);
                this.startActivity(intent_login);
                break;
        }
    }
}
