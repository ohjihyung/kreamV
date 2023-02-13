package kr.co.kreamv.stylegramReply.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kreamv.stylegramReply.service.IStylegramReplyService;
import kr.co.kreamv.stylegramReply.service.StylegramReplyServiceImpl;


@WebServlet(name = "GramReplyInsert", urlPatterns = { "/GramReplyInsert.do" })
public class gramReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");  //회원id
		int gramNum = Integer.parseInt(request.getParameter("num"));  //게시물번호
		String replyCont = request.getParameter("replyCont");  //댓글
		
		System.out.println(id);
		System.out.println(gramNum);
		System.out.println(replyCont);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", id);
		map.put("gram_num", gramNum);
		map.put("greply_cont", replyCont);
		
		IStylegramReplyService service = StylegramReplyServiceImpl.getInstance();
		
		int result = service.insertBoardReply(map);
		
		System.out.println(result);
		
	}

	


}
