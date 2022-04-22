package employee;

import busReservationApp.Authentication;

public class Employee extends Authentication{
	public enum attendence{
		PRESENT,
		ABSENT
	}
    protected String address;
	protected float salary;
	protected int yearOfExperience;
	protected String remarks;
	protected attendence status;

    String getname() {
		return name;	
	}
	public int getAge() {
		return age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getMAilId() {
		return mail;
	}
	public String getAddress() {
		return address;
	}
	public void setname(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setphNo(long phno) {
		this.phoneNumber=phno;
	}
	public void setmailId(String mail) {
		super.mail=mail;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void paySalary() {
		System.out.println("Salary payed...... ");
	}
	public attendence getStatus() {
		return status;
	}
	public void setStatus(int attendenceoption) {
		if(attendenceoption==1) {
			this.status=attendence.PRESENT;
		}
		else if(attendenceoption==2){
			this.status=attendence.ABSENT;
		}
	}
	
	public void setRemarks(String remarks) {
		this.remarks=remarks;
	}
	public String  getRemarks() {
		return remarks;
	}

	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary=salary;
	}
	public void setExperience(int exp) {
		this.yearOfExperience=exp;
		
	}
	
	
    
}



