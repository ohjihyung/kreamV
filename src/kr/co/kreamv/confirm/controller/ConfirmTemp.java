package kr.co.kreamv.confirm.controller;

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


@WebServlet("/confirmTemp.do")
public class ConfirmTemp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IprodService serviceP = ProdServiceImpl.getInstance();
		ProdVO prodVo = serviceP.getProd(request.getParameter("prod_id"));
		
		IProdDetailService servicePD = ProdDetailServiceImpl.getInstance();
		ProdDetailVO prodDetailVo = servicePD.GetProdDetail(request.getParameter("datail_id"));
		
		HttpSession session = request.getSession();
		IsampleMemberService serviceM = SampleMemberServiceImpl.getInstance();
		SampleMemberVO memberVo = serviceM.getprofile((String)session.getAttribute("loginId"));
		request.setAttribute("memberVo", memberVo);
		
		request.setAttribute("prodVo", prodVo);
		request.setAttribute("prodDetailVo", prodDetailVo);
		request.setAttribute("qty", request.getParameter("qty"));
		request.setAttribute("price", request.getParameter("price"));
	
		request.getRequestDispatcher("view/confirm2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
