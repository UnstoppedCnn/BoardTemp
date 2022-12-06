package com.Dao;

import com.bean.Bean;

import java.util.List;

public interface WordDao {
    char getTop(String word);
    char getEnd(String word);
    boolean selectWord(String word);
    String selectByTop(Bean wordmessage);
}
