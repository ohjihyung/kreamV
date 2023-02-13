package kr.co.kreamv.stylegram.cotroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.stylegram.service.IStylegramService;
import kr.co.kreamv.stylegram.service.StyleGramServiceImpl;
import kr.co.kreamv.vo.StyleProdVO;


@WebServlet("/StyleGramHitList.do")	// 인기 게시글
public class StyleGramHitList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IStylegramService service = StyleGramServiceImpl.getInstance();
		
		List<StyleProdVO> list = service.stylegramHitList();
		
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
