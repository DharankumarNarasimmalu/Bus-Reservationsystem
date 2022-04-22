package offers;
public class DiwaliOffer extends Offers{
	public float discountingAmount(int NoOfPassenger,float amount) {
		System.out.println("great pongal discount");
		float netAmount=0;
		if(NoOfPassenger>=5) {
			netAmount=amount-amount*0.20f;
		}
		else {
			netAmount=amount;
		}
		return netAmount;	
	}
	public int getFreeticket(int NoOfPassenger) {
		System.out.println("book 4 ticket and get one ticket free");
		int totalPassenger=0;
		if(NoOfPassenger>=4) {
			totalPassenger=NoOfPassenger-1;
		}
		return totalPassenger;
	}
}