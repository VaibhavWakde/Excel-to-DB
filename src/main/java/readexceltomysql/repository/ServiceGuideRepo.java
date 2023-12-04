package readexceltomysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import readexceltomysql.entity.ServiceGuide;

public interface ServiceGuideRepo extends JpaRepository<ServiceGuide,Long> {

    @Query(value = "select * from service_guide where category_id = (?1) and vehicle_type=(?2)",nativeQuery = true)
    ServiceGuide getServiceGuideByCategoryId(Long categoryId, Long vehicleType);
}
