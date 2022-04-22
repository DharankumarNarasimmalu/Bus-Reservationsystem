package customer;

import java.util.Scanner;

import busReservationApp.Authentication;

public class LoginCustomer extends Authentication {
    int walletPoints;
    public LoginCustomer(String name, int age, String address, long phoneNo,String mail, String password){
		super.name=name;
		super.age=age;
	    super.address=address;
		super.phoneNumber=phoneNo;
		super.password=password;
		super.mail=mail;	
		}

	public void setWalletPoints(int walletPoints) {
		this.walletPoints+=walletPoints;
	}
	public int getWalletPoints() {
		return walletPoints;
	}
	
	
	public String customerComplaint() {
		System.out.println("Type your complaint hear");
		Scanner sc=new Scanner(System.in);
		String complaint=sc.nextLine();
		return complaint;
	}
	
	public String customerFeedback() {
		System.out.println("Type your feedback here");
		Scanner sc=new Scanner(System.in);
		String feedback=sc.nextLine();
		return feedback;
	}
	public void helpline() {
		System.out.println("dialing 9876543201........");
	}
	
}
