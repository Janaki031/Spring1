package com.myapp.first;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.first.model.Alien;

@Controller
public class HomeController 
{
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","Aliens");
	}
	@RequestMapping("/")
	public String home() 
	{
		System.out.println("Home page requested");
		return "index";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int a,@RequestParam("num2") int b,Model m) 
	{
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
		int num3 = a+b;
		m.addAttribute("num3", num3);
		return "result";
	}
	
	@RequestMapping(value="addAlien",method = RequestMethod.POST)
	public String addAlien(@ModelAttribute Alien a)
	{
//		Alien a = new Alien();
//		a.setAid(101);
//		a.setAname("Janaki");
	//	m.addAttribute("alien",a);
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m)
	{
		List<Alien> aliens = Arrays.asList(new Alien(101,"Janaki"));
		m.addAttribute("result",aliens);
		return "showAliens";
	}
}
