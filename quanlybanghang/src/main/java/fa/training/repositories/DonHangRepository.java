package fa.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.training.entites.DonHang;

public interface DonHangRepository extends JpaRepository<DonHang, String> {

}
