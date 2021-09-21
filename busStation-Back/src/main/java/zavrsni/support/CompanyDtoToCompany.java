package zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Company;
import zavrsni.service.CompanyService;
import zavrsni.web.dto.CompanyDTO;

@Component
public class CompanyDtoToCompany implements Converter<CompanyDTO, Company>{

	@Autowired
	private CompanyService companyService;

	@Override
	public Company convert(CompanyDTO source) {
		Company company;
		
		if (source.getId() == null) {
			company = new Company();
		} else {
			company = companyService.findOne(source.getId());
		}
		
		if (company != null) {
			company.setAddress(source.getAddress());
			company.setName(source.getName());
			source.setPib(source.getPib());
		}
		
		return company;
	}
}
