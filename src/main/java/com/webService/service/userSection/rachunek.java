package com.webService.service.userSection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "rachunek")
public class rachunek {
 @Id
 private int id;
 private int numerRachunku;
 private String id_prod;
 private int ilosc;
 
  public int getId() {
    return id;
  }
  public String getProdId() {
	  return id_prod;
  }
  public int getQuantity() {
	  return ilosc;
  }
  public void setQuantity(int ilosc) {
	  this.ilosc=ilosc;
  }
  public void setProdId(String plu) {
	  this.id_prod = plu;
  }
public int getNumerRachunku() {
	return numerRachunku;
}
public void setNumerRachunku(int numerRachunku) {
	this.numerRachunku = numerRachunku;
}
}