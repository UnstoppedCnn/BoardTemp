package com.bean;

public class Board {
    String anthor;
    String title;
    String board;

    public Board() {
    }

    public Board(String anthor, String title, String board) {
        this.anthor = anthor;
        this.title = title;
        this.board = board;
    }

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
}
