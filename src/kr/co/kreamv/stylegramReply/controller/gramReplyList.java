package kr.co.kreamv.stylegramReply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.stylegram.service.IStylegramService;
import kr.co.kreamv.stylegram.service.StyleGramServiceImpl;
import kr.co.kreamv.stylegramReply.service.IStylegramReplyService;
import kr.co.kreamv.stylegramReply.service.StylegramReplyServiceImpl;
import kr.co.kreamv.vo.StylegramReplyVO;


@WebServlet("/GramReplyList.do")
public class gramReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int gramNum = Integer.parseInt(request.getParameter("gramNum"));
		System.out.println(gramNum);
		
		IStylegramReplyService service = StylegramReplyServiceImpl.getInstance();
		
		List<StylegramReplyVO> list = service.gramReplyList(gramNum);
		
		for(StylegramReplyVO vo : list) {
			System.out.println(vo.getGram_num());
			System.out.println(vo.getGreply_num());
			System.out.println(vo.getGreply_cont());
			System.out.println(vo.getMem_id());
		}
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		
		System.out.println(jsonList);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonList);
		
		response.flushBuffer();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
