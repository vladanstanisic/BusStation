package zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import zavrsni.model.Line;

public interface LineService {

List<Line> findAll();
	
	Line findOne(Long id);
	
	List<Line> find(List<Long> ids);
	
	Page<Line> findAll(int pageNumber);
	
	Line save (Line line);
	
	Line update (Line line);
	
	Line delete (Long id);

	Page<Line> search(String destination, Long companyId, Double maximumPrice, int pageNo);
}
