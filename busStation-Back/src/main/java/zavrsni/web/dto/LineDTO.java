package zavrsni.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class LineDTO {

	@Positive(message = "Id must me positive.")
    private Long id;
	
	@Positive(message = "Number of available seats must be positive.")
	private int availableSeats;
	
	private double price;
	
	private String scheduled;
	
	@NotNull(message = "Destination can't be empty.")
	private String destination;
	
	private CompanyDTO companyDTO;

	public LineDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getScheduled() {
		return scheduled;
	}

	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}
}
