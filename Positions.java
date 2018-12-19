class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private int jerseyNumber;
	private int gamesPlayed;
	
	//constructor
	public HockeyPlayer(String lastName, String position, int jerseyNumber, int gamesPlayed){
		this.lastName = lastName;
		this.position = position;
		this.jerseyNumber = jerseyNumber;
		this.gamesPlayed = gamesPlayed;
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
	
	public int getGamesPlayed(){
		return gamesPlayed;	
	}
	
	//override toString()
	@Override
	public String toString(){
		return lastName + " | #" + jerseyNumber + " | " + gamesPlayed + " games played ";	
	}
	
}

public enum Positions{
	GOALIE(new HockeyPlayer("Copley", "Goalie", 1, 11), new HockeyPlayer("Holtby", "Goalie", 70, 23)),
	
	DEFENSE(new HockeyPlayer("Orlov", "Defense", 9, 32), new HockeyPlayer("Bowey", "Defense", 22, 23), 
		new HockeyPlayer("Carlson", "Defense", 74, 31), new HockeyPlayer("Djoos", "Defense", 29, 28), 
		new HockeyPlayer ("Kempny", "Defense", 6, 29), new HockeyPlayer("Lewington", "Defense", 78, 0),
		new HockeyPlayer("Niskanen", "Defense", 2, 32), new HockeyPlayer("Orpik", "Defense", 44, 10), new HockeyPlayer("Siegenthaler", "Defense", 34, 7)),
	
	FORWARDC(new HockeyPlayer("Backstrom", "Forward, C", 19, 32), new HockeyPlayer("Kuznetsov", "Forrward, C", 92, 26), 
		new HockeyPlayer("Boyd", "Forward, C", 72, 16), new HockeyPlayer("Dowd", "Forward, C", 26, 28), new HockeyPlayer("Eller", "Forward, C", 20, 32), new HockeyPlayer("Stephenson", "Forward, C", 18, 31)),
	
	FORWARDLW(new HockeyPlayer("Burakovsky", "Forward, LW", 65, 29), new HockeyPlayer("Ovechkin", "Forward, LW", 8, 32), new HockeyPlayer("Vrana", "Forward, LW", 13, 32)), 
	
	FORWARDRW(new HockeyPlayer("Connolly", "Forward, RW", 10, 32), new HockeyPlayer("Oshie", "Forward, RW", 77, 21), new HockeyPlayer("Wilson", "Forward, RW", 43, 13),
		new HockeyPlayer("Jaskin", "Forward, RW", 23, 25), new HockeyPlayer("Smith-Pelly", "Forward, RW", 25, 32));
	
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
	
	//main method
	public static void main(String... args){
		System.out.println("GOALIES: ");
		Positions.GOALIE.printPositionRoster();
		System.out.println("\nDEFENSE: ");
		Positions.DEFENSE.printPositionRoster();
		System.out.println("\nFORWARDS: " );
		System.out.println("Centers: ");
		Positions.FORWARDC.printPositionRoster();
		System.out.println("\nRight Wingers: ");
		Positions.FORWARDRW.printPositionRoster();
		System.out.println("\nLeft Wingers: ");
		Positions.FORWARDLW.printPositionRoster();
	}
}