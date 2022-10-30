package fa.training.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.dto.ChuaDuDienKien;
import fa.training.entites.DatVe;
import fa.training.repositories.DatVeRepository;

@Service
public class DatVeService_Impl implements IGeneralService<DatVe, String> {
	@Autowired
	DatVeRepository datVeRepository;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<DatVe> findAll() {
		return datVeRepository.findAll();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	public List<DatVe> findByChuaDuDieuKien(List<DatVe> datVes, ChuaDuDienKien chuaDuDienKien) {
		List<DatVe> datVesFilter = datVes.stream()
				.filter(datVe -> datVe.getKhachHang().isChuaDuDieuKien(chuaDuDienKien)).collect(Collectors.toList());

		return datVesFilter;
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<DatVe> findAllByKeyWord(String keyword) {
		return null;
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public DatVe findById(String id) {
		return datVeRepository.findById(id).orElse(null);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public DatVe save(DatVe t) {
		return datVeRepository.save(t);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public boolean delete(String id) {
		datVeRepository.deleteById(id);
		return true;
	}
}
