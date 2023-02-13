package kr.co.kreamv.examinationManager.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.examinationManager.service.ExaminationManagerServiceImpl;
import kr.co.kreamv.examinationManager.service.IExaminationManagerService;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SelectConfirmVO;

/**
 * Servlet implementation class ExaminationManager
 */
@WebServlet("/examinationManager.do")
public class ExaminationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IExaminationManagerService service = ExaminationManagerServiceImpl.getinstance();	
		List<SelectConfirmVO> prodList = service.prodList();
		
		System.out.println(prodList);
		
		request.setAttribute("prodList", prodList);
		request.getRequestDispatcher("view/examinationManager.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String confirmId = request.getParameter("confirmId");
		String value = request.getParameter("value");
		
//		System.out.println(confirmId);
//		System.out.println(value);
		
		IExaminationManagerService service = ExaminationManagerServiceImpl.getinstance();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("confirmId", Integer.parseInt(confirmId));
		
		Gson gson = new Gson();
		
		String res = null;
		
		if(value.equals("sendback")) {
			int snedBackResult = service.prodSendBack(map);
			if(snedBackResult > 0) {
				res = gson.toJson("반송되었습니다");
				service.confirmUpdate(map);
				out.println(res);
				response.flushBuffer();
			}else {
				res = gson.toJson("반송이 실패하였습니다");
				out.println(res);
				response.flushBuffer();
			}
		}else if(value.equals("store")){
			int storeResult = service.prodStore(map);
			if(storeResult > 0) {
				res = gson.toJson("보관되었습니다");
				service.confirmUpdate(map);
				out.println(res);
				response.flushBuffer();
			}else {
				res = gson.toJson("보관이 실패 되었습니다");
				out.println(res);
				response.flushBuffer();
			}
		}
		
	}
	

}
