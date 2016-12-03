package com.dev.app.week1.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.app.week1.R;
import com.dev.app.week1.util.MapsActivity;
import com.dev.app.week1.util.Phone;
import com.dev.app.week1.util.WebActivity;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    MemberService service;
    ImageView iv_photo;
    TextView tv_name, tv_id, tv_pw, tv_email, tv_phone, tv_address;
    Button bt_call, bt_message, bt_map, bt_movie, bt_update, bt_list;
    String id = "";
    Phone phone;
    MemberDTO member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        tv_name = (TextView) findViewById(R.id.tv_name);
        Log.d("tv_name", tv_name.getText().toString());
        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_phone = (TextView) findViewById(R.id.tv_phone);
        tv_address = (TextView) findViewById(R.id.tv_address);
        id = this.getIntent().getExtras().getString("id");
        member = service.detail(id);
        Log.d("member", member.getName());
        if(member != null){
            tv_name.setText(member.getName());
            tv_id.setText(member.getId());
            tv_email.setText(member.getEmail());
            tv_address.setText(member.getAddr());
            tv_phone.setText(member.getPhone());
            tv_pw.setText(member.getPw());
            // iv_photo
        }else{
            Log.d("아이디가 존재","하지 않음");
        }
        bt_call = (Button) findViewById(R.id.bt_call);
        bt_message = (Button) findViewById(R.id.bt_message);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);

        bt_call.setOnClickListener(this);
        bt_message.setOnClickListener(this);
        bt_map.setOnClickListener(this);
        bt_movie.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt_call :
                Log.d("전화번호클릭:","OK");
                phone = new Phone(this, this);
                phone.directCall(member.getPhone());
                break;
            case R.id.bt_message :

                break;
            case R.id.bt_map :
                Log.d("구글맵 클릭:","OK");
                intent = new Intent(DetailActivity.this, MapsActivity.class);
                //시청 37.5665350,126.9779690
                String pos = member.getAddr();
                pos = "37.5665350,126.9779690";
                intent.putExtra("pos", pos);
                startActivity(intent);
                break;
            case R.id.bt_movie :
                Intent intent_movie = new Intent(DetailActivity.this, WebActivity.class);
                startActivity(intent_movie);
                break;
            case R.id.bt_update :
                intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
            case R.id.bt_list :
                Intent intent_back = new Intent(DetailActivity.this, ListActivity.class);
                startActivity(intent_back);
                break;
        }
    }
}
