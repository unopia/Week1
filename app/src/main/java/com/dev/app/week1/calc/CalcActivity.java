package com.dev.app.week1.calc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dev.app.week1.MainActivity;
import com.dev.app.week1.R;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_first,et_second;
    Button bt_plus,bt_minus,bt_times,bt_div,bt_mod,bt_equal,bt_pre;
    TextView tv_result;
    int result;
    CalcService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcl);
        service = new CalcServicelmpl();

        et_first = (EditText) findViewById(R.id.et_first);
        et_second = (EditText) findViewById(R.id.et_second);
        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_times = (Button) findViewById(R.id.bt_times);
        bt_div = (Button) findViewById(R.id.bt_div);
        bt_mod = (Button) findViewById(R.id.bt_mod);
        bt_equal = (Button) findViewById(R.id.bt_equal);
        bt_pre = (Button) findViewById(R.id.bt_pre);
        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_times.setOnClickListener(this);
        bt_div.setOnClickListener(this);
        bt_mod.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
        bt_pre.setOnClickListener(this);

        result = 0;

    }

    @Override
    public void onClick(View v) {
        int firstNum = Integer.parseInt(et_first.getText().toString());
        int secondNum = Integer.parseInt(et_second.getText().toString());
        CalcDTO dto = new CalcDTO();
        dto.setFirst(firstNum);
        dto.setSecond(secondNum);

        switch (v.getId()){
            case R.id.bt_plus :
                result = service.plus(dto);
                break;
            case R.id.bt_minus :
                result = service.minus(dto);
                break;
            case R.id.bt_times :
                result = service.times(dto);
                break;
            case R.id.bt_div:
                result = service.div(dto);
                break;
            case R.id.bt_mod :
                result = service.mod(dto);
                break;
            case R.id.bt_equal :
                tv_result.setText("Result : " + result);
                break;
            case R.id.bt_pre:
                Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}
