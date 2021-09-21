package zavrsni.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import zavrsni.model.Reservation;
import zavrsni.repository.ReservationRepository;
import zavrsni.service.ReservationService;

@Service
public class JpaReservationService implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findOne(Long id) {
		return reservationRepository.findOneById(id);
	}

	@Override
	public List<Reservation> find(List<Long> ids) {
		return reservationRepository.findByIdIn(ids);
	}

	@Override
	public Page<Reservation> findAll(int pageNumber) {
		return reservationRepository.findAll(PageRequest.of(pageNumber,2));
	}

	@Override
	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation update(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation delete(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		if(reservation.isPresent()) {
			reservationRepository.deleteById(id);
			return reservation.get();
		}
		return null;
	}

}
