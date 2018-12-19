import java.time.*;
import java.text.*;

class Schedule{
	//fields
	private LocalDate date;
	private String opponent;
	private boolean homeGame;
	private String venue;
	private String venueCountry;
	
	//constructor
	public Schedule(LocalDate date, String opponent, boolean homeGame, String venue, String venueCountry){
		this.date = date;
		this.opponent = opponent;
		this.homeGame = homeGame;
		this.venue = venue;
		this.venueCountry = venueCountry;
	}
	
	//getters
	public LocalDate getDate(){
		return date;	
	}
	
	public String getOpponent(){
		return opponent;	
	}
	
	public boolean isHomeGame(){
		return homeGame;	
	}
	
	public String getVenue(){
		return venue;	
	}
	
	public String getVenueCountry(){
		return venueCountry;
	}
}

public class Anonymous{

	//abstract class
	abstract class CurrencyExchange{
		abstract double exchangeRate(String country);	
	}
	
	public String rateDescription(Schedule schedule){
		//anonymous inner class definition
		CurrencyExchange cEx = new CurrencyExchange(){
			double exchangeRate(String country){
				if(country.equals("Canada")){
					return 1.35;		
				}
				return 1.00;
			}
		};
		DecimalFormat df = new DecimalFormat("0.00");
		return "$" + df.format(cEx.exchangeRate(schedule.getVenueCountry())) + " is the (expected) exchange rate for Washington Capitals players while playing at " + schedule.getVenue() + " on " + schedule.getDate() + ".";
	}
	
	public static void main(String... args){
		Schedule dec19 = new Schedule(LocalDate.of(2018, Month.DECEMBER, 19), "Pittsburgh Penguins", true, "Capital One Arena", "USA");	
		Schedule dec21 = new Schedule(LocalDate.of(2018, Month.DECEMBER, 21), "Buffalo Sabres", true, "Capital One Arena", "USA");
		Schedule dec22 = new Schedule(LocalDate.of(2018, Month.DECEMBER, 22), "Ottawa Senators", false, "Canadian Tire Centre", "Canada");
		Schedule dec27 = new Schedule(LocalDate.of(2018, Month.DECEMBER, 27), "Carolina Hurricanes", true, "Capital One Arena", "USA");
		Schedule dec29 = new Schedule(LocalDate.of(2018, Month.DECEMBER, 29), "Ottawa Senators", false, "Canadian Tire Centre", "Canada");
		Schedule dec31 = new Schedule(LocalDate.of(2018, Month.DECEMBER, 31), "Nashville Predators", true, "Capital One Arena", "USA");

		Anonymous a = new Anonymous();
		System.out.println(a.rateDescription(dec19));
		System.out.println(a.rateDescription(dec21));
		System.out.println(a.rateDescription(dec22));
		System.out.println(a.rateDescription(dec27));
		System.out.println(a.rateDescription(dec29));
		System.out.println(a.rateDescription(dec31));
	}
}