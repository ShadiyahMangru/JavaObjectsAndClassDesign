import java.util.*;
import java.util.Map;

public class PlayerRepeats {
	//fields
	private String roster2013;
	private String roster2014;
	private String roster2015;
	private String roster2016;
	private String roster2017;
	private String roster2018;
	
	//constructor
	public PlayerRepeats(){
		setRoster2013();
		setRoster2014();
		setRoster2015();
		setRoster2016();
		setRoster2017();
		setRoster2018();
	}
	
	//setters
	public void setRoster2013(){
		roster2013 = "Backstrom, Beagle, Brouwer, Brown, Chimera, Deschamps, Erat, Fehr, Grabovski, Johansson, Kuznetsov, Laich, Latta, LeBlanc, Ovechkin, Penner, Stoa, Volpatti, Ward, Wellman, Wilson, Alzner, Brouillette, Carlson, Carrick, Erskine, Green, Hillen, Oleksy, Orlov, Schilling, Schmidt, Strachan, Urbom, Wey, Grubauer, Halak, Holtby, Neuvirth";
	}
	
	public void setRoster2014(){
		roster2014 = "Backstrom, Beagle, Brouwer, Brown, Burakovsky, Chimera, Conner, Fehr, Galiev, Glencross, Johansson, Kuznetsov, Laich, Latta, O'Brien, Ovechkin, Volpatti, Ward, Wilson, Alzner, Carlson, Gleason, Green, Hillen, Niskanen, Oleksy, Orpik, Schilling, Schmidt, Grubauer, Holtby, Peters";
	}
	
	public void setRoster2015(){
		roster2015 = "Backstrom, Beagle, Brown, Burakovsky, Carey, Chimera, Collins, Galiev, Johansson, Kuznetsov, Laich, Latta, Oshie, Ovechkin, Richards, Sill, Stephenson, Williams, Wilson, Winnik, Alzner, Carlson, Carrick, Chorney, Ness, Niskanen, Orlov, Orpik, Schmidt, Stanton, Weber, Grubauer, Holtby";
	}
	
	public void setRoster2016(){
		roster2016 = "Backstrom, Barber, Beagle, Burakovsky, Carey, Connolly, Eller, Johansson, Kuznetsov, Mitchell, O'Brien, Oshie, Ovechkin, Sanford, Stephenson, Vrana, Williams, Wilson, Winnik, Alzner, Carlson, Chorney, Ness, Niskanen, Orlov, Orpik, Schmidt, Shattenkirk, Grubauer, Holtby";
	}
	
	public void setRoster2017(){
		roster2017 = "Backstrom, Beagle, Boyd, Burakovsky, Chiasson, Connolly, Eller, Gersich, Graovac, Kuznetsov, O'Brien, Oshie, Ovechkin, Peluso, Smith-Pelly, Stephenson, Vrana, Walker, Wilson, Bowey, Carlson, Chorney, Djoos, Jerabek, Kempny, Ness, Niskanen, Orlov, Orpik, Grubauer, Holtby";
	}
	
	public void setRoster2018(){
		roster2018 = "Backstrom, Boyd, Burakovsky, Connolly, Dowd, Eller, Jaskin, Kuznetsov, Oshie, Ovechkin, Smith-Pelly, Stephenson, Vrana, Wilson, Bowey, Carlson, Djoos, Kempny, Lewington, Niskanen, Orlov, Orpik, Siegenthaler, Copley, Holtby";
	}
	
	//getters
	public String getRoster2013(){
		return roster2013;	
	}
	
	public String getRoster2014(){
		return roster2014;	
	}
	
	public String getRoster2015(){
		return roster2015;	
	}
	
	public String getRoster2016(){
		return roster2016;	
	}
	
	public String getRoster2017(){
		return roster2017;	
	}
	
	public String getRoster2018(){
		return roster2018;	
	}
	
	//utility methods
	public TreeMap<String, Integer> playerFrequencyMap(){
		String masterRoster = roster2013 + ", " + roster2014 + ", " + roster2015 + ", " + roster2016 + ", " + roster2017 + ", " + roster2018 + ", ";
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		String[] players = masterRoster.split(", "); 
		for (int i = 0; i < players.length; i++) {
			String key = players[i].toLowerCase();
			if (key.length() > 0) {
				if (map.get(key) == null) {
					map.put(key, 1);
				} else {
					int value = map.get(key).intValue();
					value++;
					map.put(key, value);
				}
			}
		}
		return map;
	}
	
	public void printPlayerFreqMap(TreeMap<String, Integer> map){
		System.out.println("SINCE THE 2013-2014 REGULAR SEASON...");
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			String key = entry.getKey();
			if(value > 1){
				System.out.println(key.toUpperCase() + " has played " + value + " seasons with the Washington Capitals.");
			}
			else{
				System.out.println(key.toUpperCase() + " has played " + value + " season with the Washington Capitals.");
			}
		}
	}
	
	//main method
	public static void main(String[] args) {
		PlayerRepeats pr = new PlayerRepeats();
		pr.printPlayerFreqMap(pr.playerFrequencyMap());
	}
}