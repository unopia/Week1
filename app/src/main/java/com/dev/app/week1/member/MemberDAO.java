package com.dev.app.week1.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(MemberDTO param){
        Log.d("JOIN ID : ", param.getId());
        Log.d("JOIN PW : ", param.getPw());
        Log.d("JOIN NAME : ", param.getName());
        Log.d("JOIN EMAIL : ", param.getEmail());
        Log.d("JOIN PHONE : ", param.getPhone());
        Log.d("JOIN ADDR : ", param.getAddr());

        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public int selectCount(){
        int count = 0;
        return count;
    }
    public MemberDTO selectOne(String id){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public ArrayList<MemberDTO> selectList(){
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        return list;
    }

    public MemberDTO login(MemberDTO param) {
        Log.d("JOIN ID : ", param.getId());
        Log.d("JOIN PW : ", param.getPw());
        MemberDTO member = new MemberDTO();
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        return member;
    }
    public void update(MemberDTO param){

    }
    public void delete(MemberDTO param){

    }
}
