package offers;

import java.util.Scanner;

public class PongalOffer extends Offers{
	public float discountingAmount(int NoOfPassenger,float amount) {
		System.out.println("great pongal discount");
		float netAmount=0;
		if(NoOfPassenger>=5) {
			netAmount=amount-amount*0.10f;
		}
		else {
			netAmount=amount;
		}
		return netAmount;	
	}
	public void getGift() {
		System.out.println("enter coupen number to get exciting prize");
		Scanner sc=new Scanner(System.in);
		System.out.println("Coupon number:456789");
		int giftCouponNumber=sc.nextInt();
		System.out.println("results will annonce shortly");
	}
}
