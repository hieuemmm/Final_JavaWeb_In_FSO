package fa.training.services;

import java.util.List;

import fa.training.dto.TimKiem;
import fa.training.entites.DonHang;

public interface IDonHangService {
	DonHang add(DonHang donHang);

	List<DonHang> findAll();

	DonHang findById(String maDH);

	List<DonHang> findAllByTimKiem(TimKiem timKiem);
}
