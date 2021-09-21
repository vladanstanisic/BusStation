package zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Reservation;
import zavrsni.web.dto.ReservationDTO;

@Component
public class ReservationToReservationDto implements Converter<Reservation, ReservationDTO>{
	@Autowired
	private LineToLineDto toLineDto;

	@Override
	public ReservationDTO convert(Reservation source) {
		ReservationDTO reservationDTO = new ReservationDTO();
		
		reservationDTO.setId(source.getId());
		reservationDTO.setLineDto(toLineDto.convert(source.getLine()));
		
		return reservationDTO;
	}
	
	public List<ReservationDTO> convert(List<Reservation> reservations) {
		List<ReservationDTO> reservationsDTO = new ArrayList<>();
		
		for (Reservation r: reservations) {
			reservationsDTO.add(convert(r));
		}
		
		return reservationsDTO;
	}
}
