import java.text.*;
import java.util.*;
import java.time.*;

interface SkaterCalc{
	public int getGamesPlayed();
	public int getGoals();
	public int getAssists();
	public int getPoints();
	public int getShots();
	public double getShootingPercentage();
}

//****************************************************
interface GoalieCalc{
	public int getGamesPlayed();
	public int getWins();
	public int getShotsAg();
	public int getGoalsAg();
	public int getSaves();
	public double getSavePercentage();
}

//****************************************************
abstract class HockeyPlayer{
	//fields
	public String lastName;
	public String position;
	public int jerseyNumber;
	
	//methods
	public String getLastName(){
		return lastName;	
	}
	public String getPosition(){
		return position;	
	}
	public int getJerseyNumber(){
		return jerseyNumber;	
	}
	
	//override toString()
	@Override
	public String toString(){
		return lastName + " | " + position + " | #" + jerseyNumber;	
	}
}

//****************************************************
class Skater extends HockeyPlayer{
	//fields
	private boolean isDefense;
	
	//constructor
	public Skater(String lastName, int jerseyNumber, boolean isDefense){
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		this.isDefense = isDefense;
		if(isDefense){
			this.position = "Defense";
		}
		else{
			this.position = "Forward";	
		}
	}
	
	//getter
	public boolean getIsDefense(){
		return isDefense;	
	}
}

//****************************************************
class SkaterStats extends Skater implements SkaterCalc{
	//fields
	private int gamesPlayed;
	private int goals;
	private int assists;
	private int shots;
	private CalcSkaterStats statsCalc = new CalcSkaterStats();
	
	//constructor
	public SkaterStats(Skater s, int gamesPlayed, int goals, int assists, int shots){
		super(s.getLastName(), s.getJerseyNumber(), s.getIsDefense());
		this.gamesPlayed = gamesPlayed;
		this.goals = goals;
		this.assists = assists;
		this.shots = shots;
	}
	
	//setters
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;	
	}
	
	public void setGoals(int goals){
		this.goals = goals;	
	}
	
	public void setAssists(int assists){
		this.assists = assists;	
	}
	
	public void setShots(int shots){
		this.shots = shots;	
	}
	
	//getters
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	public int getGoals(){
		return goals;	
	}
	
	public int getAssists(){
		return assists;	
	}	
	
	public int getShots(){
		return shots;	
	}
	
	public int getPoints(){
		return statsCalc.calcPoints(goals, assists);		
	}
	
	public double getShootingPercentage(){
		return statsCalc.calcShootingPercentage(goals, shots);	
	}
	
	//override toString()
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.0000");
		return super.toString() + " | " + getPoints() + " points | " + df.format(getShootingPercentage()) + " shooting percentage"; 	
	}
	
	//nested class
	private class CalcSkaterStats{
		protected int calcPoints(int goals, int assists){
			return goals + assists;	
		}
		
		protected double calcShootingPercentage(int goals, int shots){
			if(shots == 0){
				return 0;	
			}
			return ((double)goals/(double)shots)*100.00;
		}
	}
}

//****************************************************
class Goalie extends HockeyPlayer{
	//constructor
	public Goalie(String lastName, int jerseyNumber){
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		position = "Goalie";
	}
}

//****************************************************
class GoalieStats extends Goalie implements GoalieCalc{
	//fields
	private int gamesPlayed;
	private int wins;
	private int shotsAg;
	private int goalsAg;
	private CalcGoalieStats statsCalc = new CalcGoalieStats();
	
	//constructor
	public GoalieStats(HockeyPlayer hp, int gamesPlayed, int wins, int shotsAg, int goalsAg){
		super(hp.getLastName(), hp.getJerseyNumber());
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
		this.shotsAg = shotsAg;
		this.goalsAg = goalsAg;
	}
	
	//setters
	public void setGamesPlayed(int gamesPlayed){
		this.gamesPlayed = gamesPlayed;	
	}
	
	public void setWins(int wins){
		this.wins = wins;	
	}
	
	public void setShotsAg(int shotsAg){
		this.shotsAg = shotsAg;	
	}
	
	public void setGoalsAg(int goalsAg){
		this.goalsAg = goalsAg;	
	}
	
	//getters
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	public int getWins(){
		return wins;	
	}
	
	public int getShotsAg(){
		return shotsAg;	
	}
	
	public int getGoalsAg(){
		return goalsAg;	
	}
	
	public int getSaves(){
		return statsCalc.calcSaves(shotsAg, goalsAg);
	}
	
	public double getSavePercentage(){
		return statsCalc.calcSavePercentage(shotsAg, goalsAg);	
	}
	
	//override toString()
	@Override
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.0000");
		return super.toString() + " | " + wins + " wins | " + df.format(getSavePercentage()) + " save percentage"; 	
	}
	
	//nested class
	private class CalcGoalieStats{
		
		protected int calcSaves(int shotsAg, int goalsAg){
			return shotsAg - goalsAg;	
		}
		
		protected double calcSavePercentage(int shotsAg, int goalsAg){
			if(shotsAg == 0){
				return 0;	
			}
			int saves = calcSaves(shotsAg, goalsAg);
				return ((double)saves / (double)shotsAg)*100.00;
		}
		
	}
}

//****************************************************
class Roster<T> {
	//fields
	private T player;

	//constructor
	public Roster(T player){
		this.player = player;	
	}
	
	//setter
	public void setPlayer(T player) {
		this.player = player;
	}
	
	//getter
	public T getPlayer() {
		return player;
	}   
}

//****************************************************
interface Players{
	//a repository for current and former Washington Capitals players
	public static final HockeyPlayer copley = new Goalie("Copley", 1);
	public static final HockeyPlayer holtby = new Goalie("Holtby", 70);	
	public static final HockeyPlayer grubauer = new Goalie("Grubauer", 31);
	
	public static final HockeyPlayer orlov = new Skater("Orlov", 9, true);
	public static final Skater carlson = new Skater("Carlson", 74, true);
	public static final Skater kempny = new Skater("Kempny", 6, true);
	public static final Skater niskanen = new Skater("Niskanen", 9, true);
	public static final Skater siegenthaler = new Skater("Siegenthaler", 9, true);
	public static final Skater bowey = new Skater("Bowey", 22, true);
	public static final Skater djoos = new Skater("Djoos", 29, true);
	public static final Skater lewington = new Skater("Lewington", 78, true);
	public static final Skater orpik = new Skater("Orpik", 44, true);
	public static final Skater jerabek = new Skater("Jerabek", 28, true);
		
	public static final Skater backstrom = new Skater("Backstrom", 19, false);
	public static final Skater boyd = new Skater("Boyd", 72, false);
	public static final Skater eller = new Skater("Eller", 20, false);
	public static final Skater burakovsky = new Skater("Burakovsky", 65, false);
	public static final Skater vrana = new Skater("Vrana", 13, false);
	public static final Skater oshie = new Skater("Oshie", 77, false);
	public static final Skater jaskin = new Skater("Jaskin", 23, false);
	public static final Skater kuznetsov = new Skater("Kuznetsov", 92, false);
	public static final Skater dowd = new Skater("Dowd", 26, false);
	public static final Skater stephenson = new Skater("Stephenson", 18, false);
	public static final Skater ovechkin = new Skater("Ovechkin", 8, false);
	public static final Skater connolly = new Skater("Connolly", 10, false);
	public static final Skater wilson = new Skater("Wilson", 43, false);
	public static final Skater smithPelly = new Skater("Smith-Pelly", 25, false);	
	public static final Skater beagle = new Skater("Beagle", 83, false);
	public static final Skater chiasson = new Skater("Chiasson", 39, false);
	public static final Skater walker = new Skater("Walker", 79, false);
	public static final Skater gersich = new Skater("Gersich", 63, false);
	
}

//****************************************************
class SeasonRoster{
		//fields
		private ArrayList<Roster> playoffs2018;
		private ArrayList<Roster> reg2018;
		
		//constructor
		public SeasonRoster(){
			setPlayoffs2018();	
			setReg2018();
		}
		
		//setters
		public void setPlayoffs2018(){
			playoffs2018 = new ArrayList<>();
			//gamesPlayed, wins, shotsAg, goalsAg
			Roster<GoalieStats> holtbyP2018 = new Roster<>(new GoalieStats(Players.holtby, 23, 16, 639, 50));
			Roster<GoalieStats> grubauerP2018 = new Roster<>(new GoalieStats(Players.grubauer, 2, 0, 49, 8));

			//gamesPlayed, goals, assists, shots
			Roster<SkaterStats> orlovP2018 = new Roster<>(new SkaterStats((Skater)Players.orlov, 24, 2, 6, 48));
			Roster<SkaterStats> carlsonP2018 = new Roster<>(new SkaterStats(Players.carlson, 24, 5, 15, 80));
			Roster<SkaterStats> kempnyP2018 = new Roster<>(new SkaterStats(Players.kempny, 24, 2, 3, 39));
			Roster<SkaterStats> niskanenP2018 = new Roster<>(new SkaterStats(Players.niskanen, 24, 1, 8, 32));
			Roster<SkaterStats> djoosP2018 = new Roster<>(new SkaterStats(Players.djoos, 22, 0, 1, 16));
			Roster<SkaterStats> orpikP2018 = new Roster<>(new SkaterStats(Players.orpik, 24, 1, 4, 17));
			Roster<SkaterStats> jerabekP2018 = new Roster<>(new SkaterStats(Players.jerabek, 2, 0, 1, 3));
			
			Roster<SkaterStats> backstromP2018 = new Roster<>(new SkaterStats(Players.backstrom, 20, 5, 18, 36));
			Roster<SkaterStats> boydP2018 = new Roster<>(new SkaterStats(Players.boyd, 1, 0, 0, 1));
			Roster<SkaterStats> ellerP2018 = new Roster<>(new SkaterStats(Players.eller, 24, 7, 11, 52));
			Roster<SkaterStats> burakovskyP2018 = new Roster<>(new SkaterStats(Players.burakovsky, 13, 2, 4, 12));
			Roster<SkaterStats> vranaP2018 = new Roster<>(new SkaterStats(Players.vrana, 23, 3, 5, 39));
			Roster<SkaterStats> oshieP2018 = new Roster<>(new SkaterStats(Players.oshie, 24, 8, 13, 55));
			Roster<SkaterStats> kuznetsovP2018 = new Roster<>(new SkaterStats(Players.kuznetsov, 24, 12, 20, 89));
			Roster<SkaterStats> stephensonP2018 = new Roster<>(new SkaterStats(Players.stephenson, 24, 2, 5, 19));
			Roster<SkaterStats> ovechkinP2018 = new Roster<>(new SkaterStats(Players.ovechkin, 24, 15, 12, 99));
			Roster<SkaterStats> connollyP2018 = new Roster<>(new SkaterStats(Players.connolly, 24, 6, 3, 32));
			Roster<SkaterStats> wilsonP2018 = new Roster<>(new SkaterStats(Players.wilson, 21, 5, 10, 34));
			Roster<SkaterStats> smithPellyP2018 = new Roster<>(new SkaterStats(Players.smithPelly, 24, 7, 1, 29));
			Roster<SkaterStats> beagleP2018 = new Roster<>(new SkaterStats(Players.beagle, 23, 2, 6, 12));
			Roster<SkaterStats>chiassonP2018 = new Roster<>(new SkaterStats(Players.chiasson, 16, 1, 1, 14));
			Roster<SkaterStats> walkerP2018 = new Roster<>(new SkaterStats(Players.walker, 1, 0, 1, 1));
			Roster<SkaterStats> gersichP2018 = new Roster<>(new SkaterStats(Players.gersich, 2, 0, 0, 2));
			
			playoffs2018.add(holtbyP2018);
			playoffs2018.add(grubauerP2018);
			playoffs2018.add(orlovP2018);
			playoffs2018.add(carlsonP2018);
			playoffs2018.add(kempnyP2018);
			playoffs2018.add(niskanenP2018);
			playoffs2018.add(djoosP2018);
			playoffs2018.add(orpikP2018);
			playoffs2018.add(jerabekP2018);
			playoffs2018.add(backstromP2018);
			playoffs2018.add(boydP2018);
			playoffs2018.add(ellerP2018);
			playoffs2018.add(burakovskyP2018);
			playoffs2018.add(vranaP2018);
			playoffs2018.add(oshieP2018);
			playoffs2018.add(kuznetsovP2018);
			playoffs2018.add(stephensonP2018);
			playoffs2018.add(ovechkinP2018);
			playoffs2018.add(connollyP2018);
			playoffs2018.add(wilsonP2018);
			playoffs2018.add(smithPellyP2018);
			playoffs2018.add(beagleP2018);
			playoffs2018.add(chiassonP2018);
			playoffs2018.add(walkerP2018);
			playoffs2018.add(gersichP2018);
		}
		
		public void setReg2018(){
			reg2018 = new ArrayList<>();
			//gamesPlayed, wins, shotsAg, goalsAg
			Roster<GoalieStats> holtby2018 = new Roster<>(new GoalieStats(Players.holtby, 25, 14, 775, 67));
			Roster<GoalieStats> copley2018 = new Roster<>(new GoalieStats(Players.copley, 12, 8, 340, 30));
			
			//gamesPlayed, goals, assists, shots
			Roster<SkaterStats> orlov2018 = new Roster<>(new SkaterStats((Skater)Players.orlov, 35, 2, 10, 45));
			Roster<SkaterStats> carlson2018 = new Roster<>(new SkaterStats(Players.carlson, 34, 5, 30, 86));
			Roster<SkaterStats> kempny2018 = new Roster<>(new SkaterStats(Players.kempny, 32, 3, 8, 49));
			Roster<SkaterStats> niskanen2018 = new Roster<>(new SkaterStats(Players.niskanen, 35, 5, 10, 65));
			Roster<SkaterStats> siegenthaler2018 = new Roster<>(new SkaterStats(Players.siegenthaler, 10, 0, 2, 4));
			Roster<SkaterStats> bowey2018 = new Roster<>(new SkaterStats(Players.bowey, 25, 0, 5, 23));
			Roster<SkaterStats> djoos2018 = new Roster<>(new SkaterStats(Players.djoos, 28, 0, 4, 18));
			Roster<SkaterStats> lewington2018 = new Roster<>(new SkaterStats(Players.lewington, 1, 0, 0, 1));
			Roster<SkaterStats> orpik2018 = new Roster<>(new SkaterStats(Players.orpik, 10, 1, 1, 12));
			
			Roster<SkaterStats> backstrom2018 = new Roster<>(new SkaterStats(Players.backstrom, 35, 10, 31, 66));
			Roster<SkaterStats> boyd2018 = new Roster<>(new SkaterStats(Players.boyd, 18, 3, 7, 15));
			Roster<SkaterStats> eller2018 = new Roster<>(new SkaterStats(Players.eller, 35, 5, 11, 69));
			Roster<SkaterStats> burakovsky2018 = new Roster<>(new SkaterStats(Players.burakovsky, 31, 5, 3, 39));
			Roster<SkaterStats> vrana2018 = new Roster<>(new SkaterStats(Players.vrana, 35, 11, 9, 70));
			Roster<SkaterStats> oshie2018 = new Roster<>(new SkaterStats(Players.oshie, 24, 10, 5, 51));
			Roster<SkaterStats> jaskin2018 = new Roster<>(new SkaterStats(Players.jaskin, 26, 1, 6, 27));
			Roster<SkaterStats> kuznetsov2018 = new Roster<>(new SkaterStats(Players.kuznetsov, 29, 7, 25, 81));
			Roster<SkaterStats> dowd2018 = new Roster<>(new SkaterStats(Players.dowd, 31, 4, 9, 21));
			Roster<SkaterStats> stephenson2018 = new Roster<>(new SkaterStats(Players.stephenson, 33, 3, 4, 21));
			Roster<SkaterStats> ovechkin2018 = new Roster<>(new SkaterStats(Players.ovechkin, 35, 29, 15, 141));
			Roster<SkaterStats> connolly2018 = new Roster<>(new SkaterStats(Players.connolly, 35, 8, 14, 61));
			Roster<SkaterStats> wilson2018 = new Roster<>(new SkaterStats(Players.wilson, 16, 10, 7, 38));
			Roster<SkaterStats> smithPelly2018 = new Roster<>(new SkaterStats(Players.smithPelly, 34, 4, 3, 37));
	
			reg2018.add(holtby2018);
			reg2018.add(copley2018);
			reg2018.add(orlov2018);
			reg2018.add(carlson2018);
			reg2018.add(kempny2018);
			reg2018.add(niskanen2018);
			reg2018.add(siegenthaler2018);
			reg2018.add(bowey2018);
			reg2018.add(djoos2018);
			reg2018.add(lewington2018);
			reg2018.add(orpik2018);
			reg2018.add(backstrom2018);
			reg2018.add(boyd2018);
			reg2018.add(eller2018);
			reg2018.add(burakovsky2018);
			reg2018.add(vrana2018);
			reg2018.add(oshie2018);
			reg2018.add(jaskin2018);
			reg2018.add(kuznetsov2018);
			reg2018.add(dowd2018);
			reg2018.add(stephenson2018);
			reg2018.add(ovechkin2018);
			reg2018.add(connolly2018);
			reg2018.add(wilson2018);
			reg2018.add(smithPelly2018);
		}
		
		//getters
		public ArrayList<Roster> getPlayoffs2018(){
			return playoffs2018;	
		}
		
		public ArrayList<Roster> getReg2018(){
			return reg2018;	
		}
		
		//utility method
		public void printRoster(ArrayList<Roster> seasonRoster){
			for(Roster r : seasonRoster){
				System.out.println(r.getPlayer());	
			}
		}
}

//****************************************************
public class GenericsV2{
	//main method
	public static void main(String[] args) {
		SeasonRoster sr = new SeasonRoster();
		System.out.println("\t***** 2018 PLAYOFFS STATS *****");
		sr.printRoster(sr.getPlayoffs2018());
		
		LocalDate lastUpdate = LocalDate.of(2018, Month.DECEMBER, 27);
		System.out.println("\n\t***** 2018 - 2019 REGULAR SEASON STATS (Last Updated: " +lastUpdate+ ") *****");
		sr.printRoster(sr.getReg2018());
	}
}