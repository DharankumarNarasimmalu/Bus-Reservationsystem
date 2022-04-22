package transaction;

import java.util.Scanner;

public class NetBanking implements PaymentGateway{
	public float payableMethod(float amount) {
		float netAmount =0;
		System.out.println("Enter password");
		Scanner sc=new Scanner(System.in);
		int  pass=sc.nextInt();
		sendingOTPtoPhone();
		if(verifingOTP(pass)) {
			netAmount = amount;
			if (amount>=500) {
				netAmount+=amount*0.01f;
			}
		}
		else {
			System.out.println("invalid pin");
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