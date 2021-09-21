package zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import zavrsni.model.Reservation;

public interface ReservationService {

List<Reservation> findAll();
	
	Reservation findOne(Long id);
	
	List<Reservation> find(List<Long> ids);
	
	Page<Reservation> findAll(int pageNumber);
	
	Reservation save (Reservation reservation);
	
	Reservation update (Reservation reservation);
	
	Reservation delete (Long id);
}
