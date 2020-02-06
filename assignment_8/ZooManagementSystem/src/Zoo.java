import java.util.ArrayList;
import java.util.List;


public class Zoo 
{
	int id=0;
	List<Zone> zoneList= new ArrayList<Zone>();
	
	public boolean addZone(String category,int limitOfCages,boolean hasPark,boolean hasCanteen)
	{
		Zone z1= new Zone(category,limitOfCages,hasPark,hasCanteen);
		zoneList.add(z1);
		return true;
	}
	
	public boolean addCage(String category,int capacity,String type)
	{
		for(int i=0;i<zoneList.size();i++)
		{
			if(zoneList.get(i).category.equalsIgnoreCase(category) && zoneList.get(i).limitOfCages>zoneList.get(i).numberOfCages)
			{
				zoneList.get(i).cageList.add(new Cage(type,capacity));
				zoneList.get(i).numberOfCages++;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addAnimal(String category,String type,String name,int age,float weight)
	{
		for(int i=0; i<zoneList.size(); i++)
		{
			for(int j=0;j<zoneList.get(i).cageList.size();j++)
			{
				if(zoneList.get(i).category.equalsIgnoreCase(category) && zoneList.get(i).cageList.get(j).capacity > zoneList.get(i).cageList.get(j).animalCount)
				{
					if(type.equalsIgnoreCase("lion"))
					{
						id++;
						zoneList.get(i).cageList.get(j).cage.add(new Lion(name,weight,age,id));
						return true;
					}
					if(type.equalsIgnoreCase("peacock"))
					{
						id++;
						zoneList.get(i).cageList.get(j).cage.add(new Peacock(name,weight,age,id));
						return true;
					}
					if(type.equalsIgnoreCase("snake"))
					{
						id++;
						zoneList.get(i).cageList.get(j).cage.add(new Snake(name,weight,age,id));
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean removeAnimal(String category,String type,String name)
	{
		
		for(int i=0; i<zoneList.size(); i++)
		{
			for(int j=0;j<zoneList.get(i).cageList.size();j++)
			{
				
				if(zoneList.get(i).category.equalsIgnoreCase(category) && zoneList.get(i).cageList.get(j).type.equalsIgnoreCase(type))
				{
					
					for(int k=0;k<zoneList.get(i).cageList.get(j).cage.size();k++)
					{
						if(zoneList.get(i).cageList.get(j).cage.get(k).name.equals(name))
						{
							
							zoneList.get(i).cageList.get(j).cage.remove(zoneList.get(i).cageList.get(j).cage.get(k));
							zoneList.get(i).cageList.get(j).animalCount--;
							return true;
						}
					}
					
				}
				
			}
		}
		
		
		
		return false;
	}
	
	
	
	public void display()
	{
		for(int i=0;i<zoneList.size();i++){
			System.out.println("Zone:"+(i+1)+","+zoneList.get(i).category);
			for(int j=0;j<zoneList.get(i).cageList.size();j++){
				System.out.println("\t\tCage:"+(j+1)+","+zoneList.get(i).cageList.get(j).type);
				for(int k=0;k<zoneList.get(i).cageList.get(j).cage.size();k++){
					System.out.println("\t\t\t\tId : "+zoneList.get(i).cageList.get(j).cage.get(k).id);
					System.out.println("\t\t\t\tName : "+zoneList.get(i).cageList.get(j).cage.get(k).name);
					System.out.println("\t\t\t\tAge :"+zoneList.get(i).cageList.get(j).cage.get(k).age);
					System.out.println("\t\t\t\tWeight : "+zoneList.get(i).cageList.get(j).cage.get(k).weight);
				}
			}
		}
	}
	
	
	public static void main(String arg[])
	{
		Zoo zoo=new Zoo();
		
		System.out.println("adding an animal");
		zoo.addZone("mammal", 10, true, true);
		zoo.addCage("mammal", 10, "lion");
		zoo.addAnimal("mammal", "Lion", "shersingh", 8, 200);
		
		zoo.addZone("reptile", 10, true, false);
		zoo.addCage("reptile", 10, "snake");
		zoo.addAnimal("reptile", "snake", "saanp", 4, 10);
		
		zoo.addZone("bird", 10, true, true);
		zoo.addCage("bird", 10, "peacock");
		zoo.addAnimal("bird", "peacock", "mor", 6, 10);
		zoo.display();
		
		zoo.removeAnimal("mammal", "lion", "shersingh");
		System.out.println("jkdscnhjksdjckjs");
		zoo.display();
	}
	


}
