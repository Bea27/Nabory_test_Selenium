package nabor;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nabor {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idnaboru;
	
	 private String osNazwa;
	 private String osNumer;
	 private String dzialNazwa;
	 private String dzialNumer;
	 private String poddzialNazwa;
	 private String poddzialNumer;
	 private String numerOsDzP;
	 
	 private Date rozpNaboru;
	 private Date zakoNaboru;
	 private double budzetNaboru;
	 private String statusNaboru;
	 private String instytucjaOgl;
	 
	public Nabor() {
		
	}
	 
	public String getUnikalnyNumer() {
		String unNumer = null;
	
		if(instytucjaOgl.equals("UMWM"))  unNumer = "RPMP." + numerOsDzP;
		if(instytucjaOgl.equals("WUP"))  unNumer = "RPMP." + numerOsDzP;
		if(instytucjaOgl.equals("MCP"))  unNumer = "RPMP." + numerOsDzP;
		
		String aabb ="-IZ.01-";
		unNumer = unNumer + aabb;

		String obszar = "12-";
		unNumer = unNumer + obszar;
		
		String id = String.format("%1$03d", idnaboru);
		
		unNumer = unNumer + id;
		
		Date dzis = new Date();
		String year = dzis.toString();
		int kon = year.length();
		int pocz = year.length() - 2;
		year = year.substring(pocz,kon);
				
//		String year = dzis.toLocaleString();
//		year = year.substring(2, 4);
		
		year = "/" + year;
		
		unNumer = unNumer + year;				
		return unNumer;
	}
	
	public int getIdnaboru() {
		return idnaboru;
	}
	public String getOsNazwa() {
		return osNazwa;
	}
	public String getOsNumer() {
		return osNumer;
	}
	public String getDzialNazwa() {
		return dzialNazwa;
	}
	public String getDzialNumer() {
		return dzialNumer;
	}
	public String getPoddzialNazwa() {
		return poddzialNazwa;
	}
	public String getPoddzialNumer() {
		return poddzialNumer;
	}
	public String getNumerOsDzP() {
		return numerOsDzP;
	}
	public Date getRozpNaboru() {
		return rozpNaboru;
	}
	public Date getZakoNaboru() {
		return zakoNaboru;
	}
	public double getBudzetNaboru() {
		return budzetNaboru;
	}
	public String getStatusNaboru() {
		return statusNaboru;
	}
	public String getInstytucjaOgl() {
		return instytucjaOgl;
	}
	public void setIdnaboru(int idnaboru) {
		this.idnaboru = idnaboru;
	}
	public void setOsNazwa(String osNazwa) {
		this.osNazwa = osNazwa;
	}
	public void setOsNumer(String osNumer) {
		this.osNumer = osNumer;
	}
	public void setDzialNazwa(String dzialNazwa) {
		this.dzialNazwa = dzialNazwa;
	}
	public void setDzialNumer(String dzialNumer) {
		this.dzialNumer = dzialNumer;
	}
	public void setPoddzialNazwa(String poddzialNazwa) {
		this.poddzialNazwa = poddzialNazwa;
	}
	public void setPoddzialNumer(String poddzialNumer) {
		this.poddzialNumer = poddzialNumer;
	}
	public void setNumerOsDzP(String numerOsDzP) {
		this.numerOsDzP = numerOsDzP;
	}
	public void setRozpNaboru(Date rozpNaboru) {
		this.rozpNaboru = rozpNaboru;
	}
	public void setZakoNaboru(Date zakoNaboru) {
		this.zakoNaboru = zakoNaboru;
	}
	public void setBudzetNaboru(double budzetNaboru) {
		this.budzetNaboru = budzetNaboru;
	}
	public void setStatusNaboru(String statusNaboru) {
		this.statusNaboru = statusNaboru;
	}
	public void setInstytucjaOgl(String instytucjaOgl) {
		this.instytucjaOgl = instytucjaOgl;
	}
	
	
}
