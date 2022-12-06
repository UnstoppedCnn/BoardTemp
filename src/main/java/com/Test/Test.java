package com.Test;

import com.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Test {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            conn = DBUtil.getConnection();
            String sql = "select *from item";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
    }
}
