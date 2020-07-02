package com.abhi;


import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.lang.String;
@Controller
public class mainController {
	int flag = 0;
		
	void theme(String img,String color,String accent,String fieldColor,Model m) {
		m.addAttribute("image",img);
		m.addAttribute("color",color);
		m.addAttribute("accent",accent);
		m.addAttribute("fieldColor",fieldColor);
	}
	
	
    @RequestMapping("/")
		public ModelAndView main(Model m) throws InterruptedException, IOException{
			ModelAndView mv = new ModelAndView("index.jsp");
			theme("sky.jpg","dark-grey","dark","rgba(0, 0, 0, 0.10)",m);
			
			return mv;
		}
    
    @RequestMapping("theme")
    	public ModelAndView theme(Model m) {
    	ModelAndView mv = new ModelAndView("index.jsp");
    
    	if(flag==0) {
    		theme("sun.jpg","white","light","rgba(255, 255, 255, 0.10)",m);
    		flag=1;
    	}
    	
    	else{
    		theme("sky.jpg","dark-grey","dark","rgba(0, 0, 0, 0.10)",m);
    		flag =0;
    	}
    	return mv;
    }
	}
	
	













