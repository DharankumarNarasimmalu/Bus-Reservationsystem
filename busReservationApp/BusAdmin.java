
package busReservationApp;

import java.util.*;
import customer.PassengerDetails;
import employee.*;

public class BusAdmin extends Authentication{
	static Map<String, String> customerComplaint=new HashMap<>();
	static List<PassengerDetails>passenger=new ArrayList<>();
	static Map<Integer, Driver> driverDetails=new HashMap<>();
	static Map<Integer, Supervisor> supervisorDetails=new HashMap<>();
	public BusAdmin(String name, int age, String address, long phoneNo,String mail, String password){
		super.name=name;
		super.age=age;
		super.address=address;
		super.phoneNumber=phoneNo;
		super.password=password;
		super.mail=mail;	
		}

	public BusAdmin(Map<String, String> passengerComplaint, List<PassengerDetails> busAndPassengerDetails,
			Map<Integer, Driver> driverDetails, Map<Integer, Supervisor> supervisorDetails) {
		this.customerComplaint.putAll(passengerComplaint);
		this.passenger.addAll(busAndPassengerDetails);
		this.driverDetails=driverDetails;
		this.supervisorDetails=supervisorDetails;
		
	}
	public void setBusDetails(Map<Integer, Bus> busAvailability) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER BUS NUMBER");		
		int busNumber=sc.nextInt();
		if(!busAvailability.containsKey(busNumber)) {
			System.out.println("Invalid bus Number");
			return;
		}
		
		if(busAvailability.containsKey(busNumber)) {
	        int driverId=0;
			boolean continuity=true;
			while(continuity) {
				System.out.println("1.CHANGE NUMBER OF SEAT\n2.CHANGE FROM LOCATION\n3.CHANGE TO LOCATION\n4.CHANGE DATE\n5.CHANGE AC OR NON AC\n6.SET DRIVER\n7.SAVE CHANGES");
				int changingOption=sc.nextInt();
				sc.nextLine();
				switch(changingOption) {
				
				case(1):
					System.out.println("Enter no of Seats");
					busAvailability.get(busNumber).setNoOFSeats(sc.nextInt());
					break;
				case(2):
					System.out.println("Enter from location");
				    String fromlocation=sc.nextLine();
				    busAvailability.get(busNumber).setFrom(fromlocation.toLowerCase());
				    break;
				case(3):
					System.out.println("Enter to location");
				    String tolocation=sc.nextLine();
				    busAvailability.get(busNumber).setTo(tolocation.toLowerCase());
				    break;
				case(4):
					System.out.println("Enter date");
				    busAvailability.get(busNumber).setDate(sc.nextLine());
				    break;
				case(5):
					System.out.println("ENTER 1 FOR AC OR 2 FOR NON-AC");
				    busAvailability.get(busNumber).setac(sc.nextInt());
				    break;
				case(6):
					System.out.println("Enter Driver ID");
				    driverId=sc.nextInt();
				    if(driverDetails.containsKey(driverId)) {
					    String driverName=driverDetails.get(driverId).getName();
					    busAvailability.get(busNumber).setDriver(driverName);
				    }
				    else {
				    	System.out.println("Invalid id number");
				    }
				    break;
				case(7):
					continuity=false;
				    break;
				default:
					System.out.println("Invalid number");
				}
			}
			if(driverDetails.containsKey(driverId)) {
				driverDetails.get(driverId).setbusNo(busNumber);
				driverDetails.get(driverId).setDate(busAvailability.get(busNumber).getDate());
				driverDetails.get(driverId).setDepartureTime(busAvailability.get(busNumber).getTime());
				driverDetails.get(driverId).setFrom(busAvailability.get(busNumber).getFrom());
				driverDetails.get(driverId).setTo(busAvailability.get(busNumber).getTo());
			}
		}
		else {
			System.out.println("Invalid bus number");
		}
		
	}
	public void viewComplaint() {
		for(Map.Entry e:customerComplaint.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	public void viewFeedback(Map<String, String> passengerFeedback) {
		for(Map.Entry e:passengerFeedback.entrySet()) {
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}
	public void viewPassengerDetails() {
		System.out.println("Enter Bus Number");
		Scanner sc=new Scanner(System.in);
		int busNumber=sc.nextInt();
//		String date=sc.nextLine();
		for(PassengerDetails passengerDetails:passenger) {
			if(busNumber==passengerDetails.getBusNo()) {
				passengerDetails.showDetails();
			}
		}	
	}
	public void setEmployeeDetails() {
		System.out.println("1.DRIVER\n2.SUPERVISOR");
		Scanner sc=new Scanner(System.in);
		int adminOption=sc.nextInt();
		if(adminOption==1) {
			System.out.println("ENTER ID NUMBER");
			int id=sc.nextInt();
//			System.out.println("PRESS 1 FOR CHANGE NAME//PRESS 2 FOR CHANGE AGE//PRESS 3 FOR CHANGE MAILID//PRESS 4 FOR CHANGE ADDRESS//PRESS 5 FOR CHANGE SALARY//PRESS 6 FOR CHANGE EXPERIENCE//PRESS 7 FOR CHANGE REMARKS");
			
			boolean continuity=true;
			while(continuity) {
				System.out.println("1.CHANGE NAME\n2.CHANGE AGE\n3.CHANGE MAILID\n4.CHANGE ADDRESS\n5.CHANGE SALARY\n6.CHANGE EXPERIENCE\n7.CHANGE REMARKS\n8.SAVE CHANGES");
				int changingOption=sc.nextInt();
				sc.nextLine();
				switch(changingOption) {
				case(1):
					System.out.println("Enter name");
					driverDetails.get(id).setname(sc.nextLine());
					break;
				case(2):
					System.out.println("Enter age");
					driverDetails.get(id).setAge(sc.nextInt());
					break;
				case(3):
					System.out.println("Enter Mail-ID");
					driverDetails.get(id).setmailId(sc.nextLine());
					break;
				case(4):
					System.out.println("Enter Address");
					driverDetails.get(id).setAddress(sc.nextLine());
					break;
				case(5):
					System.out.println("Enter Salary");
					driverDetails.get(id).setSalary(sc.nextFloat());
					break;
				case(6):
					System.out.println("Enter Experience");
					driverDetails.get(id).setExperience(sc.nextInt());
					break;
	
				case(7):
					System.out.println("Enter Re-marks");
					driverDetails.get(id).setRemarks(sc.nextLine());
					break;
				case(8):
					continuity=false;
				    break;
				default:
					System.out.println("Invalid option");
				}
			}
		}
		else if(adminOption==2) {
			System.out.println("Enter Id-number");
			int id=sc.nextInt();	
			boolean continuity=true;
			while(continuity) {
				System.out.println("\"1.CHANGE NAME\n2.CHANGE AGE\n3.CHANGE MAILID\n4.CHANGE ADDRESS\n5.CHANGE SALARY\n6.CHANGE EXPERIENCE\n7.CHANGE REMARKS\n8.SAVE CHANGES");
				int changingOption=sc.nextInt();
				sc.nextLine();
				switch(changingOption) {
				case(1):
					System.out.println("Enter name");
					supervisorDetails.get(id).setname(sc.nextLine());
					break;
				case(2):
					System.out.println("Enter age");
					supervisorDetails.get(id).setAge(sc.nextInt());
					break;
				case(3):
					System.out.println("Enter mail-Id");
					supervisorDetails.get(id).setmailId(sc.nextLine());
					break;
				case(4):
					System.out.println("Enter Adddress");
					supervisorDetails.get(id).setAddress(sc.nextLine());
					break;
				case(5):
					System.out.println("Enter Salary");
					supervisorDetails.get(id).setSalary(sc.nextFloat());
					break;
				case(6):
					System.out.println("Enter Experience");
					supervisorDetails.get(id).setExperience(sc.nextInt());
					break;
	
				case(7):
					System.out.println("ENTER Re-marks");
					supervisorDetails.get(id).setRemarks(sc.nextLine());
					break;
				case(8):
					continuity=false;
				    break;
				default:
					System.out.println("Enter invaild login details");
				}
			}
			
		}
	}
	public void viewEmployeeInfo() {
		System.out.println("1.ALL DETAILS/n2.DRIVER DETAILS/N3.CLEANER DETAILS/n4.SUPERVISOR DETAILS");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		    case(1):
		    	for(Map.Entry driverInfo:driverDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		driverDetails.get(idNo).displayDetails();
					
				}
			    
			    for(Map.Entry driverInfo:supervisorDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		supervisorDetails.get(idNo).displayDetails();
					
				}
			    break;
		    case(2):
		    	for(Map.Entry driverInfo:driverDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		driverDetails.get(idNo).displayDetails();
					
				}
		        break;
		    case(3):
		    	for(Map.Entry driverInfo:supervisorDetails.entrySet()) {
		    		int idNo=(int) driverInfo.getKey();
		    		supervisorDetails.get(idNo).displayDetails();
					
				}
			    break;	
		}	
	}
	public void paySalary() {
		for(Map.Entry driverInfo:driverDetails.entrySet()) {
    		int idNo=(int) driverInfo.getKey();
    		driverDetails.get(idNo).paySalary();
			
		}
		
	    for(Map.Entry driverInfo:supervisorDetails.entrySet()) {
    		int idNo=(int) driverInfo.getKey();
    		supervisorDetails.get(idNo).paySalary();
			
		}
		
	}
	public void putAttendance() {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER ID NUMBER");
		int idNo=sc.nextInt();
		System.out.println("1.DRIVER\n2.SUPERVISOR");
		int department=sc.nextInt();
		if(department==1) {
			if(driverDetails.containsKey(idNo)) {
			System.out.println(driverDetails.get(idNo).getStatus());
			System.out.println("PRESS 1 FOR PRESENT||PRESS 2 FOR ABSENT");
			driverDetails.get(idNo).setStatus(sc.nextInt());
			}
			else {
				System.out.println("Invalid id Number");
			}
		}
		else if(department==2) {
			if(supervisorDetails.containsKey(idNo)) {
			System.out.println(supervisorDetails.get(idNo).getStatus());
			System.out.println("PRESS 1 FOR PRESENT||PRESS 2 FOR ABSENT");
			supervisorDetails.get(idNo).setStatus(sc.nextInt());
			supervisorDetails.get(idNo).setDuty(sc.nextInt());
			}
			else {
				System.out.println("Invalid id number");
			}
		}
		
		
	}
}
