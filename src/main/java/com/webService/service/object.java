package com.webService.service;

import java.util.ArrayList;
import java.util.List;

import com.webService.service.userSection.products;

public class object {
	products rach = null;
	int ilosc=0;
	public String toString() {
		return "<div style=\"display: flex\">"+rach.toString(ilosc)+"</div>";
	}
	public boolean eqmet(object rachp) {
		if(rach.getId()==rachp.rach.getId())
			return true;
		return false;
	}
}
