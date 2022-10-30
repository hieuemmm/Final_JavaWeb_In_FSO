package fa.training.services;

import java.util.List;

import fa.training.entites.TTOrder;

public interface ITTOrderService{

	void save(TTOrder ttOrder);

	List<TTOrder> findAll();

	List<TTOrder> findAllByTenKhachHang(String search);

	TTOrder findById(String maOrder);

}
