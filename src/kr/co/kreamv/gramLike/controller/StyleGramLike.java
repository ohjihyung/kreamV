package kr.co.kreamv.gramLike.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kreamv.gramLike.service.IStylegramLikeService;
import kr.co.kreamv.gramLike.service.StylegramLikeServiceImpl;
import kr.co.kreamv.vo.LikegramVO;


@WebServlet("/StyleGramLike.do")
public class StyleGramLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String memId = request.getParameter("id"); 
		int gramNum =Integer.parseInt(request.getParameter("num"));
		 
		System.out.println(memId); System.out.println(gramNum);
		
		LikegramVO vo = new LikegramVO();
		vo.setGram_num(gramNum);
		vo.setMem_id(memId);
		
		IStylegramLikeService service = StylegramLikeServiceImpl.getInstance();
		
		int result = service.minuLike(vo);
		
		String likeGramMinusResult = null;
	
		Gson gson = new Gson();
		
		if(result > 0) {
			likeGramMinusResult = gson.toJson("좋아요 감소 성공");
			
			int likeNum = service.getLikeCount(gramNum);
			
			JsonObject job = new JsonObject();
			job.addProperty("likeNum", likeNum);
			
			likeGramMinusResult = gson.toJson(job);

			out.println(likeGramMinusResult);
		}else {
			likeGramMinusResult = "좋아요 감소 실패";
			out.println(likeGramMinusResult);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("서블릿넘어옴");
		
		
		String memId = request.getParameter("id"); 
		int gramNum =Integer.parseInt(request.getParameter("num"));
		 
		System.out.println(memId); System.out.println(gramNum);
		
		LikegramVO vo = new LikegramVO();
		vo.setGram_num(gramNum);
		vo.setMem_id(memId);
		
		IStylegramLikeService service = StylegramLikeServiceImpl.getInstance();
		
		int count = service.likeGram(vo);
		
		String likeGramResult = null;
		
		
		
		Gson gson = new Gson();
		
		if(count > 0) {
			likeGramResult = gson.toJson("좋아요 증가 성공");
			int likeNum = service.getLikeCount(gramNum);
			
				JsonObject job = new JsonObject();
				job.addProperty("likeNum", likeNum);
				
				likeGramResult = gson.toJson(job);
	
				out.println(likeGramResult);
		}else {
			likeGramResult = gson.toJson("좋아요 증가 실패");
			out.println(likeGramResult);
		}
		
		
		
		
	}

}
