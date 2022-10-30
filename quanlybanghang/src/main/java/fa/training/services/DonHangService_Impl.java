package fa.training.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dto.TimKiem;
import fa.training.entites.DonHang;
import fa.training.repositories.DonHangRepository;

@Service
public class DonHangService_Impl implements IDonHangService {
	@Autowired
	DonHangRepository donHangRepository;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<DonHang> findAll() {
		return donHangRepository.findAll();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public DonHang add(DonHang donHang) {
		return donHangRepository.save(donHang);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public DonHang findById(String maDH) {
		return donHangRepository.findById(maDH).orElse(null);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<DonHang> findAllByTimKiem(TimKiem timKiem) {
		List<DonHang> donHangs = findAll().stream().filter(donHang -> donHang.isTimKiem(timKiem))
				.collect(Collectors.toList());
		return donHangs;
	}

}
