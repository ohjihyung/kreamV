package kr.co.kreamv.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.board.service.BoardServiceImpl;
import kr.co.kreamv.board.service.IBoardService;
import kr.co.kreamv.vo.BoardVO;

@WebServlet("/NoticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int se = Integer.parseInt(request.getParameter("se"));
		System.out.println(se);
		
		IBoardService service = BoardServiceImpl.getInstance(); 
		
		List<BoardVO> BoardList = null;
		
		if(se == 1) {
			BoardList = service.noticeList();
			for(BoardVO vo : BoardList) {
				System.out.println(vo.getBoard_dnm());
			}
			request.setAttribute("BoardList", BoardList);
			request.getRequestDispatcher("/view/adminBoard.jsp").forward(request, response);
			return;
		}
		
		if(se == 2) {
			BoardList = service.qnaList();
			for(BoardVO vo : BoardList) {
				System.out.println(vo.getBoard_dnm());
			}
			request.setAttribute("BoardList", BoardList);
			request.getRequestDispatcher("/view/adminBoard.jsp").forward(request, response);
			return;
		}
		
		if(se == 3){
			BoardList = service.standardList();
			for(BoardVO vo : BoardList) {
				System.out.println(vo.getBoard_dnm());
			}
			request.setAttribute("BoardList", BoardList);
			request.getRequestDispatcher("/view/adminBoard.jsp").forward(request, response);
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
