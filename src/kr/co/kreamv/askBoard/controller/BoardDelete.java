package kr.co.kreamv.askBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.askBoard.service.AskBoardServiceImpl;
import kr.co.kreamv.askBoard.service.IaskBoardService;


@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("memId");
		
		IaskBoardService service = AskBoardServiceImpl.getInstance();
		
		int result = service.DeleteDe(memId);
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("view/aksBoard1.jsp").forward(request, response);
		
	}

}
