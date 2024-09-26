package mz.co.keomagroup.bePreparedJavaAPI.repository;

import mz.co.keomagroup.bePreparedJavaAPI.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
