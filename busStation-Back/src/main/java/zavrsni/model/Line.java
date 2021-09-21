package zavrsni.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Line {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private int availableSeats;
	
	@Column
	private double price;
	
	@Column
	private String scheduled;
	
	@Column(nullable = false)
	private String destination;
	
	@ManyToOne
	private Company company;
	
	@OneToMany(mappedBy="line")
	private List<Reservation> reservations = new ArrayList<>();

	public Line() {
		super();
	}

	public Line(Long id, int availableSeats, double price, String scheduled, String destination, Company company,
			List<Reservation> reservations) {
		super();
		this.id = id;
		this.availableSeats = availableSeats;
		this.price = price;
		this.scheduled = scheduled;
		this.destination = destination;
		this.company = company;
		this.reservations = reservations;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Reservation> getReservation() {
		return reservations;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservations = reservation;
	}

}
