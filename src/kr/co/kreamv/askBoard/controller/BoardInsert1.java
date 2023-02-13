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


@WebServlet("/BoardInsert1.do")
public class BoardInsert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트 전송시 값을 받는다(dnm, title, cont)
		//- vo에 설정 - (dnm, title, cont)
		String mem_id = request.getParameter("mem_id");
		String board_title = request.getParameter("board_title");
		String board_cont = request.getParameter("board_cont");
		
		BoardVO vo = new BoardVO();
		vo.setMem_id(mem_id);
		vo.setBoard_title(board_title);
		vo.setBoard_cont(board_cont);
	
		IaskBoardService service = AskBoardServiceImpl.getInstance();
		
		int res = service.BoardInsert1(vo);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("{ \"flag\" : \"OK\" }" );
		
	}

}
