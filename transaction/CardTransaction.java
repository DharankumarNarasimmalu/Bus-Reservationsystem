package transaction;

import java.util.Scanner;

public class CardTransaction implements PaymentGateway{
	public float payableMethod(float amount) {
		float netAmount=0;
		System.out.println("enter card number");
		Scanner sc=new Scanner(System.in);
		long cardNo=sc.nextLong();
		System.out.println("Enter cvv number");
		int cvv=sc.nextInt();
		sendingOTPtoPhone();
		System.out.println("Enter Otp");
		int otp=sc.nextInt();
		
		if(verifingOTP(otp)){
			netAmount=amount;
			if(amount>1000) {
				netAmount+=amount*0.05f;
			}
		}
		else {
			System.out.println("Invalid otp");
			payableMethod(amount);
		}
		return netAmount;		
	}
	public void sendingOTPtoPhone() {
		System.out.println("Sending otp to phone.......");
		
	}

	@Override
	public boolean verifingOTP(int pin) {
		int password=123456;
		if(password==pin) {
			return true;
		}
		else {
			return false;
		}
	}
}