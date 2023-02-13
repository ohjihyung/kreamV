package kr.co.kreamv.stylegram.cotroller;

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
import kr.co.kreamv.vo.ProdVO;


@WebServlet("/StyleGramRegistration.do")	// 작성할 때
public class styleGramRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		System.out.println(id);
		
		IStylegramService service = StyleGramServiceImpl.getInstance();
		
		//배송정보 확인(구매한 상품 리스트)
		List<ProdVO> list = service.stylegramProd(id);
		
		for(ProdVO vo : list) {
			System.out.println(vo.getProd_id());
			System.out.println(vo.getProd_knm());
		}
		
		Gson gson = new Gson();
		String jsonList = gson.toJson(list);
		
		System.out.println(jsonList);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonList);
		
		response.flushBuffer();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
