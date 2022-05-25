package com.webService.service;

import java.util.ArrayList;
import java.util.List;

import com.webService.service.userSection.products;

public class object {
	products rach = null;
	int ilosc=0;
	public String toString() {
		return "<p>"+ilosc+"</p>"+rach.toString();
	}
	public boolean eqmet(object rachp) {
		if(rach.getId()==rachp.rach.getId())
			return true;
		return false;
	}
}
