package kr.co.kreamv.stylegram.cotroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.gramLike.service.IStylegramLikeService;
import kr.co.kreamv.gramLike.service.StylegramLikeServiceImpl;
import kr.co.kreamv.stylegram.service.IStylegramService;
import kr.co.kreamv.stylegram.service.StyleGramServiceImpl;
import kr.co.kreamv.vo.LikegramVO;
import kr.co.kreamv.vo.StyleProdVO;


@WebServlet("/styleGramList.do")
public class StyleGramList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("loginId");
		
		int type = Integer.parseInt(request.getParameter("type"));	// 1 : 인기순위 출력, 2 : 최신순위 출력
		request.setAttribute("type", type);
		
		IStylegramService serviceSG = StyleGramServiceImpl.getInstance();
		List<StyleProdVO> styleList = new ArrayList<StyleProdVO>();

		if(type==1) {	// 인기 순위 출력
			styleList = serviceSG.stylegramHitList();
		}else if(type==2){			// 최신 순위 출력
			styleList = serviceSG.stylegramNewList();
		}else {
			styleList = serviceSG.stylegramLikeList(mem_id);
		}
		request.setAttribute("styleList", styleList);	// 스타일그램 리스트 보내기
			
		if(mem_id!=null) {
			IStylegramLikeService serviceGL = StylegramLikeServiceImpl.getInstance();
			List<LikegramVO> likeGramList = new ArrayList<LikegramVO>();
			likeGramList = serviceGL.likeGramList(mem_id);
			request.setAttribute("likeGramList", likeGramList);	// 로그인 했을 경우 내가 좋아요 한 목록 보내기
		}
		
		
		request.getRequestDispatcher("view/styleGram.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
