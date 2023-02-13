package kr.co.kreamv.proddetail.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.proddetail.service.IProdDetailService;
import kr.co.kreamv.proddetail.service.ProdDetailServiceImpl;
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/getProdDetail.do")
public class GetProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		IProdDetailService service = ProdDetailServiceImpl.getInstance();
		ProdDetailVO prodDetailVo = service.GetProdDetail(request.getParameter("detail_id"));
		
		IprodService service2 = ProdServiceImpl.getInstance();
		ProdVO prodVo = service2.getProd(prodDetailVo.getProd_id());
		
		request.setAttribute("type", type);
		request.setAttribute("prodDetailVo", prodDetailVo);
		request.setAttribute("prodVo", prodVo);
		
		if(type>1) {
			request.setAttribute("confirm_id", request.getParameter("confirm_id"));
		}
		
		request.getRequestDispatcher("view/check.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
