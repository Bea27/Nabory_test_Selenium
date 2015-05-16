package slowniki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Poddzialania")
public class Poddzialanie {

	@Column(name ="Identyfikator")
	private int id;
	
	@Column(name ="Nr_poddzial")
	private String nr_poddzial;
	
	@Column(name ="Nazwa_poddzialania")
	private String nazwaPodDzialania;
	
	@Column(name ="Nr_dzia")
	private String nr_dzia;
	
	@Column(name ="Nr_os")
	private String nr_os;
	
	
	@Column(name ="Klucz")
	private String klucz;
	
	@Id
	@Column(name ="Klucz2")
	private String klucz2;
	
	
	public Poddzialanie() {
		
	}


	public int getId() {
		return id;
	}


	public String getNr_poddzial() {
		return nr_poddzial;
	}


	public String getNazwaPodDzialania() {
		return nazwaPodDzialania;
	}


	public String getNr_dzia() {
		return nr_dzia;
	}


	public String getNr_os() {
		return nr_os;
	}


	public String getKlucz() {
		return klucz;
	}


	public String getKlucz2() {
		return klucz2;
	}
		
}
