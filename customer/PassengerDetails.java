package customer;




public class PassengerDetails {
	public enum gender{
		MALE,
		FEMALE,
		TRANSGENDER
	}
	private String passengerName;
	private int passengerAge;
	private gender passengerGender;
	private int bookedBusNo;
	private String date;
	private String time;

	public PassengerDetails(String name, gender gen, int age, int busNo,String time,String date) {
		this.passengerName=name;
		this.passengerAge=age;
		this.passengerGender=gen;
		this.bookedBusNo=busNo;
		this.date=date;
		this.time=time;
	}
	
	public void showDetails() {
		System.out.println(passengerName+" "+passengerAge+" "+passengerGender+" "+bookedBusNo+" "+date+" "+time);
	}
	public void setName(String name) {
		this.passengerName=name;
	}
	public void setAge(int age) {
		this.passengerAge=age;
	}
	public void setGender(gender gender) {
		this.passengerGender=gender;
	}
	public void setBusNo(int busNo) {
		this.bookedBusNo=busNo;
	}
	public int getBusNo() {
		int busNo=bookedBusNo;
		return busNo;
	}
	public String getName() {
		return passengerName;
	}
	public int getAge() {
		return passengerAge;
	}
	public gender getgender() {
		return passengerGender;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
}
