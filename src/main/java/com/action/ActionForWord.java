package com.action;

public class ActionForWord {
    public int isFourMethod(String word){
        int a = word.length();
        if(a==4&& checkword(word)){
            return 1;
        }else {
            return 0;
        }
    }
    public boolean checkword(String name)
    {
        int n = 0;
        for(int i = 0; i < name.length(); i++) {
            n = (int)name.charAt(i);
            if(!(19968 <= n && n <40869)) {
                return false;
            }
        }
        return true;
    }
    public String topWord(String word){
        String i = String.valueOf(word.charAt(0));
        return i;
    }
    public String lastWore(String word){
        String i = String.valueOf(word.charAt(3));
        return i;
    }
}
