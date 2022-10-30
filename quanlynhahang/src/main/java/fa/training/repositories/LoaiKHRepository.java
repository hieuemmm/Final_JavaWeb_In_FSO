package fa.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.entites.LoaiKH;

@Repository
public interface LoaiKHRepository extends JpaRepository<LoaiKH, String>{

}
