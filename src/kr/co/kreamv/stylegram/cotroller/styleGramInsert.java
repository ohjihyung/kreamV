package kr.co.kreamv.stylegram.cotroller;

import java.io.File;
import java.io.IOException;
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

import kr.co.kreamv.stylegram.service.IStylegramService;
import kr.co.kreamv.stylegram.service.StyleGramServiceImpl;
import kr.co.kreamv.vo.ProdVO;
import kr.co.kreamv.vo.StylegramVO;


@WebServlet(name = "StyleGramInsert", urlPatterns = { "/StyleGramInsert.do" })
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100
		)
public class styleGramInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송된 값을 받는다.
		String prodId = request.getParameter("prod_id");
		String styleProd = request.getParameter("styleProd");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String photo = request.getParameter("photo");
		
		//확인
		System.out.println("prod_id : " + prodId);
		System.out.println("style_prod : " + styleProd);
		System.out.println("writer : " + writer);
		System.out.println("content : " + content);
		
		ProdVO prodVO = new ProdVO();
		StylegramVO styleVO = new StylegramVO();
		
		
		//----------사진
		// 서버단 업로드할 파일 경로를 지정한다.
		//String uploadPath = "D:\\A_TeachingMaterial\\05_JQuery\\kreamv\\WebContent\\images\\style";
		String uploadPath = "C:\\Users\\ho275\\OneDrive\\코딩공부\\jQuery\\kreamv\\WebContent\\images\\style";
		
		// 없으면 새로 만듬 
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
		}
		String filename  = ""; 
		
		int count = 1;
		Map<String, String> map = new HashMap<String, String>();
		
		for(Part part : request.getParts()) {
			filename = extractFileName(part);
			if(!"".equals(filename)) {
				
				if(count == 1) {
					count++;
					String fakeName = UUID.randomUUID().toString();
					map.put("gram_photo", fakeName);
					part.write(uploadPath + File.separator + fakeName);
					System.out.println("업로드파일 fakeName : " + fakeName);
					System.out.println("업로드파일 fileName : " +filename);
				}else {
					String fakeName = UUID.randomUUID().toString();
					map.put("gram_photo", fakeName);
					part.write(uploadPath + File.separator + fakeName);
				}		
				
			} // end of if 
			
		} // end of for 
		//----------사진
		
		styleVO.setMem_id(writer);
		styleVO.setGram_cont(content);
		prodVO.setProd_id(prodId);
		
		
		map.put("mem_id", writer);
		map.put("gram_cont", content);
		map.put("prod_id", prodId);

		IStylegramService service = StyleGramServiceImpl.getInstance();
		
		int result = service.stylegramInsert(map);
		
		System.out.println(result);
		
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
