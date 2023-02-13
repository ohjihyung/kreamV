package kr.co.kreamv.confirm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.confirm.service.ConfirmServiceImpl;
import kr.co.kreamv.confirm.service.IconfirmService;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.vo.ConfirmVO;

@WebServlet("/insertConfirm.do")
public class InsertConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ConfirmVO confirmVo = new ConfirmVO();
		
		confirmVo.setMem_id(request.getParameter("mem_id"));
		confirmVo.setDetail_id(request.getParameter("detail_id"));
		
		IconfirmService service = ConfirmServiceImpl.getInstance();
		
		for(int i =0; i<Integer.parseInt(request.getParameter("qty")); i++) {
			service.insertConfirm(confirmVo);
		}
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		request.setAttribute("prodVo", serviceP.getProd(request.getParameter("prod_id")));
		
		request.setAttribute("completeType", 1);	// 검수 완료 타입
		
		request.getRequestDispatcher("view/completeBid.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
