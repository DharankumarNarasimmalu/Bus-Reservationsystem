package busReservationApp;
import java.util.*;

import busReservationApp.Bus.ac;
import customer.LoginCustomer;
import customer.PassengerDetails;
import employee.*;
import employee.Employee.attendence;
import employee.Supervisor.dutyCycle;
import offers.DiwaliOffer;
import offers.Offers;
import offers.PongalOffer;
import transaction.*;

public class Main {
	
	public static void main(String...args) {
		Scanner sc=new Scanner(System.in);		
		List<LoginCustomer>customerLogin=new ArrayList<>();
		LoginCustomer user1=new LoginCustomer("Dharan",20,"149,K........cuddalore",9876543201l,"dharan@gmail.com","1234");
		LoginCustomer user2=new LoginCustomer("Kumar",19,"148,K........chennai",10234567894l,"kumar@gmail.com","4321");
		LoginCustomer user3=new LoginCustomer("Karthic",21,"150,K........coimbatore",9876543201l,"karthic@gmail.com","9876");
		customerLogin.add(user1);
		customerLogin.add(user2);
		customerLogin.add(user3);
		List<BusAdmin>adminLogin=new ArrayList<>();
		adminLogin.add(new BusAdmin("Dharankumar",20,"149,K........cuddalore",9876543201l,"admin@gmail.com","1234"));
		Map<Integer,Driver>driverDetails=new HashMap<>();
		driverDetails.put(1,new Driver("Surya",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,"good",attendence.PRESENT,123,"12:30","25/04/2022","Cuddalore","Chennai","1234"));
		driverDetails.put(2,new Driver("Karthic",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,"good",attendence.PRESENT,124,"10:30","25/04/2022","Cuddalore","Chennai","9876"));
		driverDetails.put(3,new Driver("Vijay",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2,"good",attendence.PRESENT,124,"15:30","25/04/2022","Cuddalore","Chennai","4321"));
		Map<Integer,Supervisor>supervisorDetails=new HashMap<>();
		supervisorDetails.put(6,new Supervisor("Rajini",20,9876543201l,"rahul@gmail.com","149,.......cuddalore",20000,2, "good",attendence.PRESENT,dutyCycle.DAY,"1478"));
		Map<Integer,Bus>busAvailability=new HashMap<>();
		Bus bus1=new Bus(50,"cuddalore","chennai","25/04/2022",ac.AC,"driverName","12:30");
		Bus bus2=new Bus(19,"chennai","banglore","26/04/2022",ac.NONAC,"driverName","10:30");
		Bus bus3=new Bus(21,"coimbatore","tiruchi","26/04/2022",ac.AC,"driverName","15:30");
		busAvailability.put(123, bus1);		
		busAvailability.put(124, bus2);
		busAvailability.put(125, bus3);	
   		Map<String,String> passengerFeedback = new HashMap<>();
  		Map<String,String>passengerComplaint=new HashMap<>();
		List<PassengerDetails>busAndPassengerDetails = new ArrayList<>();
		
		int walletPoints=0;
		int offerIdentification=0;
		
		Authentication user=new Authentication();

		Offers discount=new Offers();

		Reservation booking =new Reservation();
		
    	while(true) {
  
            BusAdmin busAdmin=new BusAdmin(passengerComplaint,busAndPassengerDetails,driverDetails,supervisorDetails);
            passengerComplaint.clear();
            busAndPassengerDetails.clear();
		    System.out.println("1.PASSENGER\n2.ADMIN\n3.EMPLOYEE");
		    int option=sc.nextInt();
		    Transaction payment=new Transaction(discount);
		    int loginuser=-1;
		
		    if(option==1) {
				System.out.println("1.LOGIN\n2.SIGN UP\n3.FORGETPASSWORD");
			    int passengerOption=sc.nextInt();
			    sc.nextLine();
			    if (passengerOption==1) {
					System.out.println("Enter Username");
					String userName=sc.nextLine();
					System.out.println("Enter password");
					String password=sc.nextLine();
			    	for(Authentication logindetails:customerLogin) {
			    		boolean login=logindetails.login(userName,password);
			    		if(login) {
			    			loginuser=customerLogin.indexOf(logindetails);
			    			
			    			break;
			    		}
			    		else {
			    			continue;
			    		}
			    		
			    	}
			   
			        if(loginuser>=0) {			        	
				        
//				        LoginUser details=new LoginUser();//passenger class
				        int busNo = 0;
				        int noOfSeatsRequired=0;
				        boolean login=true;
				        while(login) {
				            System.out.println("1.BOOKING\n2.COMPLAINT\n3.FEEDBACK4.CHANGE PROFILE\n5.TICKET CANCELLATION\n6.HELPLINE\n.7.LOGOUT");
				            int userfunction=sc.nextInt();

				            switch(userfunction) {
				            case(1):
					        	busAndPassengerDetails=booking.searchBus(busAvailability);
				                if(busAndPassengerDetails==null) {
				                	System.out.println("NO BUS AVAILABLE");
				                	continue;
				                }
					        	noOfSeatsRequired=busAndPassengerDetails.size();
					        	for(PassengerDetails passenger:busAndPassengerDetails) {
					        		busNo=passenger.getBusNo();
					        		break;
					        	}

				                break;
				            case(2):
					        	String complaint=customerLogin.get(loginuser).customerComplaint();
				                String nameofComplaintGiven=customerLogin.get(loginuser).getName();
					            passengerComplaint.put(nameofComplaintGiven, complaint);
					            break;
				            case(3):
					        	String feedback=customerLogin.get(loginuser).customerFeedback();
				                String nameofFeedbackGiven=customerLogin.get(loginuser).getName();
					             passengerFeedback.put(nameofFeedbackGiven, feedback);
					            break;
				            case(4):
				            	customerLogin.get(loginuser).changeProfile();
					            break;
					        case(5):
					        	busAndPassengerDetails=payment.ticketCancellation(busAndPassengerDetails);
					            break;
					        case(6):
					        	customerLogin.get(loginuser).helpline();
					            break;
					        case(7):
					        	login=false;				    	
					    	    customerLogin.get(loginuser).logout();
					    	    break;
					 
					        default:
					        	System.out.println("invalid option");
					        }
				        if(busNo!=0) {
				        	walletPoints=customerLogin.get(loginuser).getWalletPoints();				        	
				        	float []amountAndUsedPoints=payment.discount(busNo,busAndPassengerDetails.size(),walletPoints,offerIdentification);
				        	PaymentGateway paymentType = null;
				        	System.out.println("1.UPI\n2.NET BANKING\n3.CARD TRANSACTION");
				        	int paymentOption=sc.nextInt();
				        	float  netPayment=0;
				        	switch(paymentOption) {
				        	case(1):
				        		paymentType=new Upi();

				        	    break;				        	
				        	case(2):
				        		paymentType=new NetBanking();

				        	    break;
				        	case(3):
				        		paymentType=new CardTransaction();

				        	    break;
				        	default:
				        		System.out.println("Invalid option");				        	
				        	}
				        	Transaction bill=new Transaction(paymentType);
				        	float AmountAndwalletPoints[]=bill.billPayment(amountAndUsedPoints[0],noOfSeatsRequired);
				        	netPayment=AmountAndwalletPoints[1];
				        	payment.showTicket(netPayment,busAndPassengerDetails);
				        	int walletpoint=(int)AmountAndwalletPoints[0];
				        	customerLogin.get(loginuser).setWalletPoints(walletpoint);
				        	busNo=0;
				        	
				        }
			        }
		        }
			        else{
				        System.out.println("Please check login details");
				    }
			    }
			    else if(passengerOption==2) {
			    	//sign up method
			    	System.out.println("Enter name");
			    	String name=sc.nextLine();
			    	System.out.println("Enter age");
			    	int age=sc.nextInt();
			    	sc.nextLine();
			    	System.out.println("Enter address");
			    	String address=sc.nextLine();
			    	System.out.println("Enter phone Number");
			    	long phNo=sc.nextLong();
			    	sc.nextLine();
			    	System.out.println("Enter mail id");
			    	String mailId=sc.nextLine();
			    	while(true) {
			    	    System.out.println("Enter Password");
			    	    String password=sc.nextLine();
			    	    System.out.println("Re-type password");
			    	    String confirmPassword=sc.nextLine();
			    	    if(password.equals(confirmPassword)){
			    		    while(true) {
			    		    System.out.println("verify phone number");
			    		    long phoneNumberVerify=sc.nextLong();
			    		    System.out.println("verify mail id");
			    		    String mail=sc.nextLine();
			    		    if(phoneNumberVerify==phNo && mailId.equals(mail)) {
			    			    user.captchaVerification();
			    			    user.iamNotRobot();
			    			    customerLogin.add(new LoginCustomer(name,age,address,phNo,mailId,password));	
			    			    break;
			    		    }
			    		    else {
			    			    System.out.println("Wrong phone number"
			    			    		+ " or wrong mail id");

			    		    }
			    	    }
			    		break;
			        }
			    	else {
			    		System.out.println("password does not match");
			    	}
			    }
		    }
			    else if(passengerOption==3) {
			    	System.out.println("Enter userName");
			    	String userName=sc.nextLine();
			    	for(Authentication userdetails:customerLogin) {
			    		userdetails.forgetPassword(userName);
			    	}			    				    	
			    }
		}   
		else if(option==2) {
			
			int adminuser=-1;     

			sc.nextLine();
			System.out.println("1.LOGIN\n2.SIGNUP\n3.FORGETPASSWORD");
			int adminOption=sc.nextInt();
			sc.nextLine();
			if(adminOption==1) {
				System.out.println("Enter AdminName");
				String adminName=sc.nextLine();
				System.out.println("Enter password");
				String password=sc.nextLine();
				for(Authentication adminDetails:adminLogin) {
					boolean login=adminDetails.login(adminName,password);
		    		if(login) {
		    			adminuser=adminLogin.indexOf(adminDetails);
		    			System.out.println("Password is correct");
		    			break;
		    		}
		    		else {
		    			continue;
		    		}
				}
				System.out.println(adminuser);
		        if(adminuser>=0) {
			       
	
			    boolean adminLogout=true;
			    while(adminLogout) {
			        System.out.println("1.SET DISCOUNT\n2.SET BUS\n3.CHANGE PROFILE\n4.ADD BUS\n5.VIEW COMPLAINT\n6.VIEW FEEDBACK\n7.VIEW PASSENGER DETAILS\n8.SET EMPLOYEE DETAILS\n9.VIEW EMPLOYEE DETAILS\n10.PAY SALARY\n11.ADD EMPLOYEE\n12.PUT ATTENDENCE\n.13 SHOW BUS DETAILS\n14.LOGOUT");
			        int adminOpt=sc.nextInt();
			        switch(adminOpt) {
			    case(1):
			        System.out.println("1.PONGAL OFFER\n2.GREAT OFFER\n3.REPUBLIC OFFER");
			        int discountOption=sc.nextInt();
			        switch(discountOption) {
			        case(1):
			        	discount=new PongalOffer();
			            offerIdentification=1;
			            break;
			        case(2):
			        	discount=new DiwaliOffer();
			            offerIdentification=2;
			            break;
			        case(3):
			        	discount=new Offers();
			            offerIdentification=0;
			            break;
			        default:
			        	System.out.println("Invalid option");
			        }
			        break;
			    case(2)://set bus
			    	busAdmin.setBusDetails(busAvailability);
			    	break;
			    case(3)://set bus
			    	adminLogin.get(adminuser).changeProfile();
			    	break;
			    case(4)://add bus
//			    	50,"Cuddalore","Chennai","25/04/2022","AC","driverName"
			    	System.out.println("ENTER BUS NUMBER");
			        int busNumber=sc.nextInt();
			    	System.out.println("ENTER NUMBER OF SEATS");
			        int capacity=sc.nextInt();
			        System.out.println("ENTER FROM LOCATION");
			        String fromLocation=sc.nextLine();
			        System.out.println("ENTER TO LOCATION");
			        String toLocation=sc.nextLine();
			        System.out.println("ENTER DATE");
			        String date=sc.nextLine();
			        System.out.println("ENTER AC OR NON AC");
			        int acOrNonAc=sc.nextInt();
			        ac acOrNon = null;
			        if(acOrNonAc==1) {
			            ac aconNon=ac.AC;
			        }
			        else if (acOrNonAc==2) {
			        	acOrNon=ac.NONAC;
			        }
			        System.out.println("ENTER DRIVER NAME");
			        String driver=sc.nextLine();
			        System.out.println("ENTER TIME");
			        String time=sc.nextLine();
			    	busAvailability.put(busNumber,new Bus(capacity,fromLocation,toLocation,date,acOrNon,driver,time));
			    	break;
		        case(5):
			    	busAdmin.viewComplaint();
			        break;
			    case(6):
			    	busAdmin.viewFeedback(passengerFeedback);
			        break;
			    case(7)://passenger info
			        busAdmin.viewPassengerDetails();
			        break;
			    case(8):
			    	busAdmin.setEmployeeDetails();//set employee info
			    	break;
			    case(9)://view employee info
			    	busAdmin.viewEmployeeInfo();
			    	break;
			    case(10)://pay salary
			    	busAdmin.paySalary();
			    	break;
			    case(11)://add employee
			    	System.out.println("1.DRIVER\n2.SUPERVISOR");
			        int employeeOption=sc.nextInt();
			        sc.nextLine();
			        System.out.println("ENTER NAME");
			        String employeeName=sc.nextLine();
			        System.out.println("Enter age");
			        int employeeAge=sc.nextInt();
			        System.out.println("ENTER PHONE NUMBER");
			        long phoneNumber=sc.nextLong();
			        System.out.println("ENTER MAIL ID");
			        String mailId=sc.nextLine();
			        System.out.println("ENTER ADDRESS");
			        String employeeAddress=sc.nextLine();
			        System.out.println("ENTER SALARY");
			        int salary=sc.nextInt();
			        System.out.println("ENTER EXPERIENCE");
			        int exp=sc.nextInt();
			        System.out.println("ENTER PASSWORD");
			        String newPassword=sc.nextLine();
			        System.out.println("RE-ENTER PASSWORD");
			        String confirmPassword=sc.nextLine();
			        if(newPassword.equals(confirmPassword)) {
				        int busNo=0;
				        System.out.println();//continue
				        switch(employeeOption) {
				            case(1):
				            	driverDetails.put(driverDetails.size()+1, new Driver(employeeName,employeeAge,phoneNumber,mailId,employeeAddress,salary,exp,"good",attendence.PRESENT,busNo,"time","date","from","to","password"));
				                break;
				            case(2):
				            	supervisorDetails.put(supervisorDetails.size()+driverDetails.size()+1,new Supervisor(employeeName,employeeAge,phoneNumber,mailId,employeeAddress,salary,exp,"good",attendence.PRESENT, dutyCycle.DAY,password));
				            	break;
				            default:
				            	System.out.println("INVALID OPTION");
				        }
			        }
			        else {
			        	System.out.println("PASSWORD DOES NOT MATCH");
			        }
			    	break;
			    case(12):
			    	busAdmin.putAttendance();
			        break;
			    case(13):
			    	
			    	for(Map.Entry e:busAvailability.entrySet()) {
						int busNum=(int) e.getKey();
						System.out.println("Enter BusNo: "+busNum);
						busAvailability.get(busNum).showBusDetails();					
					}
			        System.out.println("ENTER BUS NO");
			        int busNum=sc.nextInt();
			        busAvailability.get(busNum).showBusDetails();
			        break;
			    case(14):
			    	adminLogin.get(adminuser).logout();
			        adminLogout=false;
			        break;
			    default:
			    	System.out.println("Invalid option");
			    }
		    }
			    }
		        else{
			        System.out.println("Please check login details");
			        }
		        }
		    else if(adminOption==2) {
		    	//sign up method
		    	
		    	System.out.println("Enter name");
		    	String name=sc.nextLine();
		    	System.out.println("Enter age");
		    	int age=sc.nextInt();
		    	sc.nextLine();
		    	System.out.println("Enter address");
		    	String address=sc.nextLine();
		    	System.out.println("Enter phone Number");
		    	long phNo=sc.nextLong();
		    	sc.nextLine();
		    	System.out.println("Enter mail id");
		    	String mail=sc.nextLine();
		    	while(true) {
		    	System.out.println("Enter Password");
		    	String password=sc.nextLine();
		    	System.out.println("Re-type password");
		    	String confirmPassword=sc.nextLine();
		    	if(password.equals(confirmPassword)){
		    		while(true) {
		    		    System.out.println("verify phone number");
		    		    long phoneNumberVerify=sc.nextLong();
		    		    System.out.println("verify mail id");
		    		    String mailId=sc.nextLine();
		    		    if(phoneNumberVerify==phNo && mail.equals(mailId)) {
		    			    user.captchaVerification();
		    			    user.iamNotRobot();
		    			    adminLogin.add(new BusAdmin(name,age,address,phNo,mail,password));	
		    			    break;
		    		    }
		    		    else {
		    			    System.out.println("Wrong phone number");

		    		    }
		    	    }
		                break;
		    }
		    	else {
		    		System.out.println("password does not match");
		    	}
		    	}
	        }
		    else if(adminOption==3) {
		    	System.out.println("Enter userName");
		    	String userName=sc.nextLine();
		    	for(Authentication admindetails:adminLogin) {
		    		admindetails.forgetPassword(userName);
		    	}
		    }
		}
		else if(option==3) {
			System.out.println("1.DRIVER\n2.SUPERVISOR");
			int employeeOption=sc.nextInt();
			sc.nextLine();
			if(employeeOption==1) {
			    System.out.println("1.LOGIN\n2.FORGETPASSWORD");
			    int driverOption=sc.nextInt();
			    sc.nextLine();
			    switch(driverOption) {
			        case(1):
			        	System.out.println("Enter userName");
			            String userName=sc.nextLine();
			            System.out.println("Enter password");
			            String password=sc.nextLine();
			            int driver=0; 
			            for(Map.Entry e:driverDetails.entrySet()) {
			            	int driverId=(int)e.getKey();
			            	if(driverDetails.get(driverId).login(userName, password)) {
			            		driver=driverId;
			            		break;
			            	}
			            	else {
			            		continue;
			            	}	
			    		}
			            if (driver>0) {
				            System.out.println("1.CHANGE PROFILE\n2.GET TODAY DUTY");
				            int loginOptin=sc.nextInt();
				            if(loginOptin==1) {
				            	driverDetails.get(driver).changeProfile();
				            }
				            else {
				            	driverDetails.get(driver).showDutyDetails();
	//			            	
				            }
			            }
			            else {
			            	System.out.println("Invalid login details");
			            }
			            break;
			        case(2):
			        	System.out.println("Enter userName");
			    	    String username=sc.nextLine();
			    	    int driverId=0;
			    	    for(Map.Entry e:driverDetails.entrySet()) {
			    	    	int id=(int) e.getKey();
			    			if(username.equals(driverDetails.get(id).getName())) {
			    				driverDetails.get(id).forgetPassword(username);
			    			}
			    		}
			    	    break;	  
			    }
			   
			
			}
			else if(employeeOption==2){
				System.out.println("1.LOGIN\n2.FORGETPASSWORD");
			    int supervisorOption=sc.nextInt();
			    sc.nextLine();
			    switch(supervisorOption) {
			        case(1):
			        	System.out.println("Enter userName");
			            String userName=sc.nextLine();
			            System.out.println("Enter password");
			            String password=sc.nextLine();
			            int supervisor=0; 
			            for(Map.Entry e:supervisorDetails.entrySet()) {
			            	int supervisorId=(int)e.getKey();
			            	
			            	if(supervisorDetails.get(supervisorId).login(userName, password)) {
			            		supervisor=supervisorId;
			            		break;
			            	}
			            	else {
			            		continue;
			            	}
			    			
			    		}
			            if (supervisor>0) {
				            System.out.println("1.CHANGE PROFILE\n2.GET TODAY DUTY");
				            int loginOptin=sc.nextInt();
				            if(loginOptin==1) {
				            	supervisorDetails.get(supervisor).changeProfile();
				            }
				            else {
				            	supervisorDetails.get(supervisor).showDutyDetails();
	//			            	
				            }
			            }
			            else {
			            	System.out.println("Invalid login details");
			            }
			            break;
			        case(2):
			        	System.out.println("Enter userName");
			    	    String username=sc.nextLine();
			    	    int supervisorId=0;
			    	    for(Map.Entry e:supervisorDetails.entrySet()) {
			    	    	int id=(int) e.getKey();
			    			if(username.equals(supervisorDetails.get(id).getName())) {
			    				supervisorDetails.get(id).forgetPassword(username);
			    			}
			    		}
			    	    break;	  
			    }
			}
		}
	    }
	}
}