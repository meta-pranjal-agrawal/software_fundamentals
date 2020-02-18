import java.util.ArrayList;
import java.util.List;


public class Zone 
{
	 int limitOfCages;
	 int numberOfCages=0;
	 boolean hasPark;
	 boolean hasCanteen;
	 String category;
	 List<Cage> cageList= new ArrayList<Cage>();
	 
	 
	 public Zone(String category,int limitOfCages,boolean hasPark,boolean hasCanteen)
	 {
		 this.limitOfCages=limitOfCages;
		 this.category=category;
		 this.hasCanteen=hasCanteen;
		 this.hasPark=hasPark;
	 }
	 
	 
	 
}
