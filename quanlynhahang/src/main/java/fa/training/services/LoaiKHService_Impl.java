package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entites.LoaiKH;
import fa.training.repositories.LoaiKHRepository;

@Service
public class LoaiKHService_Impl implements ILoaiKHService {
	@Autowired
	LoaiKHRepository loaiKHRepository;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<LoaiKH> findAll() {
		return loaiKHRepository.findAll();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public LoaiKH findById(String maLoaiKH) {
		return loaiKHRepository.findById(maLoaiKH).orElse(null);
	}
}
