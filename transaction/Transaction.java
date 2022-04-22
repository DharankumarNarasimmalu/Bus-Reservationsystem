package transaction;
import java.util.List;
import java.util.Scanner;

import customer.PassengerDetails;
import offers.*;

public class Transaction{
	Offers discountType;
	PaymentGateway billPayment;
	public Transaction(Offers discount){
		this.discountType=discount;
	}
	public Transaction(PaymentGateway paymentType) {
		this.billPayment=paymentType;
		
	}
	public int  wallet(int numberOfPassenger) {
		int points=numberOfPassenger*5;
		return points;	
	}
	public float[] discount(int busNo,int noOfPassenger, int walletPoint, int offerIdentification) {
		float finalAmount=0;
		int usedpoints=0;
		int passengerOfPayingBill=noOfPassenger;
		float cashBackRupees = 0;
		if(busNo==123) {
			int ticketamount=500;
			System.out.println("rupees per ticket "+ticketamount);
			finalAmount=discountType.discountingAmount(ticketamount, noOfPassenger)*noOfPassenger;
			System.out.println("Final amount "+finalAmount);
			cashBackRupees=discountType.chashBack(finalAmount);
		}
		else if(busNo==124) {			
			int ticketamount=250;
			System.out.println("rupees per ticket "+ticketamount);
			finalAmount=discountType.discountingAmount(ticketamount, noOfPassenger);
			cashBackRupees=discountType.chashBack(ticketamount);
		}
		else if(busNo==125) {			
			int ticketamount=300;
			System.out.println("rupees per ticket "+ticketamount);
			finalAmount=discountType.discountingAmount(ticketamount, noOfPassenger);
			cashBackRupees=discountType.chashBack(ticketamount);
		}
		if(offerIdentification==1) {
			((PongalOffer) discountType).getGift();
		}
		else if(offerIdentification==2) {
			passengerOfPayingBill=((DiwaliOffer) discountType).getFreeticket(noOfPassenger);
		}
		
		System.out.println("press 1 to use wallet points ||press 2 to continue");
		Scanner sc=new Scanner(System.in);
		int walletOption=sc.nextInt();
		if(walletOption==1) {
			finalAmount-=walletPoint;
			usedpoints=walletPoint;
		}
		else if(walletOption==2) {
			finalAmount=finalAmount;
			usedpoints=0;
		}
		float cashback=cashBackRupees;
		System.out.println("cashback amount: "+cashback);
		float []finalAmountAndWalletPoints= {(finalAmount)-cashBackRupees,(float)usedpoints};
		return finalAmountAndWalletPoints;
	}

	public List<PassengerDetails> ticketCancellation(List<PassengerDetails> busAndPassengerDetails) {
		Scanner sc=new Scanner(System.in);
		int index=0;
		float amount=0;
		System.out.println("Enter bus number");
		int busNo=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name =sc.nextLine();
		for(PassengerDetails passenger:busAndPassengerDetails) {
			if(busNo==passenger.getBusNo() && name.equals(passenger.getName())){
//				busAndPassengerDetails.remove(passenger);
				index=busAndPassengerDetails.indexOf(passenger);
				if(busNo==123) {
					amount+=500;
				}
				else if(busNo==124) {
					amount+=250;
				}
				else if(busNo==125) {
					amount+=300;
				}
			}
		}
		busAndPassengerDetails.remove(index);
		refund(amount);
		return busAndPassengerDetails;
		
	}
	public void refund(float amount) {
		if(amount>0) {
		System.out.println("Rs."+amount+" is transfered to your account");
		}
		else {
			System.out.println("no such name or bus no found");
		}
	}
	public float []billPayment(float amount,int noOfPassenger) {
		
	    float netAmount=billPayment.payableMethod(amount);
	    int walletpoints=wallet(noOfPassenger);
	    float[]amountAndWallet= {walletpoints,netAmount};
		return amountAndWallet;
		
	}
	public void showTicket(float netPayment, List<PassengerDetails> busAndPassengerDetails) {
		System.out.println("Passenger Details");
		for(PassengerDetails passenger:busAndPassengerDetails) {
			passenger.showDetails();
		}
		System.out.println("your bill amount"+netPayment);
		
	}

}
