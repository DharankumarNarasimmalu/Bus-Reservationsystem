package transaction;
import java.util.Scanner;
public class Upi implements PaymentGateway{

	public float payableMethod(float amount) {
		System.out.println("Enter password");
		sendingOTPtoPhone();
		Scanner sc=new Scanner(System.in);
		int pin=sc.nextInt();
		
		if(verifingOTP(pin)) {
		float netAmount=amount;
		return netAmount;
		}else {
			System.out.println("invalid pin");
			payableMethod(amount);
		}
		return amount;
		
	}

	@Override
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