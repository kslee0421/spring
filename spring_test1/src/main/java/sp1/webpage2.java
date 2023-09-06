package sp1;

import java.io.PrintWriter;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webpage2 {
	PrintWriter pw = null;
	//spring1.html에 넘어온 값을 view를 통해서 핸들링함
	@PostMapping("/spring1ok.do")
	public String product(HttpServletRequest req , HttpServletResponse res, Model m) {
		String pdcode = "";
		String pdname = "";
		try {
			pdcode = req.getParameter("pdcode").intern();
			pdname = req.getParameter("pdname").intern();
			m.addAttribute("code",pdcode);
			m.addAttribute("name",pdname);
		}
		catch(Exception e) {
			System.out.println("파라미터 오류 발생!!");
		}
		return "/WEB-INF/jsp/spring1ok";
	}
	
	//라디오 사용시 intern사용하여 조건완성
	@PostMapping("/spring2ok.do")
	public String agree(HttpServletRequest req, Model m)  {
		//checkbox 사용시 intern() 사용하지 않음
		String ag = req.getParameter("mail").intern();;
		String ad = req.getParameter("ad").intern();

		if(ad=="N") {
			ag = "N";
		}
		else { 
			ad = req.getParameter("ad").intern();	
		}


		if(ag==null) {
			ag = "N";
			System.out.println("동의안함");
		}
		else {
			System.out.println("동의함");
		}
			return null;
		}
	//getter와 setter를 이용해서 값을 받음
	@PostMapping("/spring3ok.do")
	public String user(HttpServletRequest req, Model m)  {
		String mid = req.getParameter("mid");
		String mname = req.getParameter("name");
		
		userdata ud =new userdata(mid,mname);
		
		System.out.println(ud.getMid());
		System.out.println(ud.getMname());
	
	}
}







