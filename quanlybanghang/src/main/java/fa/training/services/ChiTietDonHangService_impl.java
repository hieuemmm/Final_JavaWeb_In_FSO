package fa.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entites.ChiTietDonHang;
import fa.training.repositories.ChiTietDonHangRepository;

@Service
public class ChiTietDonHangService_impl implements IChiTietDonHangService {
	@Autowired
	ChiTietDonHangRepository chiTietDonHangRepository;

	@Override
	public ChiTietDonHang add(ChiTietDonHang chiTietDonHang) {
		return chiTietDonHangRepository.save(chiTietDonHang);
	}
}
