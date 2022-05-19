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
 @Column(name = "barcode")
 @GeneratedValue(strategy=GenerationType.AUTO)
public String barcode;
 @Column(name = "name") 
  public String title;
 @Column(name = "price") 
 public float price;
 
  public String getId() {
    return barcode;
  }
  
  public float getPrice() {
	    return price;
	  }
  
  public void setId(String barcode) {
	    this.barcode=barcode;
	  }


public String getName() {
	return title;
}

public void setName(String title) {
	this.title = title;
}
}