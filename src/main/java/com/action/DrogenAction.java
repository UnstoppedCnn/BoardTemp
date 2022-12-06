package com.action;


import com.Dao.WordDao;
import com.Impl.WordImpl;
import com.bean.Bean;
import com.bean.Board;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/drogen")
public class DrogenAction extends HttpServlet {
    WordDao wordaction = new WordImpl();
    List<Bean> beanList = new ArrayList<>();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word = request.getParameter("word");
        boolean wordIsIdiom = wordaction.selectWord(word);
        char a=0;
        char b=0;
        if(beanList.size()!=0){
            b = wordaction.getTop(word);
            a = beanList.get(beanList.size()-1).getEnd();
        }
        if(wordIsIdiom&&a==b){
            char top = wordaction.getTop(word);
            char end = wordaction.getEnd(word);
            Bean bean = new Bean();
            bean.setTop(top);
            bean.setEnd(end);
            bean.setIdiom(word);
            beanList.add(bean);
            String retuenword = wordaction.selectByTop(bean);
            Bean bean1 = new Bean();
            char returnwordtop = wordaction.getTop(retuenword);
            char returnwordend = wordaction.getEnd(retuenword);
            bean1.setEnd(returnwordend);
            bean1.setTop(returnwordtop);
            bean1.setIdiom(retuenword);
            beanList.add(bean1);
            HttpSession session = request.getSession();
            session.setAttribute("drogenlist",beanList);
            session.setAttribute("returnword",retuenword);
            response.sendRedirect(request.getContextPath()+"/drogen.jsp");
        }else {
            response.sendRedirect(request.getContextPath()+"/notidiom.jsp");
        }
    }
}
