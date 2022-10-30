package fa.training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.entites.DatVe;

@Repository
public interface DatVeRepository extends JpaRepository<DatVe, String> {
}
