package kr.co.kreamv.orders.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.proddetail.service.IProdDetailService;
import kr.co.kreamv.proddetail.service.ProdDetailServiceImpl;
import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.SampleMemberVO;

@WebServlet("/sellOrdersTemp.do")
public class SellOrdersTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		ProdVO prodVo = serviceP.getProd(request.getParameter("prod_id"));
		
		IProdDetailService servicePD = ProdDetailServiceImpl.getInstance();
		ProdDetailVO prodDetailVo = servicePD.GetProdDetail(request.getParameter("datail_id"));
		
		request.setAttribute("storeType", request.getParameter("storeType"));
		request.setAttribute("sellType", 1);
		request.setAttribute("confirm_id", request.getParameter("confirm_id"));
		request.setAttribute("prodVo", prodVo);
		request.setAttribute("prodDetailVo", prodDetailVo);
		request.setAttribute("buy_bid_id", request.getParameter("buy_bid_id"));
		request.setAttribute("buy_bid_price", Integer.parseInt(request.getParameter("buy_bid_price")));
	
		request.getRequestDispatcher("view/sell2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
