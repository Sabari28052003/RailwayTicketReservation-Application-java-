package railwayticket;

//Creating a class for a passenger with the required constraints

public class passenger {
	//id for user id which should be unique
    int id;
    //user name 
	String name="";
	//user age
	int age;
	//user brethpreference
	String berthpref;
	//user alloted seat See full code for the better clarity
    String alloted;
    //user berth which he is alloted it can be (L || M || U || RAC || WL)
    String berth;
    //user berth number (For Eg:1RAC)
    int berthno;
    
    //constructor for empty constructor
    public passenger(){
	   System.out.println("Can u please enter details");
	  }
   
   //parameterized constructor with the required parameters.
   public passenger(String name,int age,String berthpref){
	   this.name=name;
	   this.age=age;
	   this.berthpref=berthpref;
	   alloted="";
	   berth="";
	   berthno=0;
	   
   }
}