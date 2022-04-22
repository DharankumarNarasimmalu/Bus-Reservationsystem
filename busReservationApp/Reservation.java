package busReservationApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customer.PassengerDetails;
import customer.PassengerDetails.gender;

public class Reservation{
	
	List<PassengerDetails> gettingPassengerInfo(int busCapacity,int busNo, String time, String date) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of seats required");
		int noOfSeatsRequired=sc.nextInt();
		
		
		sc.nextLine();
		List<PassengerDetails>passengerDetails=new ArrayList<>();
		if(checkingAvailability(busCapacity,noOfSeatsRequired)) {
			for(int i=0;i<noOfSeatsRequired;i++) {
				System.out.println("Enter passenger name");
				String name=sc.nextLine();
				System.out.println("1.MALE\n2.FEMALE\n3.TRANSGENDER");
				int genderOpt=sc.nextInt();
				gender gen=null;
				switch(genderOpt) {
				case(1):
				    gen=gender.MALE;
				    break;
				case(2):
					gen=gender.FEMALE;
				    break;
				case(3):
					gen=gender.TRANSGENDER;
				    break;
				default:
					System.out.println("INVALID OPTION");
				}
				
				System.out.println("Enter age");
				int age=sc.nextInt();
//				System.out.println("Enter preffered seat number");
//				String seat=sc.nextLine();
				sc.nextLine();
				passengerDetails.add(new PassengerDetails(name,gen,age,busNo,date,time));
				}
		}
		else {
			gettingPassengerInfo(busCapacity,busNo,time,date);
		}
		return passengerDetails;
	}
	
	boolean checkingAvailability(int busCapacity,int noOfSeats) {
		if (busCapacity>=noOfSeats) {
			return true;
		}
		else {
			System.out.println("Sorry Seat is not available");
			return false;
		}
	}

	public List<PassengerDetails> searchBus(Map<Integer, Bus> busAvailability){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter from location");
		String from=sc.nextLine();
		System.out.println("Enter to location");
		String to=sc.nextLine();
		System.out.println("Enter Date in formate of dd/mm/yyyy");
		String date=sc.nextLine();
		boolean availableBus=false;
		
		for(Map.Entry e:busAvailability.entrySet()) {
			int busNo=(int)e.getKey();
			if(busAvailability.get(busNo).getFrom().equals(from.toLowerCase()) && busAvailability.get(busNo).getTo().equals(to.toLowerCase()) && busAvailability.get(busNo).getDate().equals(date)) {
				availableBus=true;
				System.out.println("bus number: "+busNo);
				busAvailability.get(busNo).showBusDetails();
			}			
		}
		List<PassengerDetails> passengerDetailsOfChoosedBus=new ArrayList<>();
		if( !availableBus){
			return passengerDetailsOfChoosedBus;
		}
		System.out.println("Enter bus no for booking");
		int busNumber=sc.nextInt();
		int busCapacity=busAvailability.get(busNumber).getNoOFSeats();
		passengerDetailsOfChoosedBus=gettingPassengerInfo(busCapacity,busNumber,busAvailability.get(busNumber).getTime(),busAvailability.get(busNumber).getDate());
		busAvailability.get(busNumber).setNoOFSeats(busCapacity-passengerDetailsOfChoosedBus.size());
		return passengerDetailsOfChoosedBus;

	}





}


