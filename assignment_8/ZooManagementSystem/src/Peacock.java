
public class Peacock extends Bird
{
	
	public Peacock(String name,float weight,int age,int id)
	{
		this.name=name;
		this.id=id;
		this.weight=weight;
		this.age=age;
		this.sound="roars";
	}
	
	
	@Override
	public String getSound() {
		
				
		return "screams";
	}
	

}