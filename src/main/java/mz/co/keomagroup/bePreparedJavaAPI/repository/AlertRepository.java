package mz.co.keomagroup.bePreparedJavaAPI.repository;

import mz.co.keomagroup.bePreparedJavaAPI.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}
