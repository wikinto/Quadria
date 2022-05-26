package com.webService.service.userSection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "products")
public class products {
 @Id
 @Column(name = "plu")
 private int plu;
 @Column(name = "barcode", nullable = false)
 private String barcode;
 @Column(name = "name") 
 private String title;
 @Column(name = "price") 
 private float price;
 
  public int getId() {
    return plu;
  }
  
  public float getPrice() {
	    return price;
  }
  
  public void setId(int plu) {
	    this.plu=plu;
  }

  public void setBarcode(String barcode) {
	  this.barcode=barcode;
  }
public String getName() {
	return title;
}

public void setName(String title) {
	this.title = title;
}
public String toString(int ilosc)
{
	return "<div class=\"rach\">"+title+" - "+price+" * "+ ilosc +"</div>";
}
}