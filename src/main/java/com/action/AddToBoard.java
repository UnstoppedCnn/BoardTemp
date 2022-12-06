package com.action;

import com.bean.Board;
import com.Dao.BoardDao;
import com.Impl.BoardImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet({"/addtoboard","/deletebyanthorandtitle","/queryall"})
public class AddToBoard extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/addtoboard".equals(servletPath)){
            doaddToBoard(request,response);
        }else if("/deletebyanthorandtitle".equals(servletPath)){
            dodeleteByAnthorAndTitle(request,response);
        }else if("/queryall".equals(servletPath)){
            doqueryAll(request,response);
        }
    }

    private void doqueryAll(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        BoardDao a  = new BoardImpl();
        List<Board> boardList = a.queryAll();
        request.getSession().setAttribute("boards",boardList);
        response.sendRedirect(request.getContextPath()+"/Board.jsp");
    }

    private void dodeleteByAnthorAndTitle(HttpServletRequest request, HttpServletResponse response) {

    }

    private void doaddToBoard(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String anthor = request.getParameter("anthor");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        System.out.println(anthor+title+content);
        List<Board> board = new ArrayList<>();
        Board a = new Board();
        a.setAnthor(anthor);
        a.setTitle(title);
        a.setBoard(content);
        board.add(a);
        System.out.println(board.size()+"uiio");
        BoardDao b = new BoardImpl();
        b.insert(anthor,title,content);
        response.sendRedirect(request.getContextPath()+"/queryall");
    }
}
