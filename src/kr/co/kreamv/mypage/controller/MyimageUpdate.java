package kr.co.kreamv.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;
import kr.co.kreamv.vo.SampleMemberVO;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100
		)
@WebServlet("/MyimageUpdate.do")
public class MyimageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("uid");
		
		
		
		System.out.println("컨트롤러로 받은 아이디" + id);

		//String uploadPath = "D:\\A_TeachingMaterial\\05_JQuery\\kreamv\\WebContent\\image\\profile";

		//String uploadPath = "C:\\Users\\ho275\\OneDrive\\코딩공부\\jQuery\\kreamv\\WebContent\\images\\profile";  //중호
		// String uploadPath = "\\192.168.144.27\\공유폴더\\중프관련자료\\최종발표자료_404\\4조_KreamV";  공유폴더
		String uploadPath = "D:\\A_TeachingMaterial\\05_JQuery\\kreamv\\WebContent\\images\\profile";	// 수정
		
		
		
		// 없으면 새로 만듬 
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
		}
		
		String filename  = ""; 
		
		SampleMemberVO vo = new SampleMemberVO();
		
		IsampleMemberService service = SampleMemberServiceImpl.getInstance();
		
		Part part = request.getPart("updateImg");
//				System.out.println(part);
		filename = extractFileName(part);
		
		int result = 0;
		
		String updateUmgResult = null;
		
		Gson gson = new Gson();
		
		if(!"".equals(filename)) {
			String fakeName = UUID.randomUUID().toString();
			vo.setMem_photo(fakeName);
			vo.setMem_id(id);
			
			result = service.updateImg(vo);
			
			part.write(uploadPath + File.separator + fakeName);
			
			if(result > 0) {
				updateUmgResult = gson.toJson("imgUpdateSuccess");
				out.println(updateUmgResult);
			}else {
				updateUmgResult = gson.toJson("imgUpdateError");
				out.println(updateUmgResult);
			}
			
		} // end of if 
		
	}
	private String extractFileName(Part part) {
		String fileName = ""; 
		String contentDisposition = part.getHeader("Content-Disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return fileName;
	}
}
