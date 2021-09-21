package zavrsni.web.dto;

import javax.validation.constraints.Positive;

public class ReservationDTO {

	@Positive(message = "Id must be positive.")
    private Long id;
	
	private LineDTO lineDto;

	public ReservationDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LineDTO getLineDto() {
		return lineDto;
	}

	public void setLineDto(LineDTO lineDto) {
		this.lineDto = lineDto;
	}
}
