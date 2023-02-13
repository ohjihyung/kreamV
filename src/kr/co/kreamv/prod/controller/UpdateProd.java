package kr.co.kreamv.prod.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.co.kreamv.prod.service.IprodService;
import kr.co.kreamv.prod.service.ProdServiceImpl;
import kr.co.kreamv.vo.ProdVO;

@WebServlet("/updateProd.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100
		)
public class UpdateProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//받아온 데이터들을 ProdVO 객체에 담는다 
		ProdVO vo = new ProdVO();
		
		String prodid = request.getParameter("prodid");
		String prodenm = request.getParameter("prodenm");
		String prodknm = request.getParameter("prodknm");
		String prodbrand = request.getParameter("prodbrand");
		String prodrprice = request.getParameter("prodrprice");
		String proddate = request.getParameter("proddate");
		String[] prodgenlist = request.getParameterValues("prodgen");
		String prodgen = prodgenlist[0];
		int prodgenNum = 0;
		if(prodgen.equals("남성")) {
			prodgenNum = 0;
		}else if(prodgen.equals("여성")) {
			prodgenNum = 1;
		}else if(prodgen.equals("공용")) {
			prodgenNum = 2;
		}
		String[] prodCategoryList = request.getParameterValues("prodcategory");
		String prodCategory = prodCategoryList[0];
		vo.setPcategory_id(prodCategory);
		vo.setProd_gen(prodgenNum);
		System.out.println(prodid + prodenm + prodknm + prodbrand);
		System.out.println(prodrprice + proddate);
		vo.setProd_brand(request.getParameter("prodbrand"));
		vo.setProd_id(request.getParameter("prodid"));
		vo.setProd_enm(request.getParameter("prodenm"));
		vo.setProd_knm(request.getParameter("prodknm"));
		vo.setProd_date(request.getParameter("proddate").replaceAll("-", "/"));
		vo.setProd_rprice(Integer.parseInt(request.getParameter("prodrprice")));
		
		// 받아온 파일 업로드
		// form의  file입력 요소의 name을 가져와 part객체 구하기 
	
		// 서버단 업로드할 파일 경로를 지정한다.

		String uploadPath = "D:\\A_TeachingMaterial\\05_JQuery\\workspace\\kreamv\\WebContent\\images";

		
		// 없으면 새로 만듬 
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
		}
		
		String filename  = ""; 

		int count = 1;
		
		for(Part part : request.getParts()) {
			filename = extractFileName(part);
			if(!"".equals(filename)) {
				
				if(count == 1) {
					vo.setProd_origin1(filename);
					count++;
					String fakeName = UUID.randomUUID().toString() + ".png";
					vo.setProd_photo1(fakeName);
					part.write(uploadPath + File.separator + fakeName);
					
				}else {
					vo.setProd_origin2(filename);

					String fakeName = UUID.randomUUID().toString()+ ".png";;

					

					vo.setProd_photo2(fakeName);
					part.write(uploadPath + File.separator + fakeName);
				}		
				
			} // end of if 
		
		} // end of for 

		IprodService service = ProdServiceImpl.getInstance();
	
		int result = service.insertProd(vo);
		
		
		System.out.println(result);
		
		response.setCharacterEncoding("utf-8");
		if(result == 1) {
			String msg = URLEncoder.encode("등록완료", "utf-8");
			response.sendRedirect(request.getContextPath() +"/view/updateProd.jsp?msg=" + msg);
		}
		// 알람을 띄워야되는데 
	
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
