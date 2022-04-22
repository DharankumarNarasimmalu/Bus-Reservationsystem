package employee;

public class Driver extends Employee{
	int busNo;
	String departureTime;
	String date;
	String fromLocation;
	String toLocation;
	
	public Driver(String name, int age, long phoneNumber, String mail, String address, int salary, int exp, String remarks,attendence status,int busNo, String time, String date,String from,String to, String password) {
		super.name=name;
		super.age=age;
		super.phoneNumber=phoneNumber;
		super.mail=mail;
		super.address=address;
		super.salary=salary;
		super.yearOfExperience=exp;
		super.remarks=remarks;
		super.status=status;
		this.busNo=busNo;
		this.departureTime=time;
		this.date=date;	
		this.fromLocation=from;
		this.toLocation=to;
		super.password=password;
	
	}
	public void setbusNo(int busNo) {
		this.busNo=busNo;
	}
	public void setDepartureTime(String time) {
		this.departureTime=time;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public int getBusNo() {
		return busNo;
	}
	public String gettime() {
		return departureTime;
	}
	public String getDate() {
		return date;
	}
	public void setFrom(String from) {
		this.fromLocation=from;
	}
	public String getFrom() {
		return fromLocation;
	}
	public void setTo(String to) {
		this.toLocation=to;
	}
	public String getTo() {
		return toLocation;
	}

	public void displayDetails() {
		System.out.println(name+" "+age+" "+phoneNumber+" "+mail+" "+address+" "+salary+" "+yearOfExperience+" "+remarks);
		System.out.println("BUS DETAILS: \n"+"busNo: "+busNo+'\n'+"Time: "+departureTime+'\n'+"date: "+date+'\n'+"fromLocation"+" to "+toLocation);
		
	}
	public void showDutyDetails() {	
		System.out.println("ABC TRAVELLES");
		System.out.println("Name: "+name);
    	System.out.println("BUS NO: "+busNo);
    	System.out.println("DEPARTURE TIME: "+departureTime);
    	System.out.println("DEPARTURE DATE: "+date);
    	System.out.println("FROM LOCATION: "+fromLocation);
    	System.out.println("TO LOCATION: "+toLocation);
		
	}
	

}