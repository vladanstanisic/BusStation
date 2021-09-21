package zavrsni.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import zavrsni.model.Company;
import zavrsni.repository.CompanyRepository;
import zavrsni.service.CompanyService;

@Service
public class JpaCompanyService implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company findOne(Long id) {
		return companyRepository.findOneById(id);
	}

	@Override
	public List<Company> find(List<Long> ids) {
		return companyRepository.findByIdIn(ids);
	}

	@Override
	public Page<Company> findAll(int pageNumber) {
		return companyRepository.findAll(PageRequest.of(pageNumber,10));
	}

	@Override
	public Company save(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company update(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public Company delete(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if(company.isPresent()) {
			companyRepository.deleteById(id);
			return company.get();
		}
		return null;
	}
}
