package kr.co.kreamv.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;

/**
 * Servlet implementation class MyimageDelete
 */
@WebServlet("/MyimageDelete.do")
public class MyimageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//회원 id 가져오고 
		String uid = request.getParameter("uid");
		
		// 기본 image 사진 
		String defaultImage = "기본프로필이미지.JPG";
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String result = "";
		IsampleMemberService service = SampleMemberServiceImpl.getInstance();
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("uid", uid);
		map.put("defaultImage", defaultImage);
		
		int res = service.deleteProfileImage(map);
		
		System.out.println(res);
		if(res > 0 ) {
			result = gson.toJson("success");
			out.print(result);
		}else {
			result = gson.toJson("fail");
			out.print(result);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
