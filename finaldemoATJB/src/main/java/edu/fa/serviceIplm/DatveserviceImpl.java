package edu.fa.serviceIplm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.model.DatVe;
import edu.fa.model.Formregister;
import edu.fa.repository.DatveRepository;
import edu.fa.service.DatveService;
@Service
public class DatveserviceImpl implements DatveService {
@Autowired
DatveRepository datveRepository;

	public void insertDatve(Formregister formregister) {
		DatVe datVe = new DatVe(formregister.getMaDV(), formregister.getCCCD(), formregister.getNgayDatVe(),
				formregister.getBienSoXe(), formregister.getDiaDiemXuatPhat(), formregister.getDiaDiemDen(), formregister.getNgayXuatPhat());
		datveRepository.save(datVe);
	}

}
