package com.Impl;

import com.Dao.WordDao;
import com.bean.Bean;
import com.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordImpl implements WordDao {

    @Override
    public char getTop(String word) {
        return word.charAt(0);
    }

    @Override
    public char getEnd(String word) {
        return word.charAt(3);
    }

    @Override
    public boolean selectWord(String word) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select word from idiom where word=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,word);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return false;
    }

    @Override
    public String selectByTop(Bean wordmessage) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select word from idiom where word like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, wordmessage.getEnd() +"%");
            rs = ps.executeQuery();
            List<String> temp = new ArrayList<>();
            while(rs.next()){
                String tempWord = rs.getString("word");
                temp.add(tempWord);
            }
            int random = new Random().nextInt(temp.size()-1);
            return temp.get(random);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return null;
    }
}
