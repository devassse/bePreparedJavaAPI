package mz.co.keomagroup.bePreparedJavaAPI.repository;

import mz.co.keomagroup.bePreparedJavaAPI.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
