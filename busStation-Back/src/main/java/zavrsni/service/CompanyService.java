package zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import zavrsni.model.Company;

public interface CompanyService {

List<Company> findAll();
	
	Company findOne(Long id);
	
	List<Company> find(List<Long> ids);
	
	Page<Company> findAll(int pageNumber);
	
	Company save (Company company);
	
	Company update (Company company);
	
	Company delete (Long id);
}
