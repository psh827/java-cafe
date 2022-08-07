package com.varxyz.javacafe.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	@GetMapping("/test/login")
	public String loginForm() {
		return "test/login";
	}
	
	@PostMapping("/test/login")
	public String login(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		/**
		 * id : admin
		 * passwd : qwer123!
		 * User user = new User(id, passwd)
		 */
//		AdminDao.isUser(id, passwd);
//		AdminDao.isUser(user);
		/**
		 * setAttribute란 jsp 변수를 사용할 수 있게 던져준다.
		 * 이 컨트롤러에서 setAttribute한 값은 return을 한 페이지에 사용을 할 수 있게 해준다.
		 * 이 값은 그 페이지에서만 사용이 가능하다. 
		 * login (nickname, userName) -> login_success -> main (request값이 사라진다.) (session) ->myPage->
		 * -> test -> logout or 인터넷창을 끔 (내가 설정을 해야된다)// 
		 * session은 내가 지정한 곳이아니면 사라지지 않는다.
		 * 
		 */
		if(id.equals("admin") && passwd.equals("qwer123!")) {
			session.setAttribute("userName", "짱구");
			return "test/login_success";	
		}
		
		return "test/login";
		
	}
	
	@GetMapping("/test/main")
	public String main(HttpSession session, HttpServletRequest request) {
		String userName = (String)session.getAttribute("userName"); //session.getAttribute String형이 아니다. Object
		
		System.out.println("session userName = " + userName);
		
		if(userName.equals(null)) {
			return "test/login";
		}
		
		/**
		 * session은 안넘겨도된다. 왜냐면 session이 끝날때까지 페이지에 계속 남아있기 때문에
		 * Long = Long.parserLong(session.getAttribute("userName"))
		 */
		
		return "test/main";	
	}
	
	@GetMapping("/test/logout")
	public String logout(HttpSession session) {
		/**
		 * session을 없는 두가지 방법.
		 * 
		 */
		//1번째
		session.removeAttribute("userName"); //세션 개별 삭제.
		//2번째
		session.invalidate(); //세션 전체 삭제.
		
		return "test/login";
	}
	
}
