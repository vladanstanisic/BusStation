package zavrsni.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zavrsni.model.Company;
import zavrsni.service.CompanyService;
import zavrsni.support.CompanyDtoToCompany;
import zavrsni.support.CompanyToCompanyDto;
import zavrsni.web.dto.CompanyDTO;

@RestController
@RequestMapping(value = "/api/companies", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyToCompanyDto toCompanyDto;
	
	@Autowired
	private CompanyDtoToCompany toCompany;
	
	//@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<CompanyDTO>> getAll () {
		
		List<Company> companies = companyService.findAll();
		
		return new ResponseEntity<>(toCompanyDto.convert(companies), HttpStatus.OK);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <CompanyDTO> create (@Valid @RequestBody CompanyDTO companyDTO) {
		
		Company company = toCompany.convert(companyDTO);
		Company savedCompany = companyService.save(company);
		
		return new ResponseEntity<>(toCompanyDto.convert(savedCompany), HttpStatus.CREATED);
	}
}
