package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entites.KhachHang;
import fa.training.repositories.KhachHangRepository;
@Service
public class KhachHangService_Impl implements IGeneralService<KhachHang, String> {
	@Autowired
	KhachHangRepository khachHangRepository;

	@Override
	public List<KhachHang> findAll() {
		return khachHangRepository.findAll();
	}

	@Override
	public List<KhachHang> findAllByKeyWord(String keyword) {
		return null;
	}

	@Override
	public KhachHang findById(String id) {
		return khachHangRepository.findById(id).orElse(null);
	}

	@Override
	public KhachHang save(KhachHang t) {
		return khachHangRepository.save(t);
	}

	@Override
	public boolean delete(String id) {
		khachHangRepository.deleteById(id);
		return true;
	}
}
