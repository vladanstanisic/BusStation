package zavrsni.web.dto;

import javax.validation.constraints.Positive;

public class CompanyDTO {

	@Positive(message = "Id must be positive.")
    private Long id;
	
	private String name;
	
	private String address;
	
	private String pib;

	public CompanyDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}
}
