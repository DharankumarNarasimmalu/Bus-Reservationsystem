package offers;

import java.util.Scanner;

public class Offers {
	public float  discountingAmount(float amount,int NoOfPassenger ){
		float netAmount=0;
		if(NoOfPassenger>=5) {
			netAmount=amount-(amount*0.05f);
		}
		else {
			netAmount=amount;
		}
		return netAmount;
	}
	public float chashBack(float amount) {
		float cashBackAmount=0;
		if(amount>=1000) {
			cashBackAmount=10;
		}
		else if(amount>=5000) {
			cashBackAmount=50;
		}
		if(cashBackAmount>0) {
		System.out.println("Congragulation you got an cash back of rs. "+cashBackAmount);
		}
		return cashBackAmount;		
	}
	public void covidOffer() {
		System.out.println("upload your covaxin certificate to get upto 10% discount");
	}
}


