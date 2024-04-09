package railwayticket;
import java.util.*;

public class functions {
	passenger p;
	bookticket book=new bookticket();
	static int lowerid=0;
	static int middleid=0;
	static int upperid=0;
	static int lowerbirth=1;
	static int middlebirth=1;
	static int upperbirth=1;
	static int racavai=2;
	static int wlavai=2;
	static int racindex=0;
	static int wlindex=0;
	static int anotherl=0;
	static int anotherm=0;
	static int anotheru=0;
	
	static int[] lower=new int[lowerbirth];
	static int[] middle=new int[middlebirth];
	static int[] upper=new int[upperbirth];
	static HashMap<Integer,passenger> hash=new HashMap<Integer,passenger>();
	static ArrayList<passenger> rac=new ArrayList<>();
	static ArrayList<passenger> wl=new ArrayList<>();
	
	functions(passenger s) {
		this.p=s;
	}
	
	functions(){
		System.out.println("--------------------");
	}


	public void booking() {
		if(p.berthpref.equals("L") && lowerbirth>0) {
			p.id=book.id++;
			p.alloted+=lowerid+1+""+"L";
			p.berthno=lowerid+1;
			lower[lowerid++]=p.id;
			anotherl++;
			hash.put(p.id, p);
			p.berth="L";
			System.out.println("Successfully booked lowerbirth");
			lowerbirth--;
			System.out.println("--------------------");
			lowerid=anotherl;
		}
		else if(p.berthpref.equals("M") && middlebirth>0){
			p.id=book.id++;
			p.alloted+=middleid+1+""+"M";
			p.berthno=middleid+1;
			middle[middleid++]=p.id;
			anotherm++;
			hash.put(p.id, p);
			p.berth="M";
			System.out.println("Successfully booked middlebirth");
			middlebirth--;
			System.out.println("--------------------");
			middleid=anotherm;
		}
		else if(p.berthpref.equals("U") && upperbirth>0) {
			p.id=book.id++;
			p.alloted+=upperid+1+""+"U";
			p.berthno=upperid+1;
			upper[upperid++]=p.id;
			anotheru++;
			hash.put(p.id, p);
			p.berth="U";
			System.out.println("Successfully booked upperbirth");
			upperbirth--;
			System.out.println("--------------------");
			upperid=anotheru;
		}
		else if(lowerbirth>0) {
			p.id=book.id++;
			p.alloted+=lowerid+1+""+"L";
			p.berthno=lowerid+1;
			lower[lowerid++]=p.id;
			hash.put(p.id, p);
			p.berth="L";
			System.out.println("Sorry we dont have "+p.berthpref+ "So we alloted lowerbirth for u");
			lowerbirth--;
			System.out.println("--------------------");
		}
		else if(middlebirth>0){
			p.id=book.id++;
			p.alloted+=middleid+1+""+"M";
			p.berthno=middleid+1;
			middle[middleid++]=p.id;
			hash.put(p.id, p);
			p.berth="M";
			System.out.println("Sorry we dont have "+p.berthpref+ "So we alloted middlebirth for u");
			middlebirth--;
			System.out.println("--------------------");
		}
		else if(upperbirth>0) {
			p.id=book.id++;
			p.alloted+=upperid+1+""+"U";
			p.berthno=upperid+1;
			upper[upperid++]=p.id;
			hash.put(p.id, p);
			p.berth="U";
			System.out.println("Sorry we dont have "+p.berthpref+ "So we alloted upperbirth for u");
			upperbirth--;
			System.out.println("--------------------");
		}
		else if((racavai>0)){
			p.id=book.id++;
		    p.alloted+=racindex+1+""+"RAC";
		    rac.add(p);
		    hash.put(p.id, p);
		    p.berth="RAC";
		    racindex++;
		    System.out.println("Sorry we dont have enough seats we alloted a rac ticket for u");
		    racavai--;
		    System.out.println("--------------------");
		  }
		else if((wlavai>0)) {
			p.id=book.id++;
		    p.alloted+=wlindex+1+""+"WL";
		    wl.add(p);
		    hash.put(p.id, p);
		    p.berth="WL";
		    wlindex++;
		    System.out.println("Sorry we dont have enough seats and rac you are in waiting list");
		    wlavai--;
		    System.out.println("--------------------");
		}
	}
	
	public void cancelticket() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id to cancel the ticket");
		int a=sc.nextInt();
		passenger p=hash.get(a);
		if(p.berth=="L") {
			
			if(!rac.isEmpty()) {
			passenger ref=rac.get(0);
			rac.remove(0);
			lower[p.berthno-1]=ref.id;
			ref.berthno=p.berthno;
			ref.alloted=p.berthno+"L";
			ref.berth="L";
			}
			else {
				lowerbirth++;
				lowerid=p.berthno-1;
			}
			
			hash.remove(p.id);
			
			if(!wl.isEmpty()) {
			passenger ref1=wl.get(0);
			rac.add(wl.remove(0));
			ref1.berth="RAC";
			ref1.berthno=rac.size()-1;
			ref1.alloted=rac.size()-1+"RAC";
			wlavai++;
			}
			else {
				racavai++;
			}
			
		}
		else if(p.berth=="M") {
			
			if(!rac.isEmpty()) {
			passenger ref=rac.get(0);
			rac.remove(0);
			middle[p.berthno-1]=ref.id;
			ref.berthno=p.berthno;
			ref.alloted=p.berthno+"M";
			ref.berth="M";
		    
			}
			else {
				middlebirth++;
				middleid=p.berthno-1;
			}
			
			if(!wl.isEmpty()) {
			  passenger ref1=wl.get(0);
			  rac.add(wl.remove(0));
			  ref1.berth="RAC";
			  ref1.berthno=rac.size()-1;
			  ref1.alloted=rac.size()-1+"RAC";
			  wlavai++;
			}
			else {
				racavai++;
			}
			
			hash.remove(p.id);
		}
		else if(p.berth=="U") {
			
			if(!rac.isEmpty()) {
			passenger ref=rac.get(0);
			rac.remove(0);
			upper[p.berthno-1]=ref.id;
			ref.berthno=p.berthno;
			ref.alloted=p.berthno+"U";
			ref.berth="U";
			}
			else {
			    upperbirth++;
				upperid=p.berthno-1;
			}
			
			hash.remove(p.id);
			
			if(!wl.isEmpty()) {
			  passenger ref1=wl.get(0);
			  rac.add(wl.remove(0));
			  ref1.berth="RAC";
			  ref1.berthno=rac.size()-1;
			  ref1.alloted=rac.size()-1+"RAC";
			  wlavai++;
			}
			else {
				racavai++;
			}
		}
		else if(p.berth=="RAC") {
			
			if(!wl.isEmpty()) {
			  passenger ref1=wl.get(0);
			  rac.add(wl.remove(0));
			  ref1.berth="RAC";
			  ref1.berthno=rac.size()-1;
			  ref1.alloted=rac.size()-1+"RAC";
			  wlavai++;
		   }
			else {
				rac.remove(p);
				racavai++;
			}
			hash.remove(p.id);
		}
		else if(p.berth=="WL") {
			wl.remove(p);
			wlavai++;
			hash.remove(p.id);
		}
		
	}
}
