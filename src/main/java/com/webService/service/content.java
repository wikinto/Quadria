package com.webService.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import com.webService.service.userInterfaceSection.login;
import com.webService.service.userSection.*;
import com.webService.service.shopSection.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

@org.springframework.stereotype.Controller
public class content {
	
	//private user ActiveUser = new user();
	
	private Map<String,List<object>> rachunek = new HashMap<>();

	float totalprice;
	cashreg Cash;
	products Prods;
	@Autowired
	private productsrepository Products;
	@Autowired
	private cashregrepository Users;

	@RequestMapping("/main")
	public ModelAndView firstPage(HttpServletRequest request) {
		return new ModelAndView("main");
	}
	
	@RequestMapping("/cash")
	public ModelAndView cash(HttpServletRequest request) {
		if("0".equals(request.getSession().getAttribute("uid")))
			return firstPage(request);
		return new ModelAndView("cash");
	}
	
	
	@RequestMapping("/getProduct")
	public RedirectView getProduct(@RequestParam("barcode") String code,HttpServletRequest request) {
		String bcode;
		boolean Added=false;
		object pom=new object();
		if(code.length() < 11)
			Prods = Products.getById(code);
		else
		Prods=Products.getByBarcode(code);
		pom.rach = Prods;
		pom.ilosc+=1;
		for(int i=0;i<rachunek.get(request.getSession().getAttribute("uid").toString()).size();i++)
		if(rachunek.get(request.getSession().getAttribute("uid").toString()).get(i).eqmet(pom))
		{
			rachunek.get(request.getSession().getAttribute("uid").toString()).get(i).ilosc+=1;
			request.getSession().setAttribute("total", (Float.valueOf(request.getSession().getAttribute("total").toString())+Products.getByBarcode(code).getPrice()));
			//totalprice += Products.getByBarcode(code).getPrice();
			Added=true;
		}
		if(Added==false) {
			request.getSession().setAttribute("total", (Float.valueOf(request.getSession().getAttribute("total").toString())+Products.getByBarcode(code).getPrice()));
			rachunek.get(request.getSession().getAttribute("uid").toString()).add(pom);
			//totalprice += Products.getByBarcode(code).getPrice();
		}
		request.getSession().setAttribute("rach", rachunek.get(request.getSession().getAttribute("uid").toString()));
		return new RedirectView("/cash");
		
	}
	@GetMapping("/paragon")
	@ResponseBody
	public String paragon(HttpServletRequest request) {
		String pom = "";
		if(rachunek.get(request.getSession().getAttribute("uid").toString()).size()>0)
		{
			for(int i=0;i<rachunek.size();i++)
				pom+=rachunek.get(request.getSession().getAttribute("uid").toString()).get(i).toString();
			return pom;
		}
		return "Pusty";
	}

    @RequestMapping("/login")
    @ResponseBody
    public RedirectView logon(@RequestParam("upass") String pass,@RequestParam("uid") String id,HttpServletRequest request) {
    	String password;
    		Cash=Users.getById(Integer.valueOf(id));
    		List<object> obj = new ArrayList<>();
    		password=Cash.getPassword();
    		if(password.equals(pass)) {
    			request.getSession().setAttribute("loginerror", false);
    			request.getSession().setAttribute("uid", Cash.getId());
    			rachunek.put(String.valueOf(Cash.getId()), obj);
    			request.getSession().setAttribute("total", 0);
    			return new RedirectView("/cash");
    			
    		}
    		else {
    			request.getSession().setAttribute("loginerror", true);
    			request.getSession().setAttribute("uid","0");
    			return new RedirectView("/main");
    			
    		}

    }
    @ModelAttribute 
    public void setError(Model model) {
    	//model.addAttribute("rach",rachunek);
    	//model.addAttribute("total",totalprice);
    }
    
    @GetMapping(path="/all")
    public @ResponseBody List<cashreg> getAllProducts() {
    	return Users.findAll();
    }
}