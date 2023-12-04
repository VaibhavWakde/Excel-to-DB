package readexceltomysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import readexceltomysql.entity.FaqData;

public interface FaqDataRepo extends JpaRepository<FaqData,Long> {
}
