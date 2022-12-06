package com.Dao;

import com.bean.Board;

import java.util.List;

public interface BoardDao {
    void insert(String anthor,String title,String board);
    List<Board> queryAll();
    void delete(String anthor,String title,String board);
}
