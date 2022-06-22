package com.webService.service.userSection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface rachunekrepository extends JpaRepository <rachunek,String>{
	@Transactional
	@Modifying
	@Query(value="insert into rachunek(id_rach,id_prod, ilosc) values(:id_rach,:id, :ilosc)", nativeQuery=true)
	public void insertRachunek(@Param("id_rach") String id_rachunku,@Param("id") int id, @Param("ilosc") int ilosc);
	@Query(value="select * from rachunek where id_rach=:id_rach", nativeQuery=true)
	public products findByRachId(@Param("id_rach") String numerRachunku);
}
