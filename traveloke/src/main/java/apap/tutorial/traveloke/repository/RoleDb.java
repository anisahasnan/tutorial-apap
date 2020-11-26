package apap.tutorial.traveloke.repository;

import apap.tutorial.traveloke.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDb extends JpaRepository<RoleModel, Long>{
    Optional<RoleModel> findById(Long id);
}
