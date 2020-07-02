package com.abhi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class weatherController {
	//mehod to remove spaces from location string and replace spaces with + symbol.
	public String formatString(String str) 
	{	
			String s = str.trim();
			return s.replace(" ", "+"); 
	}
	//theme method to change color scheme according to day,night and background.
	
	void theme(Model m ,String icon) {
		if(icon.contains("n")) {
			m.addAttribute("color","white");
			m.addAttribute("tableColor","rgba(255, 255, 255, 0.18)");	
			m.addAttribute("captionColor","rgba(255, 255, 255, 0.08)");
		}
		else {
			m.addAttribute("color","black");
			m.addAttribute("tableColor","rgba(0, 0, 0, 0.12)");
			m.addAttribute("captionColor","rgba(0, 0, 0, 0.06)");
		}
	}
	
	@RequestMapping("/weather")
    public ModelAndView  getweather(HttpServletRequest req,HttpServletResponse res,Model m) throws IOException{

      String API_KEY = "API_KEY";
      String LOCATION = formatString(req.getParameter("city"));
      
      String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=metric";
      ModelAndView mv = new ModelAndView("weather.jsp"); 
      
      
      try{
          StringBuilder result = new StringBuilder();
          URL url = new URL(urlString);
          URLConnection conn = url.openConnection();
          BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          String line;
          while ((line = rd.readLine()) != null){
              result.append(line);
          }    
          rd.close();
          JSONObject obj = new JSONObject(result.toString());
      
          String icon = obj.getJSONArray("weather").getJSONObject(0).get("icon").toString();
          String condition = obj.getJSONArray("weather").getJSONObject(0).get("main").toString();
          String temperature = obj.getJSONObject("main").get("temp").toString();
          String feelsLike = obj.getJSONObject("main").get("feels_like").toString();
          String tempMin = obj.getJSONObject("main").get("temp_min").toString();
          String tempMax = obj.getJSONObject("main").get("temp_max").toString();
          String humidity = obj.getJSONObject("main").get("humidity").toString();
         
          String windSpeed = obj.getJSONObject("wind").get("speed").toString();
          String windAngle = obj.getJSONObject("wind").get("deg").toString();
          String country = obj.getJSONObject("sys").get("country").toString();
          String city = obj.get("name").toString();
          
          
          int Temperature =  Math.round(Float.parseFloat(temperature));
          
          
          m.addAttribute("temperature",Temperature + " C");
          m.addAttribute("humidity", humidity + "%");
          m.addAttribute("wind_speed", windSpeed + " kmph");
          m.addAttribute("wind_angle", windAngle + " deg");
          m.addAttribute("feels", feelsLike + " C");
          m.addAttribute("min", tempMin + " C");
          m.addAttribute("max", tempMax + " C");
          m.addAttribute("icon", icon);
          m.addAttribute("location",country + ", "+ city);
          m.addAttribute("iconUrl","http://openweathermap.org/img/wn/" + icon +"@2x.png"); 
          m.addAttribute("condition", condition);
          
          
          System.out.println("Data Fetched");
          theme(m,icon);
      }
      catch (IOException e){
          System.out.println(e.getMessage());
      }
      catch (JSONException jsonEX) {
    	  res.getWriter().println(jsonEX.getMessage());
    	  m.addAttribute("msg", "city not found");
    	  return mv;
      }
	return mv;
}
}
