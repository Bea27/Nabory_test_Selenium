package slowniki;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Osie")
public class Os {
	
	@Column(name ="Id")
	private int id;
	
	@Id
	@Column(name ="Nr_os")
	private String nr_os;
	
	@Column(name ="Nazwa_os")
	private String nazwa_osi;
	
	public Os() {
		// TODO Auto-generated constructor stub
	}

	public String getNr_os() {
		return nr_os;
	}

	public String getNazwa_osi() {
		return nazwa_osi;
	}
}
