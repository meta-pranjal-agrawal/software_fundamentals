import java.util.Scanner;


public class Area 
{
	/**
	 * 
	 * @param base of triangle
	 * @param height of triangle
	 * @return Area of triangle
	 */
	
	public double areaOfTriangle(double trianglebase,double triangleheight)
	{
		double areaoftriangle;
		areaoftriangle= 0.5*trianglebase*triangleheight;
		return areaoftriangle;
	}
	
	
	/**
	 * 
	 * @param width of rectangle
	 * @param height of rectangle
	 * @return Area of rectangle
	 */

	public double areaOfRectangle(double widthrectangle, double heightrectangle)
	{
		double areaRectangle=widthrectangle*heightrectangle;
		return areaRectangle;
	}
	
	/**
	 * 
	 * @param side of square
	 * @return area of square
	 */
	
	public double areaOfSquare(double sideofsquare)
	{
		double areasquare=sideofsquare*sideofsquare;
		return areasquare;
	}
	
	/**
	 * 
	 * @param radius of circle
	 * @return Area of circle
	 */
	public double areaOfCircle(double radiusofcircle)
	{
		
		double areacircle = (22.0/7)*radiusofcircle*radiusofcircle;
		return areacircle;
	}

	public static void main(String[] args) 
	{
		Area area= new Area();
		Scanner sc= new Scanner(System.in);
		System.out.println("Calculating area of triangle..");
		System.out.println("enter the base of triangle");
		
		double baseoftriangle;
		try
		{
			baseoftriangle=sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			baseoftriangle=0;
			System.exit(0);
		}
		System.out.println("enter the height of triangle");
		double heightoftriangle;
		try
		{
			heightoftriangle=sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			heightoftriangle=0;
			System.exit(0);
		}
		
		
		// calls the area of triangle method
		double areaoftriangle= area.areaOfTriangle(baseoftriangle,heightoftriangle);
		System.out.println("The area of triangle="+areaoftriangle);
		
		
		System.out.println("Calculating area of Rectangle..");
		System.out.println("enter the width of rectangle");
		double widthrectangle;
		try
		{
			widthrectangle=sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			widthrectangle=0;
			System.exit(0);
		}
		
		System.out.println("enter the height of triangle");
		double heightrectangle;
		try
		{
			heightrectangle=sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			heightrectangle=0;
			System.exit(0);
		}
		
		//calls the area of rectangle method
		double areaRectangle=area.areaOfTriangle(widthrectangle,heightrectangle);
		System.out.println("The area of rectangle="+areaRectangle);
		
		System.out.println("Calculating area of Sqaure..");
		System.out.println("enter the side of square");
		double sideofsquare;
		try
		{
			sideofsquare=sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			sideofsquare=0;
			System.exit(0);
		}
		
		// calls the area of square method
		double areasquare=area.areaOfSquare(sideofsquare);
		System.out.println("The area of sqaure="+areasquare);
		
		System.out.println("Calculating area of Circle..");
		System.out.println("enter the radius of circle");
		double radiusofcircle;
		try
		{
			radiusofcircle=sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("please enter correct input");
			radiusofcircle=0;
			System.exit(0);
		}
		
		
		//calls the area of circle method
		double areacircle=area.areaOfCircle(radiusofcircle);
		System.out.println("The area of circle="+areacircle);
		
	}

}
