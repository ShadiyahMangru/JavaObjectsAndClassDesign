class HockeyPlayer{
	//fields
	private String lastName;
	private String position;
	private int jerseyNumber;
	
	//constructor
	public HockeyPlayer(String lastName, String position, int jerseyNumber){
		this.lastName = lastName;
		this.position = position;
		this.jerseyNumber = jerseyNumber;
	}
	
	//setters  -- none because this class' fields can only be set by constructor
	
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
		
	//override equals()
	//returns true if two objects are HockeyPlayer objects with same lastName, position and jerseyNumber
	@Override
	public boolean equals (Object o){
		boolean result = false;
		if( (o != null) && (o instanceof HockeyPlayer)){
			HockeyPlayer e = (HockeyPlayer) o;
			if( 	(e.lastName.equals(this.lastName)) &&
				(e.position.equals(this.position)) &&
				(e.jerseyNumber == this.jerseyNumber)){
					result = true;		
			}
		}	
		return result;
	}
	
	//override hashCode()
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 83 * hash + this.lastName.hashCode();
		hash = 83 * hash + this.position.hashCode();
		hash = 83 * hash + jerseyNumber;
		return hash;
	}
}

class Goalie extends HockeyPlayer{
	//field
	private int wins;
	
	//constructor
	public Goalie(HockeyPlayer hp, int wins){
		super(hp.getLastName(), hp.getPosition(), hp.getJerseyNumber());
		this.wins = wins;
	}
	
	//setter
	public void setWins(int wins){
		this.wins = wins;	
	}
	
	//getter
	public int getWins(){
		return wins;	
	}
	
	//override toString()
	@Override
	public String toString(){
		return super.toString() + " | wins: " + wins;	
	}
	
	//override equals()
	//returns true if two objects are Goalie objects with same lastName, position, jerseyNumber, and wins
	@Override
	public boolean equals (Object o){
		boolean result = false;
		if( (o != null) && (o instanceof Goalie)){
			Goalie e = (Goalie) o;
			if( 	(e.getLastName().equals(this.getLastName())) &&
				(e.getPosition().equals(this.getPosition())) &&
				(e.getJerseyNumber() == this.getJerseyNumber()) &&
				(e.wins == this.wins)){
					result = true;		
			}
		}	
		return result;
	}
	
	//override hashCode()
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 83 * hash + this.getLastName().hashCode();
		hash = 83 * hash + this.getPosition().hashCode();
		hash = 83 * hash + getJerseyNumber();
		hash = 83 * hash + wins;
		return hash;
	}
}

class Skater extends HockeyPlayer{
	//field
	private int points;
	
	//constructor
	public Skater(HockeyPlayer hp, int points){
		super(hp.getLastName(), hp.getPosition(), hp.getJerseyNumber());
		this.points = points;
	}
	
	//setter
	public void setPoints(int points){
		this.points = points;	
	}
	
	//getter
	public int getPoints(){
		return points;	
	}
	
	//override toString()
	@Override
	public String toString(){
		return super.toString() + " | points: " + points;	
	}
	
	//override equals()
	//returns true if two objects are Skater objects with same lastName, position, jerseyNumber, and points
	@Override
	public boolean equals (Object o){
		boolean result = false;
		if( (o != null) && (o instanceof Skater)){
			Skater e = (Skater) o;
			if( 	(e.getLastName().equals(this.getLastName())) &&
				(e.getPosition().equals(this.getPosition())) &&
				(e.getJerseyNumber() == this.getJerseyNumber()) &&
				(e.points == this.points)){
					result = true;		
			}
		}	
		return result;
	}
	
	//override hashCode()
	@Override
	public int hashCode(){
		int hash = 7;
		hash = 83 * hash + this.getLastName().hashCode();
		hash = 83 * hash + this.getPosition().hashCode();
		hash = 83 * hash + getJerseyNumber();
		hash = 83 * hash + points;
		return hash;
	}
}

public class MethodOverrides{
	
	public static void main(String... args){
		HockeyPlayer h = new HockeyPlayer("Holtby", "Goalie", 70);
		HockeyPlayer h1 = new HockeyPlayer("Holtby", "Goalie", 70);
		
		HockeyPlayer holtby2017 = new Goalie(new HockeyPlayer("Holtby", "Goalie", 70), 34);
		System.out.println(holtby2017);
		
		HockeyPlayer holtby2018 = new Goalie(new HockeyPlayer("Holtby", "Goalie", 70), 13);
		System.out.println(holtby2018);
		
		Goalie holtby2013 = new Goalie(new HockeyPlayer("Holtby", "Goalie", 70), 23);
		Goalie holtby2012 = new Goalie(new HockeyPlayer("Holtby", "Goalie", 70), 23);
		
		System.out.println(holtby2017.equals(holtby2018));
		System.out.println(((HockeyPlayer)(holtby2017)).equals((HockeyPlayer)holtby2018)); //Goalie class equals() still called
		System.out.println(h.equals(h1));
		System.out.println(holtby2013.equals(holtby2012));
		
		System.out.println();
		
		System.out.println(holtby2017.getClass());
		System.out.println(holtby2012.getClass());
		System.out.println(h.getClass());
		
		System.out.println();
		
		System.out.println(holtby2017.hashCode());
		System.out.println(holtby2018.hashCode());
		System.out.println(holtby2012.hashCode());
		System.out.println(holtby2013.hashCode());
		System.out.println(h.hashCode());
		System.out.println(h1.hashCode());
		
		System.out.println();
		
		System.out.println(holtby2017.hashCode() == holtby2018.hashCode());
		System.out.println(holtby2013.hashCode() == holtby2012.hashCode());
		System.out.println(h.hashCode() == h1.hashCode());
	}
}