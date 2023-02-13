package kr.co.kreamv.confirm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.buyBid.service.BuyBidServiceImpl;
import kr.co.kreamv.buyBid.service.IBuyBidService;
import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.proddetail.service.IProdDetailService;
import kr.co.kreamv.proddetail.service.ProdDetailServiceImpl;
import kr.co.kreamv.vo.BuyBidVO;
import kr.co.kreamv.vo.ProdDetailVO;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/confirmInfo.do")
public class ConfirmInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IProdDetailService servicePD = ProdDetailServiceImpl.getInstance();
		ProdDetailVO prodDetailVo = servicePD.GetProdDetail(request.getParameter("detail_id"));
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		ProdVO prodVo = serviceP.getProd(prodDetailVo.getProd_id());
		
		request.setAttribute("prodDetailVo", prodDetailVo);
		request.setAttribute("prodVo", prodVo);
		
		request.getRequestDispatcher("view/confirm1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
