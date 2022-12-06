package com.bean;

public class Bean {
    String idiom;
    char top;
    char end;

    public Bean() {
    }

    public Bean(String idiom, char top, char end) {
        this.idiom = idiom;
        this.top = top;
        this.end = end;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public char getTop() {
        return top;
    }

    public void setTop(char top) {
        this.top = top;
    }

    public char getEnd() {
        return end;
    }

    public void setEnd(char end) {
        this.end = end;
    }
}
