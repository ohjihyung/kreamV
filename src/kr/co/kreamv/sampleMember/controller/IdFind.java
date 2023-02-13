package kr.co.kreamv.sampleMember.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kreamv.sampleMember.service.IsampleMemberService;
import kr.co.kreamv.sampleMember.service.SampleMemberServiceImpl;


@WebServlet("/idFind.do")
public class IdFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		
		Map<String, String> nameHp = new HashMap<String, String>();
		
		nameHp.put("name", name);
		nameHp.put("hp", hp);
		
		IsampleMemberService service = SampleMemberServiceImpl.getInstance();
		
		Object mail = service.idFind(nameHp);
		
		Gson gson = new Gson();
		
		String stringResult = null;
		
		if(mail == null) {
			stringResult = gson.toJson("정보가 일치하지 않습니다");
			out.println(stringResult);
			response.flushBuffer();
		}else{
			String id = service.sendMailId((String)mail);
			
			String mailResult = (String)mail;
			
//			System.out.println(mailResult);
//			
//			System.out.println(id);
			
			 String host = "smtp.naver.com"; 
		        String user = "dlstmdwn@naver.com";// 네이버일 경우 네이버 계정, gmail경우 gmail 계정 
		        String password = "isj1473510";   // 패스워드    

		        // SMTP 서버 정보를 설정한다.
		        Properties props = new Properties();
		        props.put("mail.smtp.host", host);
		        props.put("mail.smtp.port", 587);
		        props.put("mail.smtp.auth", "true");
		        
		        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(user, password);
		            }
		        });

		        try {
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(user));
		            
		            // 수신자 매일 주소(태스트를 위해 수신자 매일주소 하드코딩함)
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress("ho2755@naver.com"));// mailResult

		            // 메일 제목
		            message.setSubject("kreamv id");

		            // 메일 내용
		            message.setText(id);

		            // send the message
		            Transport.send(message);
//		            System.out.println("Success Message Send");

		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
			
		        stringResult = gson.toJson("해당 이매일로 아이디가 발송되었습니다");
		        out.println(stringResult);
				response.flushBuffer();
		}
		
//		
//		if(mail != null) {
//			stringResult = gson.toJson("유효데이터");
//		}else {
//			stringResult = gson.toJson("무효데이터");
//		}
//		
//		out.println(stringResult);
//		
//		response.flushBuffer();
		
	}

}
