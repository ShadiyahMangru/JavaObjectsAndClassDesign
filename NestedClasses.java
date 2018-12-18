class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private int jerseyNumber;

	//constructor
	public HockeyPlayer(String lastName, String position, int jerseyNumber){
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		this.position = position;
	}
	
	//getters
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

class Goalie extends HockeyPlayer{
	//fields
	private int wins;
	private int shotsAg;
	private int goalsAg;
	private CalcGoalieStats statsCalc = new CalcGoalieStats();
	
	//constructor
	public Goalie(HockeyPlayer hp, int wins, int shotsAg, int goalsAg){
		super(hp.getLastName(), "Goalie", hp.getJerseyNumber());
		this.wins = wins;
		this.shotsAg = shotsAg;
		this.goalsAg = goalsAg;
	}
	
	//setters
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
		return super.toString() + " | " + wins + " wins | " + getSavePercentage() + " save percentage"; 	
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

class Defense extends HockeyPlayer{
	//fields
	private int goals;
	private int assists;
	private int shots;
	private CalcDefenseStats statsCalc = new CalcDefenseStats();
	
	//constructor
	public Defense(HockeyPlayer hp, int goals, int assists, int shots){
		super(hp.getLastName(), "Defense", hp.getJerseyNumber());
		this.goals = goals;
		this.assists = assists;
		this.shots = shots;
	}
	
	//setters
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
		return super.toString() + " | " + getPoints() + " points | " + getShootingPercentage() + " shooting percentage"; 	
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

class Forward extends HockeyPlayer{
	//fields
	private int goals;
	private int assists;
	private int shots;
	private CalcForwardStats statsCalc = new CalcForwardStats();
	
	//constructor
	public Forward(HockeyPlayer hp, int goals, int assists, int shots){
		super(hp.getLastName(), "Forward", hp.getJerseyNumber());
		this.goals = goals;
		this.assists = assists;
		this.shots = shots;
	}
	
	//setters
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
		return super.toString() + " | " + getPoints() + " points | " + getShootingPercentage() + " shooting percentage"; 	
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

public class NestedClasses{

	public static void main(String... args){
		Forward backstrom = new Forward(new HockeyPlayer("Backstrom", "Forward", 19), 10, 30, 64);
		System.out.println(backstrom);
		
		System.out.println();
		
		Defense orlov = new Defense(new HockeyPlayer("Orlov", "Defense", 9), 2, 10 ,40);
		System.out.println(orlov);
		
		System.out.println();
		
		Goalie copley = new Goalie(new HockeyPlayer("Copley", "Goalie", 1), 7, 305, 30);
		System.out.println(copley);
	}
}