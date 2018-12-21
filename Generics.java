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
class Forward extends HockeyPlayer{
	//constructor
	public Forward(String lastName, int jerseyNumber){
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		position = "Forward";
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
public class Generics{
	//main method
	public static void main(String[] args) {
		Roster<Goalie> copley = new Roster<>(new Goalie("Copley", 1));
		Roster<Goalie> holtby = new Roster<>(new Goalie("Holtby", 70));
		
		Roster<Defense> orlov = new Roster<>(new Defense("Orlov", 9));
		Roster<Defense> carlson = new Roster<>(new Defense("Carlson", 74));
		Roster<Defense> kempny = new Roster<>(new Defense("Kempny", 6));
		Roster<Defense> niskanen = new Roster<>(new Defense("Niskanen", 9));
		Roster<Defense> siegenthaler = new Roster<>(new Defense("Siegenthaler", 9));
		Roster<Defense> bowey = new Roster<>(new Defense("Bowey", 22));
		Roster<Defense> djoos = new Roster<>(new Defense("Djoos", 29));
		Roster<Defense> lewington = new Roster<>(new Defense("Lewington", 78));
		Roster<Defense> orpik = new Roster<>(new Defense("Orpik", 44));
		
		Roster<Forward> backstrom = new Roster<>(new Forward("Backstrom", 19));
		Roster<Forward> boyd = new Roster<>(new Forward("Boyd", 72));
		Roster<Forward> eller = new Roster<>(new Forward("Eller", 20));
		Roster<Forward> burakovsky = new Roster<>(new Forward("Burakovsky", 65));
		Roster<Forward> vrana = new Roster<>(new Forward("Vrana", 13));
		Roster<Forward> oshie = new Roster<>(new Forward("Oshie", 77));
		Roster<Forward> jaskin = new Roster<>(new Forward("Jaskin", 23));
		Roster<Forward> kuznetsov = new Roster<>(new Forward("Kuznetsov", 92));
		Roster<Forward> dowd = new Roster<>(new Forward("Dowd", 26));
		Roster<Forward> stephenson = new Roster<>(new Forward("Stephenson", 18));
		Roster<Forward> ovechkin = new Roster<>(new Forward("Ovechkin", 8));
		Roster<Forward> connolly = new Roster<>(new Forward("Connolly", 10));
		Roster<Forward> wilson = new Roster<>(new Forward("Wilson", 43));
		Roster<Forward> smithPelly = new Roster<>(new Forward("Smith-Pelly", 25));

		System.out.println("Goalies: \n" + copley.getPlayer() + "\n" + holtby.getPlayer());
		System.out.println("\nDefense: \n" + orlov.getPlayer() + "\n" + carlson.getPlayer() + "\n"
			+ kempny.getPlayer() + "\n" + niskanen.getPlayer() + "\n" + siegenthaler.getPlayer() + "\n"
			+ bowey.getPlayer() + "\n" + djoos.getPlayer() + "\n" + lewington.getPlayer() +"\n"
			+ orpik.getPlayer());
		System.out.println("\nForwards: \n" + backstrom.getPlayer() + "\n" + boyd.getPlayer() + "\n"
			+ eller.getPlayer() + "\n" + burakovsky.getPlayer() + "\n" + vrana.getPlayer() + "\n" 
			+ oshie.getPlayer() + "\n" + jaskin.getPlayer() + "\n" + kuznetsov.getPlayer() + "\n" 
			+ dowd.getPlayer() + "\n" + stephenson.getPlayer() + "\n" + ovechkin.getPlayer() + "\n"
			+ connolly.getPlayer() + "\n" + wilson.getPlayer() + "\n" + smithPelly.getPlayer());
	}
}