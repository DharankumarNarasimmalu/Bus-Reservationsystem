package transaction;

import java.util.Scanner;

public interface PaymentGateway{
	float payableMethod(float amount);
	void sendingOTPtoPhone();
	boolean verifingOTP(int pin);
}
