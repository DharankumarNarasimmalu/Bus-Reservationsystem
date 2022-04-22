package employee;

public class Supervisor extends Employee{
	public enum dutyCycle{
		DAY,
		NIGHT
	}
	dutyCycle duty;
    public Supervisor(String name, int age, long phno, String mail, String address, int salary, int exp,
			String remarks,attendence status,dutyCycle duty, String password) {
		super.name=name;
		super.age=age;
		super.phoneNumber=phno;
		super.mail=mail;
		super.address=address;
		super.salary=salary;
		super.yearOfExperience=exp;
		super.remarks=remarks;
		super.status=status;
		super.password=password;		
		this.duty=duty;
	}
    public void setDuty(int i) {
    	if(i==1) {
    	    this.duty=duty.DAY;
    	}
    	else {
    	    this.duty=duty.NIGHT;
    	}
    }
    public dutyCycle getDuty() {
		return duty;
    	
    }
    public void displayDetails() {
		System.out.println(name+" "+age+" "+phoneNumber+" "+mail+" "+address+" "+salary+" "+yearOfExperience+" "+remarks+" "+duty);
		
	}
	public void showDutyDetails() {
		System.out.println("ABC TRAVELLES");
		System.out.println("Name: "+name);
		System.out.println("Duty: "+duty);
		
	}

	
}