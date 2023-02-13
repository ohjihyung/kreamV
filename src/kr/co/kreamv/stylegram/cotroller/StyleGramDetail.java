package kr.co.kreamv.stylegram.cotroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;
import kr.co.kreamv.stylegram.service.IStylegramService;
import kr.co.kreamv.stylegram.service.StyleGramServiceImpl;
import kr.co.kreamv.vo.SampleMemberVO;
import kr.co.kreamv.vo.StyleProdVO;


@WebServlet("/StyleGramDetail.do")
public class StyleGramDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int gramNum = Integer.parseInt(request.getParameter("num"));
		System.out.println(gramNum);

		IStylegramService service = StyleGramServiceImpl.getInstance();
		
		List<StyleProdVO> list = service.stylegramDetail(gramNum);
		
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		String mem_id = (String)session.getAttribute("loginId");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mem_id", mem_id);
		map.put("gram_num", gramNum);
		int checkLike = service.checkLikeGram(map);
		request.setAttribute("checkLike", checkLike);
		
		IsampleMemberService serviceSM = SampleMemberServiceImpl.getInstance();
		SampleMemberVO memberVo =  serviceSM.getprofile(mem_id);
		request.setAttribute("memberVo", memberVo);
		
		request.getRequestDispatcher("/view/styleGramDetail.jsp").forward(request, response);
		
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
