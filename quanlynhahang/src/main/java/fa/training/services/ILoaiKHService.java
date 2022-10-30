package fa.training.services;

import java.util.List;

import fa.training.entites.LoaiKH;

public interface ILoaiKHService {

	List<LoaiKH> findAll();

	LoaiKH findById(String maLoaiKH);

}
