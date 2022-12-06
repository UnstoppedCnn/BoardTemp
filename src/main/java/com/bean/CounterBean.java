package com.bean;

public class CounterBean {
    private int count = 0;

    public int getCount() {
        count++;
        return count;
    }

    public CounterBean() {
    }

    public CounterBean(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
