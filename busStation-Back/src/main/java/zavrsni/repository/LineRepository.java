package zavrsni.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zavrsni.model.Line;

@Repository
public interface LineRepository extends JpaRepository<Line, Long>{

	Line findOneById(Long id);

	List<Line> findByIdIn(List<Long> ids);
	
	@Query("SELECT l FROM Line l WHERE "
	+ "(:destination IS NULL OR l.destination like %:destination%) AND "
	+ "(:companyId IS NULL OR l.company.id = :companyId) AND "
	+ "(:maximumPrice IS NULL OR l.price <= :maximumPrice)")
	Page<Line> search(@Param("destination") String destination, 
			@Param("companyId") Long companyId, 
			@Param("maximumPrice") Double maximumPrice, Pageable pageable);
}
