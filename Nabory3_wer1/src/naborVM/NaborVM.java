package naborVM;
import nabor.InfoNaboru;
import nabor.Nabor;
import nabor.NaborDAO;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

import slowniki.Os;
import slowniki.OsDAO;
import slowniki.Dzialanie;
import slowniki.Poddzialanie;


public class NaborVM {
	
	
	private Nabor nabor;
	
	
	private Os os_glowna;
	private Dzialanie wybraneDzialanie;
	private Poddzialanie wybranePodDzialanie;
	private List<Os> lista_osi;
	private List<Dzialanie> lista_dzialan;
	private List<Poddzialanie> lista_poddzialan;
	
	
	private Date rozpoczecieNaboru;
	private Date zakonczenieNaboru;
	
	private double budzetNaboru;
	
	private String statusNaboru;
	private String instytucjaOgl;
	
	public List<String> getInstytucje() {
		return InfoNaboru.getInstytucje();	
	}
	
	public List<String> getStatusy() {
		return InfoNaboru.getStatusy();	
	}
	
	@Wire
	private Div topDiv;
	
	@Wire
	private Window modal01;
	
	@Wire
	private Window modal02;
	
	@Wire
	private Window modal03;
	
	@Wire
	private Window modalSAVE;

/*************************************  INIT  ************************************************************/	
	@Init
	public void init() {
		lista_osi = new OsDAO().getOsie();
		nabor = new Nabor();
			
	}		

/*************************************  AFTER COMPOSE ****************************************************/
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}
		
/*************************************  @Command  filtrujDzialania  ****************************************************/	
	
	@Command
	@NotifyChange({ "lista_dzialan", "os_glowna" })
	public void filtrujDzialania() {
		String numer = os_glowna.getNr_os();
//		System.out.println("Wybrany numer Osi to:" + numer);
//		String pom2 = os_glowna.getNazwa_osi();
//		System.out.println("Wybrana oœ to: "+ pom2);
		lista_dzialan = new OsDAO().getDzialania(os_glowna.getNr_os());
		
//		int pom3 = lista_dzialan.size();
//		System.out.println("Lista Dzialañ rozmiar:" + pom3);
		
//		for (int i=0; i<lista_dzialan.size(); i++)	{
//			Dzialanie dzial= lista_dzialan.get(i);
//			System.out.println(dzial.getNazwaDzialania());
//		}
	}
/*************************************  @Command  filtrujPodDzialania  ****************************************************/	
	@Command
	@NotifyChange({ "lista_poddzialan", "wybraneDzialanie", "lista_dzialan" })
	public void filtrujPodDzialania() {
		
//		String num2 = wybraneDzialanie.getKlucz();
//		System.out.println("Wybrane Dzia³anie to:" + num2);
//		String pom3 = wybraneDzialanie.getNazwaDzialania();
//		System.out.println("Wybrana Dzia³anie: "+ pom3);
		
		lista_poddzialan = new OsDAO().getPodDzialania(wybraneDzialanie.getKlucz());
		wybranePodDzialanie=null;
		
//		int pom4 = lista_poddzialan.size();
//		System.out.println("Lista PodDzialañ rozmiar:" + pom4);
		
//		if(lista_poddzialan.isEmpty()) {
//			System.out.println("Nie ma poddzialañ");
//		}
//		else {
//		for (int i=0; i<lista_poddzialan.size(); i++)	{
//			Poddzialanie pom5 = lista_poddzialan.get(i);
//			System.out.println(pom5.getKlucz2());
//			System.out.println(pom5.getNazwaPodDzialania());
//			}
//		}
	}

/*************************************  Zapis do Bazy danych  ************************************************************/		
	@Command
	public void zapiszNabor() {
		
		nabor.setOsNazwa(os_glowna.getNazwa_osi());
		nabor.setOsNumer(os_glowna.getNr_os());
		nabor.setDzialNazwa(wybraneDzialanie.getNazwaDzialania());
		nabor.setDzialNumer(wybraneDzialanie.getNr_dzial());
		nabor.setPoddzialNazwa(wybranePodDzialanie.getNazwaPodDzialania());
		nabor.setPoddzialNumer(wybranePodDzialanie.getNr_poddzial());
		
		nabor.setNumerOsDzP(wybranePodDzialanie.getKlucz2());
		
		nabor.setRozpNaboru(rozpoczecieNaboru);
		nabor.setZakoNaboru(zakonczenieNaboru);
		nabor.setBudzetNaboru(budzetNaboru);
		nabor.setStatusNaboru(statusNaboru);
		nabor.setInstytucjaOgl(instytucjaOgl);
		
		NaborDAO nowyNabor = new NaborDAO();
		nowyNabor.saveNabor(nabor);
		
		modalSAVE = (Window) Executions.createComponents("save.zul", topDiv, null);
		
	}
	
	@Command
	public void wyjdz() {
		modalSAVE.detach();
		modalSAVE = null;
	}
		
	@Command
	public void drukuj() {
		modal01 = (Window) Executions.createComponents("drukuj.zul", topDiv, null);
	}
	
	@Command
	public void akceptuje(){
		modal01.detach();
		modal01 = null;
	}
	
	@Command
	public void pomoc(){		
		modal02 = (Window) Executions.createComponents("pomoc.zul", topDiv, null);
	}
	
	@Command
	public void zgadzamSie(){
		modal02.detach();
		modal02 = null;
	}
	
	@Command
	public void robcos() {
		modal03 = (Window) Executions.createComponents("tymczasowy.zul", topDiv, null);
	}
	
	@Command
	public void wyjscie(){
		modal03.detach();
		modal03 = null;
	}
	

/*************************************  Tworzenie obiektu klasy NaborXML  ************************************************************/	
/*************************************  na podstawie obiektu nabor z Bazy Danych  ************************************************************/
/*************************************  Tworzenie pliku XML  ************************************************************/		
	
/*************************************  konwertujDate (z Date na XMLGregorianCalendar) ****************************************************/	
	public XMLGregorianCalendar konwertujDate(Date dat) {
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setGregorianChange(dat);
    	cal.setTime(dat);
		
		XMLGregorianCalendar xmlDate = null;
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return xmlDate;
	}
	
	
	
	public Date getRozpoczecieNaboru() {
		return rozpoczecieNaboru;
	}

	public void setRozpoczecieNaboru(Date rozpoczecieNaboru) {
		this.rozpoczecieNaboru = rozpoczecieNaboru;
	}

	public Date getZakonczenieNaboru() {
		return zakonczenieNaboru;
	}

	public void setZakonczenieNaboru(Date zakonczenieNaboru) {
		this.zakonczenieNaboru = zakonczenieNaboru;
	}

	public double getBudzetNaboru() {
		return budzetNaboru;
	}

	public void setBudzetNaboru(double budzetNaboru) {
		this.budzetNaboru = budzetNaboru;
	}

	public String getStatusNaboru() {
		return statusNaboru;
	}

	public void setStatusNaboru(String statusNaboru) {
		this.statusNaboru = statusNaboru;
	}

	public String getInstytucjaOgl() {
		return instytucjaOgl;
	}

	public void setInstytucjaOgl(String instytucjaOgl) {
		this.instytucjaOgl = instytucjaOgl;
	}

	public Os getOs_glowna() {
		return os_glowna;
	}

	public void setOs_glowna(Os os_glowna) {
		this.os_glowna = os_glowna;
	}

	public List<Os> getLista_osi() {
		return lista_osi;
	}

	public Dzialanie getWybraneDzialanie() {
		return wybraneDzialanie;
	}
	
	public List<Dzialanie> getLista_dzialan() {
		return lista_dzialan;
	}

	public void setWybraneDzialanie(Dzialanie wybraneDzialanie) {
		this.wybraneDzialanie = wybraneDzialanie;
	}

	public void setLista_osi(List<Os> lista_osi) {
		this.lista_osi = lista_osi;
	}

	public void setLista_dzialan(List<Dzialanie> lista_dzialan) {
		this.lista_dzialan = lista_dzialan;
	}

	public Poddzialanie getWybranePodDzialanie() {
		return wybranePodDzialanie;
	}

	public List<Poddzialanie> getLista_poddzialan() {
		return lista_poddzialan;
	}

	public void setWybranePodDzialanie(Poddzialanie wybranePodDzialanie) {
		this.wybranePodDzialanie = wybranePodDzialanie;
	}

	public void setLista_poddzialan(List<Poddzialanie> lista_poddzialan) {
		this.lista_poddzialan = lista_poddzialan;
	}
	
	
}
