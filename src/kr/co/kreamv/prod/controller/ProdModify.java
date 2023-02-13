package kr.co.kreamv.prod.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;

/**
 * Servlet implementation class ProdModify
 */
@WebServlet("/ProdModify.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100
		)
public class ProdModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String prodDleteId = request.getParameter("prodDleteId");
		
		IprodService service = ProdServiceImpl.getInstance();
		
		int result = service.prodDelete(prodDleteId);
		
		Gson gson = new Gson();
		
		String deleteResult = null;
		
		if(result > 0) {
			deleteResult = gson.toJson("삭제 되었습니다");
			out.println(deleteResult);
		}else {
			deleteResult = gson.toJson("삭제를 실패했습니다");
			out.println(deleteResult);
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String newNum = request.getParameter("newNum");
		String newEnm = request.getParameter("newEnm");
		String newKnm = request.getParameter("newKnm");
//		String newUploadFile= request.getParameter("newUploadFile");

//		System.out.println(newNum);
//		System.out.println(newEnm);
//		System.out.println(newKnm);
		
		
		
//		System.out.println(newUploadFile);

		// 서버단 업로드할 파일 경로를 지정한다.

		String uploadPath = "D:\\A_TeachingMaterial\\05_JQuery\\workspace\\kreamv\\WebContent\\images";

		int result = 0;
		
		// 없으면 새로 만듬 
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
		}
		
		String filename  = ""; 

		String fakeName = "";
		
		Part part = request.getPart("newImage");
		
//		System.out.println(part);
		
			filename = extractFileName(part);
//			System.out.println(filename);
			if(!"".equals(filename)) {
				
//			System.out.println(filename);

			fakeName = UUID.randomUUID().toString();
			
//			System.out.println(fakeName);
			
			part.write(uploadPath + File.separator + fakeName);
			
//			System.out.println(fakeName);
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("newNum", newNum);
			map.put("newEnm", newEnm);
			map.put("newKnm", newKnm);
			map.put("filename", filename);
			map.put("fakeName", fakeName);
			
			IprodService service = ProdServiceImpl.getInstance();
			
			result = service.prodUpdate(map);
			
			String newFileResult = null;
			
			Gson gson = new Gson();
			
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			if(result > 0) {
				newFileResult = gson.toJson("업데이트 완료");
				out.println(newFileResult);
			}else {
				newFileResult = gson.toJson("업데이트 실패");
				out.println(newFileResult);
			}
		}		
				

		
//		System.out.println(img);
//		System.out.println(newKnm);
//		System.out.println(newEnm);
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
