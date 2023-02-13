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
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("memId");
		String board_title = request.getParameter("board_title");
		String board_cont = request.getParameter("board_cont");
		
		BoardVO vo = new BoardVO();
		vo.setMem_id(memId);
		vo.setBoard_title(board_title);
		vo.setBoard_cont(board_cont);
		
				
		IaskBoardService service = AskBoardServiceImpl.getInstance();
		
		int result= service.UpdateQu(vo);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("view/aksBoard1.jsp").forward(request, response);
		
		
				
		
	}

}
