package kr.co.kreamv.askBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardMyList.do")
public class BoardMyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 내가 질문한 글 목록 보기
	    request.setCharacterEncoding("utf-8");
	    
	    // 로그인여부 확인
	    
	    
	    
	    
	}

}
