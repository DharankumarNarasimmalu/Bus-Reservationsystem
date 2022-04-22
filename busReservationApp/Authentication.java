package busReservationApp;
import java.util.List;

import java.util.Scanner;
public class Authentication{
	protected String name;
	protected int age;
	protected String address;
	protected long phoneNumber;
	protected String password;
	protected String mail;
	public boolean login(String userName, String password) {
		if(userName.equals(name)&&password.equals(this.password)) {
			return true;
		}
		else {
		return false;
		}
	}	
	public void logout() {
		System.out.println("Thanking of choosing out service");
		System.out.println("1.REMEMBER PASSWORD\n2.EXIT");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option) {
			case(1):
				System.out.println("remember password");
			    break;
			case(2):
				System.out.println("Does not remember password");
			    break;
		}
	}
	public void forgetPassword(String userName) {
		if(userName.equals(name)) {
			if(phnoVerifing() && emailVerifing()) {
			    while(true) {
			        System.out.println("Enter new password");
			        Scanner sc=new Scanner(System.in);
			        String newPassword=sc.nextLine();
			        System.out.println("Re-type password");
			        String confirmPassword=sc.nextLine();
			        if(newPassword.equals(confirmPassword)) {
				        this.password=newPassword;
				        captchaVerification();
				        iamNotRobot();
				        break;
			        }
		        }
			}
		    else {
			System.out.println("wrong phoneNumber");
			forgetPassword(userName);
		    }			
		}
	}
	public void changeProfile() {
		Scanner sc=new Scanner(System.in);
		boolean end=true;
		while(end) {
		System.out.println("1.CHANGE NAME\n2.CHANGE AGE\n3.CHANGE ADDRESS\n4.CHANGE PHONE NUMBER\n5.CHANGE PASSWORD\n6.SAVE PROFILE");
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		case(1):
			System.out.println("Enter Name");
			name=sc.nextLine();
		    break;
		case(2):
			System.out.println("Enter age");
			age=sc.nextInt();
		    break;
		case(3):
			System.out.println("Enter Address");
			address=sc.nextLine();
		    break;
		case(4):
			System.out.println("Phone Number");
			phoneNumber=sc.nextLong();
		    break;
		case(5):
			System.out.println("Enter Password");
			String pass=sc.nextLine();
			System.out.println("Re-type password");
			String confirmPassword=sc.nextLine();
			if(pass.equals(confirmPassword)) {
				this.password=pass;
			}
			else {
				System.out.println("Password does not match");
			}
		    break;
		case(6):
			System.out.println("Saving.........");
		    end=false;
		    break;
		default:
			System.out.println("invalid number");
		}
		}	
	}
	public void captchaVerification() {
		String autoCaptcha="Xx213";
		System.out.println(autoCaptcha);
		System.out.println("Enter the above captcha");
		Scanner sc=new Scanner(System.in);
		String captcha=sc.nextLine();
		if(autoCaptcha.equals(captcha)) {
			return;
		}
		else {
			System.out.println("Your captcha is wrong");
			captchaVerification();
		}	
	}
	public void iamNotRobot() {
		System.out.println("press 1 for Iam not Robot");
		Scanner sc=new Scanner(System.in);
		int robot=sc.nextInt();
		if (robot==1) {
			
		System.out.println("Iam not Robot<>");
		}
		else {
			iamNotRobot();
		}
	}
	public boolean phnoVerifing() {
		System.out.println("verify phone number...");
		Scanner sc=new Scanner(System.in);
		long  phoneNo=sc.nextLong();
		if(phoneNo==phoneNumber){
			return true;
		}
		else {
		return false;
		}
	}
	public boolean emailVerifing() {
		System.out.println("verify email...");
		Scanner sc=new Scanner(System.in);
		String  verifiedMail=sc.nextLine();
		if(mail.equals(verifiedMail)){
			return true;
		}
		else {
		return false;
		}
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getMailId() {
		return mail;
	}
}
