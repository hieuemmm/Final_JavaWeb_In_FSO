package edu.fa.serviceIplm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.Formregister;
import edu.fa.model.Khachhang;
import edu.fa.repository.KhachhangReporitory;
import edu.fa.service.KhachhangService;
@Service
public class KhachhangserviceImpl implements KhachhangService {
	@Autowired
	KhachhangReporitory khachhangReporitory;
	

	public void insertComputer(Formregister formregister) {
		
		
		Khachhang khachhang = new Khachhang(formregister.getCCCD(), formregister.getHoTen(), formregister.getNgaySinh(),
				formregister.getGioiTinh(), formregister.getSoDienThoai(), formregister.getTrangThaiTiem(), formregister.getKetQuaSetNghiem(), 
				formregister.getNgaySetNghiem());
		
		khachhangReporitory.save(khachhang);
		
	}


	public List<Khachhang> findAll() {
	
		return khachhangReporitory.findAll();
	}


	public List<Khachhang> selectSearch(String search) {
		
		return khachhangReporitory.findAll(search);
	}


	public Khachhang selectByid(String id) {
		
		return khachhangReporitory.findOne(id);
	}


	public void insertRegister(Khachhang khachhang) {
		khachhangReporitory.save(khachhang);
		
	}

}
