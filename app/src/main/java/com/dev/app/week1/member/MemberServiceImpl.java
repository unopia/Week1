package com.dev.app.week1.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-11-12.
 */

public class MemberServiceImpl implements MemberService {
    MemberDAO memberDAO;

    public MemberServiceImpl(Context context) {
        memberDAO = new MemberDAO(context);
    }

    @Override
    public void join(MemberDTO param) {
        memberDAO.insert(param);
    }

    @Override
    public int count() {
        int count = 0;
        count = memberDAO.selectCount();
        return count;
    }

    @Override
    public MemberDTO detail(String id) {
        MemberDTO member = new MemberDTO();
        member = memberDAO.selectOne(id);
        return member;
    }

    @Override
    public ArrayList<MemberDTO> list() {
        ArrayList<MemberDTO> list = new  ArrayList<MemberDTO>();
        list = memberDAO.selectList();
        return list;
    }

    @Override
    public MemberDTO login(MemberDTO param) {
        MemberDTO member = new MemberDTO();
        member = memberDAO.login(param);
        return member;
    }

    @Override
    public void update(MemberDTO param) {
        memberDAO.update(param);
    }

    @Override
    public void delete(MemberDTO param) {
        memberDAO.delete(param);
    }
}
