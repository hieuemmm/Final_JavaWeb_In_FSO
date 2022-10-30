package fa.training.services;

import java.util.List;

import fa.training.entites.KhachHang;

public interface IKhachHangService {

	KhachHang add(KhachHang khachHang);

	List<KhachHang> findAll();

	KhachHang findById(String id);
}
