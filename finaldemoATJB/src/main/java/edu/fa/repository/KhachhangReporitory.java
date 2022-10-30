package edu.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.Khachhang;

public interface KhachhangReporitory extends JpaRepository<Khachhang, String>{
	 @Query("SELECT d FROM Khachhang d WHERE d.TrangThaiTiem LIKE %?1%"
	            + " OR d.KetQuaSetNghiem LIKE %?1%"
	           
	            
	              )
	List<Khachhang> findAll(String search);

}
