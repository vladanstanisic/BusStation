package zavrsni.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column
	private String address;
	
	@Column(nullable = false, unique = true)
	private String pib;
	
	@OneToMany(mappedBy="company")
	private List<Line> lines = new ArrayList<>();

	public Company() {
		super();
	}

	public Company(Long id, String name, String address, String pib, List<Line> lines) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.pib = pib;
		this.lines = lines;
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

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

}
