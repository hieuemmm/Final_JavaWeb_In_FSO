package fa.training.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entites.KhachHang;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String>{
}
