package com.webService.service.userSection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "cashreg")
public class cashreg {
 @Id
 @Column(name = "uid")
 @GeneratedValue(strategy=GenerationType.AUTO)
  private int uid;
 @Column(name = "upass") 
  private String upass;

  public int getId() {
    return uid;
  }
  
  public void setId(int id) {
	    this.uid=id;
	  }


public String getPassword() {
	return upass;
}

public void setPassword(String password) {
	this.upass = password;
}
}