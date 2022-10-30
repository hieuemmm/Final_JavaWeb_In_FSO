package fa.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.entites.TTOrder;
import fa.training.repositories.TTOrderRepository;

@Service
public class TTOrderService_Impl implements ITTOrderService {
	@Autowired
	TTOrderRepository ttOrderRepository;

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<TTOrder> findAll() {
		return ttOrderRepository.findAll();
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public TTOrder findById(String maOrder) {
		return ttOrderRepository.findById(maOrder).orElse(null);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public List<TTOrder> findAllByTenKhachHang(String search) {
		return ttOrderRepository.findAllByTenKHContaining(search);
	}

	/**
	 * @Authour : HieuVV4
	 * @Birthday : 2000-08-26
	 */
	@Override
	public void save(TTOrder ttOrder) {
		ttOrderRepository.save(ttOrder);
	}
}
