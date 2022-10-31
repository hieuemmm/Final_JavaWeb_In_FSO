package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entites.KhachHang;
import fa.training.repositories.KhachHangRepository;

@Service
public class KhachHangService_impl implements IKhachHangService {
	@Autowired
	KhachHangRepository khachHangRepository;

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	@Override
	public List<KhachHang> findAll() {
		return khachHangRepository.findAll();
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	@Override
	public KhachHang findById(String id) {
		return khachHangRepository.findById(id).orElse(null);
	}

	/**
	 * @Authour : ThoPP
	 * @Birthday : 1992-08-26
	 */
	@Override
	public KhachHang add(KhachHang khachHang) {
		return khachHangRepository.save(khachHang);
	}
}
