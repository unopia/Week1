package com.dev.app.week1.member;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.app.week1.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    MemberService service;
    ListView lv_member;
    final String[] arr = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberDTO> list = service.list();
        Log.d("친구 수", String.valueOf(list.size()));
        lv_member = (ListView) findViewById(R.id.lv_member);
        lv_member.setAdapter(new MemberAdapter(this,list));
        lv_member.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_member.getItemAtPosition(i);
                MemberDTO member = (MemberDTO) o;
                Toast.makeText(ListActivity.this, "선택한 이름" + member.getName(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });
        lv_member.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lv_member.getItemAtPosition(i);
                MemberDTO member = (MemberDTO) o;
                Toast.makeText(ListActivity.this, "삭제할 이름" + member.getName(),Toast.LENGTH_LONG).show();
                arr[0] = member.getId();
                new AlertDialog.Builder(ListActivity.this).setTitle("삭제 OK").setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //삭제코드
                        service.delete(arr[0]);
                        startActivity(new Intent(ListActivity.this, ListActivity.class));
                    }
                })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //취소 코드
                    }
                }).show();
                return true;
            }
        });
    }
}
