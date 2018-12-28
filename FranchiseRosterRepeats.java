import java.util.*;
import java.io.*;

public class FranchiseRosterRepeats{
	//fields
	private TreeMap<Integer, String> map2013;
	private TreeMap<Integer, String> map2014;
	private TreeMap<Integer, String> map2015;
	private TreeMap<Integer, String> map2016;
	private TreeMap<Integer, String> map2017;
	private TreeMap<Integer, String> map2018;
	private Set<String> franchiseRoster;
	private ArrayList<TreeMap<Integer, String>> avaRosterMaps;
	
	//constructor
	public FranchiseRosterRepeats(){
		setMap2013();
		setMap2014();
		setMap2015();
		setMap2016();
		setMap2017();
		setMap2018();
		setFranchiseRoster();
		setAvaRosterMaps();
	}
	
	//setters
	public void setMap2013(){
		map2013 = new TreeMap<>();
		Integer key = 2013;
		String roster = "Backstrom, Beagle, Brouwer, Brown, Chimera, Deschamps, Erat, Fehr, Grabovski, Johansson, Kuznetsov, Laich, Latta, LeBlanc, Ovechkin, Penner, Stoa, Volpatti, Ward, Wellman, Wilson, Alzner, Brouillette, Carlson, Carrick, Erskine, Green, Hillen, Oleksy, Orlov, Schilling, Schmidt, Strachan, Urbom, Wey, Grubauer, Halak, Holtby, Neuvirth";
		map2013.put(key, roster);
	}
	
	public void setMap2014(){
		map2014 = new TreeMap<>();	
		Integer key = 2014;
		String roster = "Backstrom, Beagle, Brouwer, Brown, Burakovsky, Chimera, Conner, Fehr, Galiev, Glencross, Johansson, Kuznetsov, Laich, Latta, O'Brien, Ovechkin, Volpatti, Ward, Wilson, Alzner, Carlson, Gleason, Green, Hillen, Niskanen, Oleksy, Orpik, Schilling, Schmidt, Grubauer, Holtby, Peters";
		map2014.put(key, roster);
	}
	
	public void setMap2015(){
		map2015 = new TreeMap<>();
		Integer key = 2015;
		String roster = "Backstrom, Beagle, Brown, Burakovsky, Carey, Chimera, Collins, Galiev, Johansson, Kuznetsov, Laich, Latta, Oshie, Ovechkin, Richards, Sill, Stephenson, Williams, Wilson, Winnik, Alzner, Carlson, Carrick, Chorney, Ness, Niskanen, Orlov, Orpik, Schmidt, Stanton, Weber, Grubauer, Holtby";
		map2015.put(key, roster);
	}
	
	public void setMap2016(){
		map2016 = new TreeMap<>();
		Integer key = 2016;
		String roster = "Backstrom, Barber, Beagle, Burakovsky, Carey, Connolly, Eller, Johansson, Kuznetsov, Mitchell, O'Brien, Oshie, Ovechkin, Sanford, Stephenson, Vrana, Williams, Wilson, Winnik, Alzner, Carlson, Chorney, Ness, Niskanen, Orlov, Orpik, Schmidt, Shattenkirk, Grubauer, Holtby";
		map2016.put(key, roster);
	}
	
	public void setMap2017(){
		map2017 = new TreeMap<>();
		Integer key = 2017;
		String roster = "Backstrom, Beagle, Boyd, Burakovsky, Chiasson, Connolly, Eller, Gersich, Graovac, Kuznetsov, O'Brien, Oshie, Ovechkin, Peluso, Smith-Pelly, Stephenson, Vrana, Walker, Wilson, Bowey, Carlson, Chorney, Djoos, Jerabek, Kempny, Ness, Niskanen, Orlov, Orpik, Grubauer, Holtby";
		map2017.put(key, roster);
	}
	
	public void setMap2018(){
		map2018 = new TreeMap<>();
		Integer key = 2018;
		String roster = "Backstrom, Boyd, Burakovsky, Connolly, Dowd, Eller, Jaskin, Kuznetsov, Oshie, Ovechkin, Smith-Pelly, Stephenson, Vrana, Wilson, Bowey, Carlson, Djoos, Kempny, Lewington, Niskanen, Orlov, Orpik, Siegenthaler, Copley, Holtby";
		map2018.put(key, roster);
	}
	
	public void setFranchiseRoster(){
		franchiseRoster = new TreeSet<String>();
		franchiseRoster.addAll(getSeasonRoster(getMap2013()));
		franchiseRoster.addAll(getSeasonRoster(getMap2014()));
		franchiseRoster.addAll(getSeasonRoster(getMap2015()));
		franchiseRoster.addAll(getSeasonRoster(getMap2016()));
		franchiseRoster.addAll(getSeasonRoster(getMap2017()));
		franchiseRoster.addAll(getSeasonRoster(getMap2018()));
	}
	
	public void setAvaRosterMaps(){
		avaRosterMaps = new ArrayList<>();
		avaRosterMaps.add(getMap2013());
		avaRosterMaps.add(getMap2014());
		avaRosterMaps.add(getMap2015());
		avaRosterMaps.add(getMap2016());
		avaRosterMaps.add(getMap2017());
		avaRosterMaps.add(getMap2018());
	}
	
	//getters
	public TreeMap<Integer, String> getMap2013(){
		return map2013;	
	}
	
	public TreeMap<Integer, String> getMap2014(){
		return map2014;	
	}
	
	public TreeMap<Integer, String> getMap2015(){
		return map2015;	
	}
	
	public TreeMap<Integer, String> getMap2016(){
		return map2016;	
	}

	public TreeMap<Integer, String> getMap2017(){
		return map2017;	
	}
	
	public TreeMap<Integer, String> getMap2018(){
		return map2018;	
	}
	
	public Set<String> getFranchiseRoster(){
		return franchiseRoster;	
	}
	
	public ArrayList<TreeMap<Integer, String>> getAvaRosterMaps(){
		return avaRosterMaps;
	}	
	
	//utility methods
	public ArrayList<String> getSeasonRoster(TreeMap<Integer, String> seasonRoster){
		ArrayList<String> vals = new ArrayList<>();
		vals.addAll(seasonRoster.values());
		String roster = vals.get(0);
		String[] rosterArray = roster.split(", ");
		vals.clear();
		for(int i = 0; i< rosterArray.length; i++){
			vals.add(rosterArray[i]);	
		}
		return vals;
	}

	public int playerFrequency(String player){
		int countSeasons = 0;
		TreeMap<String, String> map = new TreeMap<>();
		for(TreeMap<Integer, String> t : getAvaRosterMaps()){
			ArrayList<String> roster = new ArrayList<>(getSeasonRoster(t));
			if(roster.contains(player)){
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
					System.out.println(fRoster.get(userChoice-1) + " has played " + seasonsPlayed + " seasons with the CAPS since 2013.");
				}
			}
			catch(Exception e){
				System.out.println("Exception: " + e + ".");
			}
		}
	
	//main method
	public static void main(String[] args) {
		FranchiseRosterRepeats frr = new FranchiseRosterRepeats();
		frr.mainMenu();
	}
}