package fa.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.entites.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

}
