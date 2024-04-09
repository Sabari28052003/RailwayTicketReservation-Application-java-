package railwayticket;
import java.util.*;

public class bookticket {
   
   //Id for the user which increments when the user books a ticket
   static int id=1;
   
   //It is for infinite loop until the user selects exit 
   boolean refer=true;
   
   //It if a function for booking a ticket
   public static void bookticket() {
	   
	   //Creating a object for functions class
	   functions mm=new functions();
	   
	   //It automatically print if there is no ticket available when we click a bookticket without getting any information..
	   if(mm.lowerbirth==0 && mm.upperbirth==0 && mm.middlebirth==0 && mm.racavai==0 && mm.wlavai==0) {
		   System.out.println("NO tickets available");
	   }
	   else {
		 //Getting a information from the user and calling a passenger class with a parameterized constructor and object for functions
		 //and calling a booking method.
		 Scanner MM=new Scanner(System.in);
		 System.out.println("Enter the name");
		 String name=MM.next();
		 System.out.println("Enter the age");
		 int age=MM.nextInt();
		 System.out.println("Enter the Berthpreference");
		 String berth=MM.next();
		 passenger p=new passenger(name,age,berth);
		 functions n=new functions(p);
		 n.booking();
	  }
   }
   
   
	   public static void checkstatus() {
		   Scanner nm=new Scanner(System.in);
		   System.out.println("Select the id");
		   int id=nm.nextInt();
		   passenger dis=functions.hash.get(id);
		   if(dis.berth.equals("L") || dis.berth.equals("M") || dis.berth.equals("U")) {
		   System.out.println(dis.name);
		   System.out.println(dis.age);
		   System.out.println(dis.alloted);
		   System.out.println("--------------------");
		   }
		   else if(dis.berth.equals("RAC")) {
			   functions nmm=new functions();
			   System.out.println(dis.name);
			   System.out.println(dis.age);
			   int val=nmm.rac.indexOf(dis)+1;
			   System.out.println(dis.berth+""+val);
		   }
		   else if(dis.berth.equals("WL")) {
			   functions nmm=new functions();
			   System.out.println(dis.name);
			   System.out.println(dis.age);
			   int val=nmm.wl.indexOf(dis)+1;
			   System.out.println(dis.berth+""+val);
		   }
	   }
	   
	   public static void availableticket() {
		   functions kk=new functions();
		   System.out.println("Lowerbirth: "+kk.lowerbirth);
		   System.out.println("Middlebirth: "+kk.middlebirth);
		   System.out.println("Upperbirth: "+kk.upperbirth);
		   System.out.println("RAC "+kk.racavai);
		   System.out.println("WL "+kk.wlavai);
	   }
   
   public static void main(String[] args) {
	   Scanner SC=new Scanner(System.in);
	   boolean ref=true;
	   while(ref) {
		   System.out.println("Enter the functions");
		   System.out.println("1.Booktickets");
		   System.out.println("2.Check status");
		   System.out.println("3.Show available tickets");
		   System.out.println("4.Cancel a Ticket");
		   System.out.println("5.Exit");
		   int a=SC.nextInt();
		   switch (a) {
		   case 1:
			  bookticket();
			  break;
		   case 2:
		      checkstatus();
		      break;
		   case 3:
			   availableticket();
			   break;
		   case 4:
			   functions func=new functions();
			   func.cancelticket();
			   break;
		   case 5:
			   System.out.println("Thank u visit again");
			   ref=false;
			   break;
		   default:
		   break;
		   }
			   
	   }
   }
}
