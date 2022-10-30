package fa.training.services;

import java.util.ArrayList;
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

	@Override
	public List<DatVe> findAll() {
		return datVeRepository.findAll();
	}

	public List<DatVe> findByChuaDuDieuKien(List<DatVe> datVes, ChuaDuDienKien chuaDuDienKien) {
		List<DatVe> datVesFilter = datVes.stream()
				.filter(datVe -> datVe.getKhachHang().isChuaDuDieuKien(chuaDuDienKien))
				.collect(Collectors.toList());

		return datVesFilter;
	}

	@Override
	public List<DatVe> findAllByKeyWord(String keyword) {
		return null;
	}

	@Override
	public DatVe findById(String id) {
		return datVeRepository.findById(id).orElse(null);
	}

	@Override
	public DatVe save(DatVe t) {
		return datVeRepository.save(t);
	}

	@Override
	public boolean delete(String id) {
		datVeRepository.deleteById(id);
		return true;
	}
}
