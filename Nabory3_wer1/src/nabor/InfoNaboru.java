package nabor;

import java.util.ArrayList;
import java.util.List;

public class InfoNaboru {
	private static List<String> statusy = new ArrayList<String>();
	private static List<String> instytucje = new ArrayList<String>();
		
		static{
			statusy.add("wersja robocza");
			statusy.add("planowany");
			statusy.add("ogłoszony");
			statusy.add("unieważniony");
			statusy.add("zawieszony");
			statusy.add("zakończony");
			
			instytucje.add("UMWM");
			instytucje.add("WUP");
			instytucje.add("MCP");
					
		}

		public static List<String> getStatusy() {
			return statusy;
		}

		public static List<String> getInstytucje() {
			return instytucje;
		}
}
