import java.text.*;

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
class Defense extends HockeyPlayer{
	//constructor
	public Defense(String lastName, int jerseyNumber){
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		position = "Defense";
	}
}

//****************************************************
class DefenseStats extends Defense implements SkaterCalc{
	//fields
	private int gamesPlayed;
	private int goals;
	private int assists;
	private int shots;
	private CalcDefenseStats statsCalc = new CalcDefenseStats();
	
	//constructor
	public DefenseStats(HockeyPlayer hp, int gamesPlayed, int goals, int assists, int shots){
		super(hp.getLastName(), hp.getJerseyNumber());
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
	private class CalcDefenseStats{
		
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
class Forward extends HockeyPlayer{
	//constructor
	public Forward(String lastName, int jerseyNumber){
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		position = "Forward";
	}
}

//****************************************************
class ForwardStats extends Forward implements SkaterCalc{
	//fields
	private int gamesPlayed;
	private int goals;
	private int assists;
	private int shots;
	private CalcForwardStats statsCalc = new CalcForwardStats();
	
	//constructor
	public ForwardStats(HockeyPlayer hp, int gamesPlayed, int goals, int assists, int shots){
		super(hp.getLastName(), hp.getJerseyNumber());
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
	private class CalcForwardStats{
		
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
enum Positions{
	//gamesPlayed, wins, shotsAg, goalsAg
	GOALIE(new GoalieStats(new Goalie("Copley", 1), 11, 7, 305, 30), (new GoalieStats(new Goalie("Holtby", 70), 24, 13, 738, 66))),
	
	//gamesPlayed, goals, assists, shots
	DEFENSE(new DefenseStats(new Defense("Orlov",  9), 33, 2, 10, 42), new DefenseStats(new Defense("Bowey", 22), 24, 0, 5, 22), 
		new DefenseStats(new Defense("Carlson", 74), 32, 5, 30, 81), new DefenseStats(new Defense("Djoos", 29), 28, 0, 4, 18), 
		new DefenseStats(new Defense("Kempny", 6), 30, 2, 8, 47), new DefenseStats(new Defense("Lewington", 78), 0, 0, 0, 0),
		new DefenseStats(new Defense("Niskanen", 2), 33, 4, 10, 63), new DefenseStats(new Defense("Orpik", 44), 10, 1, 1, 12), 
		new DefenseStats(new Defense("Siegenthaler", 34), 8, 0, 1, 3)),
	
	FORWARD(new ForwardStats(new Forward("Backstrom", 19), 33, 10, 30, 64), new ForwardStats(new Forward("Kuznetsov", 92), 27, 7, 24, 76), 
		new ForwardStats(new Forward("Boyd", 72), 17, 3, 7, 15), new ForwardStats(new Forward("Dowd", 26), 29, 4, 8, 19), 
		new ForwardStats(new Forward("Eller", 20), 33, 5, 10, 66), new ForwardStats(new Forward("Stephenson", 18), 31, 2, 4, 20), 
		new ForwardStats(new Forward("Burakovsky", 65), 29, 5, 3, 35), new ForwardStats(new Forward("Ovechkin", 8), 33, 29, 14, 134), 
		new ForwardStats(new Forward("Vrana", 13), 33, 10, 9, 62), new ForwardStats(new Forward("Connolly", 10), 33, 7, 13, 60), 
		new ForwardStats(new Forward("Oshie", 77), 22, 10, 5, 49), new ForwardStats(new Forward("Wilson", 43), 14, 9, 7, 32),
		new ForwardStats(new Forward("Jaskin", 23), 26, 1, 6, 27), new ForwardStats(new Forward("Smith-Pelly", 25), 33, 4, 3, 36));
	
	//field
	private HockeyPlayer[] positionRoster;
	
	//constructor
	private Positions(HockeyPlayer... positionRoster){
		this.positionRoster = positionRoster;
	}
	
	//utility method
	public void printPositionRoster(){
		for(HockeyPlayer h : positionRoster)
		System.out.println(h);
	}
}

//****************************************************
public class ExtendsImplements{
	public static void main(String... args){
		System.out.println("GOALIES: ");
		Positions.GOALIE.printPositionRoster();
		System.out.println("\nDEFENSE: ");
		Positions.DEFENSE.printPositionRoster();
		System.out.println("\nFORWARDS: " );
		Positions.FORWARD.printPositionRoster();
	}
}