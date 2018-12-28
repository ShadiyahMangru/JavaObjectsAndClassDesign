import java.util.*;
import java.io.*;

public class FranchiseRoster{
	//fields
	private TreeMap<Integer, String> map2013;
	private TreeMap<Integer, String> map2014;
	private TreeMap<Integer, String> map2015;
	private TreeMap<Integer, String> map2016;
	private TreeMap<Integer, String> map2017;
	private TreeMap<Integer, String> map2018;
	private Set<String> franchiseRoster;
	
	//constructor
	public FranchiseRoster(){
		setMap2013();
		setMap2014();
		setMap2015();
		setMap2016();
		setMap2017();
		setMap2018();
		setFranchiseRoster();
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

	public void mainMenu(){
			System.out.println("******************************************************************");
			System.out.println("FRANCHISE ROSTER HISTORY WIZARD");
			System.out.println("\n\tMAIN MENU:\n\t1.) Franchise Roster (since 2013) \n\t2.) 2013 Roster \n\t3.) 2014 Roster \n\t4.) 2015 Roster \n\t5.) 2016 Roster \n\t6.) 2017 Roster \n\t7.) 2018 Roster \n\n\t8.) EXIT\n");
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter selection: ");
				int userChoice = Integer.parseInt(reader.readLine());	
					switch(userChoice){
						case 1: System.out.print("You selected: Franchise Roster (since 2013)!\n");
							Iterator iterator = getFranchiseRoster().iterator(); 
							while (iterator.hasNext()) {
								System.out.println(iterator.next());  
							}
							break;
						case 2: System.out.println("You selected: 2013 Roster!");
							for(String name : getSeasonRoster(getMap2013())){
								System.out.println(name);	
							}
							break;
						case 3: System.out.println("You selected: 2014 Roster!");
							for(String name : getSeasonRoster(getMap2014())){
								System.out.println(name);	
							}
							break;	
						case 4: System.out.println("You selected: 2015 Roster!");
							for(String name : getSeasonRoster(getMap2015())){
								System.out.println(name);	
							}
							break;
						case 5: System.out.println("You selected: 2016 Roster!");
							for(String name : getSeasonRoster(getMap2016())){
								System.out.println(name);	
							}
							break;
						case 6: System.out.println("You selected: 2017 Roster!");
							for(String name : getSeasonRoster(getMap2017())){
								System.out.println(name);	
							}
							break;
						case 7: System.out.println("You selected: 2018 Roster!");
							for(String name : getSeasonRoster(getMap2018())){
								System.out.println(name);	
							}
							break;
						case 8: System.out.println("You selected: EXIT");
							System.exit(0);
							break;
						default: mainMenu(); //reload menu bc invalid selection
							break;	
					}
			}
			catch(Exception e){
				System.out.println("Exception: " + e + ".");
			}
			mainMenu();
		}
	
	//main method
	public static void main(String[] args) {
		FranchiseRoster fr = new FranchiseRoster();
		fr.mainMenu();
	}
}