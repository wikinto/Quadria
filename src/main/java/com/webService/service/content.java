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
import javax.servlet.*;
import javax.servlet.http.*;

@org.springframework.stereotype.Controller
public class content {
	
	//private user ActiveUser = new user();
	
	private boolean LogError = false;
	private String UID="0";
	private shopentity CurrentProduct = new shopentity();
	private shopentitycontent CurrentProductContent = new shopentitycontent();
	private shopentityinfo CurrentProductInfo = new shopentityinfo();
	
	List<products> rach = new ArrayList<>();

	cashreg Cash;
	products Prods;
	@Autowired
	private productsrepository Products;
	@Autowired
	private cashregrepository Users;

	@Autowired
//	private login loginInterface;
	@RequestMapping("/main")
	public ModelAndView firstPage() {
		return new ModelAndView("main");
	}
	
	@RequestMapping("/cash")
	public ModelAndView cash() {
		if("0".equals(UID))
			return firstPage();
		return new ModelAndView("cash");
	}
	
	
	@RequestMapping("/getProduct")
	public RedirectView getProduct(@RequestParam("barcode") String code) {
		String bcode;
		if(code.length() < 11)
			Prods = Products.getById(code);
		else
		Prods=Products.getByBarcode(code);
		
		rach.add(Prods);
		return new RedirectView("/cash");
		
	}

    @RequestMapping("/login")
    @ResponseBody
    public RedirectView logon(@RequestParam("upass") String pass,@RequestParam("uid") String id) {
    	String password;
    		Cash=Users.getById(Integer.valueOf(id));
    		password=Cash.getPassword();
    		if(password.equals(pass)) {
    			LogError = false;
    			UID=id;
    			return new RedirectView("/cash");
    			
    		}
    		else {
    			LogError = true;

    			return new RedirectView("/main");
    			
    		}

    }
    @ModelAttribute 
    public void setError(Model model) {
    	model.addAttribute("loginerror",LogError);
    	model.addAttribute("uid",UID);
    	model.addAttribute("rach",rach);
    }
    
    @GetMapping(path="/all")
    public @ResponseBody List<cashreg> getAllProducts() {
    	return Users.findAll();
    }
}