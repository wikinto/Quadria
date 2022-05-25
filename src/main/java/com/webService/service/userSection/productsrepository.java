package com.webService.service.userSection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface productsrepository extends JpaRepository <products,String>{
	@Query(value="SELECT * FROM products p WHERE p.barcode=:barcode",nativeQuery=true)
	products getByBarcode(@Param("barcode") String barcode);
}
