package kr.co.kreamv.gramLike.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.gramLike.service.IStylegramLikeService;
import kr.co.kreamv.gramLike.service.StylegramLikeServiceImpl;
import kr.co.kreamv.vo.LikegramVO;

/**
 * Servlet implementation class Style
 */
@WebServlet(name = "StyleLikeList", urlPatterns = { "/StyleLikeList.do" })
public class StyleLikeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		System.out.println("서블릿 넘어옴");
		
		String memId = request.getParameter("id");
		System.out.println(memId);
		IStylegramLikeService service = StylegramLikeServiceImpl.getInstance();
		
		
		
		List<LikegramVO> list = service.likeGramList(memId);
		
		for(LikegramVO vo : list) {
			System.out.println(vo.getGram_num());
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
