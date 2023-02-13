package kr.co.kreamv.askBoard.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.askBoard.service.AskBoardServiceImpl;
import kr.co.kreamv.askBoard.service.IaskBoardService;
import kr.co.kreamv.vo.BoardVO;

/**
 * Servlet implementation class ListDe
 */
@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String boardDnm = request.getParameter("boardDnm");
		
		IaskBoardService service = AskBoardServiceImpl.getInstance();
		
		List<BoardVO> list = service.BoardList(boardDnm);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		
		String result = gson.toJson(list);
		
		out.print(result);
		
		
		
	}

}
