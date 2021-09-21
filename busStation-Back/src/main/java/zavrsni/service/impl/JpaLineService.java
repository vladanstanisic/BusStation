package zavrsni.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import zavrsni.model.Line;
import zavrsni.repository.LineRepository;
import zavrsni.service.LineService;

@Service
public class JpaLineService implements LineService{

	@Autowired
	private LineRepository lineRepository;

	@Override
	public List<Line> findAll() {
		return lineRepository.findAll();
	}

	@Override
	public Line findOne(Long id) {
		return lineRepository.findOneById(id);
	}

	@Override
	public List<Line> find(List<Long> ids) {
		return lineRepository.findByIdIn(ids);
	}

	@Override
	public Page<Line> findAll(int pageNumber) {
		return lineRepository.findAll(PageRequest.of(pageNumber,2));
	}

	@Override
	public Line save(Line line) {
		return lineRepository.save(line);
	}

	@Override
	public Line update(Line line) {
		return lineRepository.save(line);
	}

	@Override
	public Line delete(Long id) {
		Optional<Line> line = lineRepository.findById(id);
		if(line.isPresent()) {
			lineRepository.deleteById(id);
			return line.get();
		}
		return null;
	}

	@Override
	public Page<Line> search(String destination, Long companyId, Double maximumPrice, int pageNo) {
		return lineRepository.search(destination, companyId, maximumPrice, PageRequest.of(pageNo, 2));
	}
}
