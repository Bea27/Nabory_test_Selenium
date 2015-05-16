package slowniki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dzialania")
public class Dzialanie {
	
	@Column(name ="Identyfikator")
	private int id;
	
	@Column(name ="Nr_dzia")
	private String nr_dzial;
	
	@Column(name ="Nazwa_dzia")
	private String nazwaDzialania;
	
	
	@Column(name ="Nr_os")
	private String nr_os;
	
	@Id
	@Column(name ="Klucz")
	private String klucz;

	
	public Dzialanie() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public String getNr_dzial() {
		return nr_dzial;
	}

	public String getNazwaDzialania() {
		return nazwaDzialania;
	}

	public String getNr_os() {
		return nr_os;
	}

	public String getKlucz() {
		return klucz;
	}
		
}
