import java.util.*;
import java.io.*;

public class FranchiseRosterRepeatsV2{
	//fields
	private static final Integer key2013 = 2013;
	private static final String roster2013 = "Backstrom, Beagle, Brouwer, Brown, Chimera, Deschamps, Erat, Fehr, Grabovski, Johansson, Kuznetsov, Laich, Latta, LeBlanc, Ovechkin, Penner, Stoa, Volpatti, Ward, Wellman, Wilson, Alzner, Brouillette, Carlson, Carrick, Erskine, Green, Hillen, Oleksy, Orlov, Schilling, Schmidt, Strachan, Urbom, Wey, Grubauer, Halak, Holtby, Neuvirth";
		
	private static final Integer key2014 = 2014;
	private static final String roster2014 = "Backstrom, Beagle, Brouwer, Brown, Burakovsky, Chimera, Conner, Fehr, Galiev, Glencross, Johansson, Kuznetsov, Laich, Latta, O'Brien, Ovechkin, Volpatti, Ward, Wilson, Alzner, Carlson, Gleason, Green, Hillen, Niskanen, Oleksy, Orpik, Schilling, Schmidt, Grubauer, Holtby, Peters";
		
	private static final Integer key2015 = 2015;
	private static final String roster2015 = "Backstrom, Beagle, Brown, Burakovsky, Carey, Chimera, Collins, Galiev, Johansson, Kuznetsov, Laich, Latta, Oshie, Ovechkin, Richards, Sill, Stephenson, Williams, Wilson, Winnik, Alzner, Carlson, Carrick, Chorney, Ness, Niskanen, Orlov, Orpik, Schmidt, Stanton, Weber, Grubauer, Holtby";
		
	private static final Integer key2016 = 2016;
	private static final String roster2016 = "Backstrom, Barber, Beagle, Burakovsky, Carey, Connolly, Eller, Johansson, Kuznetsov, Mitchell, O'Brien, Oshie, Ovechkin, Sanford, Stephenson, Vrana, Williams, Wilson, Winnik, Alzner, Carlson, Chorney, Ness, Niskanen, Orlov, Orpik, Schmidt, Shattenkirk, Grubauer, Holtby";
		
	private static final Integer key2017 = 2017;
	private static final String roster2017 = "Backstrom, Beagle, Boyd, Burakovsky, Chiasson, Connolly, Eller, Gersich, Graovac, Kuznetsov, O'Brien, Oshie, Ovechkin, Peluso, Smith-Pelly, Stephenson, Vrana, Walker, Wilson, Bowey, Carlson, Chorney, Djoos, Jerabek, Kempny, Ness, Niskanen, Orlov, Orpik, Grubauer, Holtby";
	
	private static final Integer key2018 = 2018;
	private static final String roster2018 = "Backstrom, Boyd, Burakovsky, Connolly, Dowd, Eller, Jaskin, Kuznetsov, Oshie, Ovechkin, Smith-Pelly, Stephenson, Vrana, Wilson, Bowey, Carlson, Djoos, Kempny, Lewington, Niskanen, Orlov, Orpik, Siegenthaler, Copley, Holtby";
		
	private TreeMap<Integer, String> rosterMaps;
	private Set<String> franchiseRoster;
	
	//constructor
	public FranchiseRosterRepeatsV2(){
		setRosterMaps();
		setFranchiseRoster();
	}
	
	//setters
	public void setRosterMaps(){
		rosterMaps= new TreeMap<>();
		rosterMaps.put(key2013, roster2013);
		rosterMaps.put(key2014, roster2014);
		rosterMaps.put(key2015, roster2015);
		rosterMaps.put(key2016, roster2016);
		rosterMaps.put(key2017, roster2017);	
		rosterMaps.put(key2018, roster2018);
	}
	
	public void setFranchiseRoster(){
		franchiseRoster = new TreeSet<String>();
		Object[] seasons = rosterMaps.keySet().toArray();
		String roster;
		String[] rosterArray;
		for(Object year : seasons){
			roster = rosterMaps.get(year);
			rosterArray = roster.split(", ");
			for(String hp : rosterArray){
				franchiseRoster.add(hp);
			}
		}
	}
	
	//getters
	public TreeMap<Integer, String> getRosterMaps(){
		return rosterMaps;	
	}
	
	public Set<String> getFranchiseRoster(){
		return franchiseRoster;	
	}
	
	//utility methods
	public int playerFrequency(String player){
		int countSeasons = 0;
		Object[] seasons = rosterMaps.keySet().toArray();
		for(Object year : seasons){
			if(rosterMaps.get(year).contains(player)){
				countSeasons++;		
			}
		}
		return countSeasons;
	}
	
	public void mainMenu(){
		System.out.println("******************************************************************");
		System.out.println("FRANCHISE ROSTER HISTORY WIZARD");
		System.out.println("\n\tMAIN MENU:\n");
		System.out.println("\tSelect a Player to Determine Number of Seasons with CAPS since 2013-2014 Regular Season");
		ArrayList<Object> fRoster = new ArrayList<>();
		fRoster.addAll(getFranchiseRoster());
		Iterator iterator = getFranchiseRoster().iterator(); 
		int counter = 1;
		for(Object o : fRoster){
			System.out.println("\t" + counter + ".) " + o);
			counter++;
		}
		System.out.println("\n\n\t" + counter + ".) EXIT\n");
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter number of selection: ");
			int userChoice = Integer.parseInt(reader.readLine());
			if(userChoice == fRoster.size() + 1){
				System.out.println("You selected: EXIT");
				System.exit(0);
			}
			else if(userChoice <= fRoster.size()){
				System.out.println("You selected: " + fRoster.get(userChoice-1));
				int seasonsPlayed = playerFrequency((String)fRoster.get(userChoice-1));
				System.out.println(fRoster.get(userChoice-1) + " has played " + seasonsPlayed + " season(s) with the CAPS since 2013.");
			}
		}
		catch(Exception e){
			System.out.println("Exception: " + e + ".");
		}
	}
	
	//main method
	public static void main(String[] args) {
		FranchiseRosterRepeatsV2 frr = new FranchiseRosterRepeatsV2();
		frr.mainMenu();
	}
}