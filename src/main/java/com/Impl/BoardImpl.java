package com.Impl;


import com.Dao.BoardDao;
import com.bean.Board;
import com.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements BoardDao {

    List<Board> boards = new ArrayList<>();
    @Override
    public void insert(String anthor, String title, String board) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into boards(anthor, title, board) VALUES (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,anthor);
            ps.setString(2,title);
            ps.setString(3,board);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }

    @Override
    public List<Board> queryAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from boards";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String anthor = rs.getString("anthor");
                String title = rs.getString("title");
                String board = rs.getString("board");
                Board a = new Board();
                a.setAnthor(anthor);
                a.setTitle(title);
                a.setBoard(board);
                System.out.println(board);
                boards.add(a);
            }
            return boards;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String anthor, String title, String board) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from boards where anthor=? and title=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,anthor);
            ps.setString(2,title);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
