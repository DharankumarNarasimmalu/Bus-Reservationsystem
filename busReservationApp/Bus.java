package busReservationApp;



public class Bus {
	public enum ac{
		AC,
		NONAC
	}	
     private int busNo;
     private int noOfSeats;
	 private String from;
	 private String to;
     private String date;
	 private Enum<ac>acOrNonAc;
	 private String driver;	
	 private String time;
	public Bus(int noOfSeats,String from,String to,String date,Enum<ac> ac,String driver, String time) {
		this.noOfSeats=noOfSeats;
		this.from=from;
		this.to=to;
		this.date=date;
		this.acOrNonAc=ac;
		this.driver=driver;
		this.time=time;
	}
	public int getNoOFSeats() {	
		return noOfSeats;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getDate() {
		return date;
	}
	public Enum<ac> getac() {
		return acOrNonAc;
	}
	public String getDriver() {
		return driver;
	}
	public void setNoOFSeats(int capacity) {	
		this.noOfSeats=capacity;
	}
	public void setFrom(String fromLocation) {
		this.from=fromLocation;
	}
	public void setTo(String toLocation) {
		this.to=toLocation;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public void setac(int option) {
		if(option==1) {
		    this.acOrNonAc=ac.AC;
		}
		else if(option==2) {
			this.acOrNonAc=ac.NONAC;	
		}
	}
	public void setDriver(String driverName) {
		this.driver=driverName;
	}
	public  void showBusDetails() {
		System.out.println(noOfSeats+" "+from+" "+to+" "+date+" "+acOrNonAc+" "+driver+" "+time);		
	}
	public void setTime(String time) {
		this.time=time;
	}
	public String getTime() {
		return time;
	}

}
