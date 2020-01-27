
public final class Poly 
{
	final Term poly[];
	
	public Poly(int numberOfTerms,int []coefficients,int[] power)
	{
		poly= new Term[numberOfTerms];
		
		for(int i=0; i<numberOfTerms; i++)
		{
			poly[i]=new Term(coefficients[i],power[i]);
		}
	}
	
	/**
	 * 
	 * @return coefficients of polynomial
	 */
	public int[] getCoefficients()
	{
		
		int []coff=new int[poly.length];
		for(int i=0;i<coff.length;i++)
		{
			coff[i]=poly[i].getCoefficients();
		}
		return coff;
	}
	/**
	 * 
	 * @return powers of polynomial
	 */
	public int[] getPower()
	{
		int []power=new int[poly.length];
		for(int i=0;i<power.length;i++)
		{
			power[i]=poly[i].getPower();
		}
		return power;
	}
	
	/**
	 * 
	 * @param polynomial
	 * @return simplified polynomial like sorted powers and coefficients of similar powers added
	 */
	public static Poly simplify(Poly polynomial)
	{
		if(polynomial.poly.length ==0)
		{
			return new Poly(0,new int[]{0},new int[]{0});
		}
		int count=0;
		for(int i=0;i<polynomial.poly.length-1;i++)
		{
			for(int j=i+1;j<polynomial.poly.length;j++)
			{
				if(polynomial.poly[j].coefficients==0)
				{
					polynomial.poly[j].power = 0;
				}
				if(polynomial.poly[i].coefficients ==0)
				{
					polynomial.poly[i].power= 0;
				}
				if((polynomial.poly[i].power == polynomial.poly[j].power) && (polynomial.poly[j].coefficients!=0 && polynomial.poly[i].coefficients!=0 ))
				{
					count++;
					polynomial.poly[i].coefficients = polynomial.poly[i].coefficients + polynomial.poly[j].coefficients;
					polynomial.poly[j].coefficients = 0;
					polynomial.poly[j].power = 0;
				}
			}
		}
		
		

		for(int i=0; i<polynomial.poly.length-1 ;i++)
		{
			for(int j=i+1; j<polynomial.poly.length; j++)
			{
				/*if(polynomial.poly[j].coefficients==0 || polynomial.poly[i].coefficients ==0)
				{
					continue;
				}*/
				if(polynomial.poly[i].power < polynomial.poly[j].power)
				{
					int tempcoeff = polynomial.poly[j].coefficients;
					int temppow = polynomial.poly[j].power;
					polynomial.poly[j].coefficients = polynomial.poly[i].coefficients;
					polynomial.poly[j].power = polynomial.poly[i].power;
					polynomial.poly[i].coefficients = tempcoeff;
					polynomial.poly[i].power = temppow;
				}
				if(polynomial.poly[i].power == polynomial.poly[j].power)
				{
					if(polynomial.poly[i].coefficients < polynomial.poly[j].coefficients)
					{
						int tempcoeff = polynomial.poly[j].coefficients;
						int temppow = polynomial.poly[j].power;
						polynomial.poly[j].coefficients = polynomial.poly[i].coefficients;
						polynomial.poly[j].power = polynomial.poly[i].power;
						polynomial.poly[i].coefficients = tempcoeff;
						polynomial.poly[i].power = temppow;
					}
				}
			}
		}
		
		Poly simplified;
		int coeff[]= new int[polynomial.poly.length-count];
		int power[]= new int[polynomial.poly.length-count];
		
		for(int i=0; i<coeff.length; i++)
		{
			if(polynomial.poly[i].coefficients!= 0)
			{
				coeff[i]= polynomial.poly[i].coefficients;
				power[i]= polynomial.poly[i].power;
			}
			
		}
		
		simplified=new Poly(coeff.length,coeff,power);
		
		/*
		System.out.println("simplified poly:");
		
		for(int i=0; i<simplified.poly.length; i++)
		{
			if(simplified.poly[i].power!= 0)
				System.out.print(simplified.poly[i].coefficients+"x"+"^"+simplified.poly[i].power+"+");
			else
				System.out.print(simplified.poly[i].coefficients);
			
		}
		System.out.println();*/
		
		return simplified;
	}
	
	
	/**
	 * 
	 * @param poly1
	 * @param poly2
	 * @return sum of 2 polynomials
	 */
	public static Poly addPoly(Poly poly1,Poly poly2)
	{
		if(poly1.poly.length==0 && poly2.poly.length==0)
		{
			return new Poly(0,new int[]{0},new int[]{0});
		}
		
		Poly poly3;
		int count=0;
		for(int i=0; i<poly1.poly.length; i++)
		{
			for(int j=0; j<poly2.poly.length; j++)
			{
				if(poly1.poly[i].power==poly2.poly[j].power)
					count++;
			}
		}
		
		int sumCoefficient[]= new int[poly1.poly.length+poly2.poly.length-count];
		int sumPower[]= new int[poly1.poly.length+poly2.poly.length-count];
		int k=0;
		
		for(int i=0; i<poly1.poly.length; i++)
		{
			int flag=0;
			for(int j=0; j<poly2.poly.length; j++)
			{
				if(poly1.poly[i].power == poly2.poly[j].power)
				{
					flag=1;
					sumCoefficient[k] =poly1.poly[i].coefficients+poly2.poly[j].coefficients;
					sumPower[k] = poly1.poly[i].power;
					k++;
					poly2.poly[j].coefficients = 0;
				}
			}
			if(flag==0)
			{
				sumCoefficient[k] = poly1.poly[i].coefficients;
				sumPower[k] = poly1.poly[i].power;
				k++;
			}
		}
		
		for(int i=0; i<poly2.poly.length; i++)
		{
			if(poly2.poly[i].coefficients!=0)
			{
				sumCoefficient[k] = poly2.poly[i].coefficients;
				sumPower[k] = poly2.poly[i].power;
				k++;
			}	
				
		}
		poly3= new Poly(sumCoefficient.length,sumCoefficient,sumPower);
		
		
		poly3=simplify(poly3);
		
		/*System.out.print("sum=");
		for(int i=0; i<poly3.poly.length; i++)
		{
			if(poly3.poly[i].power!= 0)
				System.out.print(poly3.poly[i].coefficients+"x"+"^"+poly3.poly[i].power+"+");
			else
				System.out.print(poly3.poly[i].coefficients);
			
		}
		System.out.println();*/
		
		return poly3;
		
	}
	
	
	/**
	 * 
	 * @param value
	 * @param poly
	 * @return value of polynomial at a value
	 */
	public static float evaluate(float value,Poly poly)
	{
		if(poly.poly.length==0)
		{
			return 0.0f;
		}
		float sum=0;
		for(int i=0; i<poly.poly.length; i++)
		{
			sum =(float) ((float) sum+ poly.poly[i].coefficients * Math.pow(value, poly.poly[i].power));
		}
		
		return sum;
	}
	
	/**
	 * 
	 * @param poly1
	 * @param poly2
	 * @return the multiplication of 2 polynomials
	 */
	public static Poly multiplyPoly(Poly poly1,Poly poly2)
	{
		if(poly1.poly.length==0 || poly2.poly.length==0)
		{
			return new Poly(0,new int[]{0},new int[]{0});
		}
		
		int []multipliedCoefficients=new int[poly1.poly.length * poly2.poly.length];
		int []multipliedPowers=new int[poly1.poly.length * poly2.poly.length];
		int k=0;
		
		for(int i=0; i<poly1.poly.length; i++)
		{
			
			for(int j=0; j<poly2.poly.length;j++)
			{
				multipliedCoefficients[k] = (poly1.poly[i].coefficients) * (poly2.poly[j].coefficients);
				multipliedPowers[k] = poly1.poly[i].power + poly2.poly[j].power;
				k++;
			}
		}
		
		Poly multipliedPoly=new Poly(multipliedCoefficients.length,multipliedCoefficients,multipliedPowers);
		
		
		
		
		multipliedPoly=simplify(multipliedPoly);
		
		/*System.out.println("after simplify:");
		
		for(int i=0; i<multipliedPoly.poly.length; i++)
		{
			if(multipliedPoly.poly[i].power!= 0)
				System.out.print(multipliedPoly.poly[i].coefficients+"x"+"^"+multipliedPoly.poly[i].power+"+");
			else
				System.out.print(multipliedPoly.poly[i].coefficients);
			
		}
		System.out.println();*/
		
		return multipliedPoly;
	}
	
	/**
	 * 
	 * @param poly
	 * @return highest degree of polynomial
	 */
	public static int degree(Poly poly)
	{
		if(poly.poly.length==0)
			return 0;
		
		return poly.poly[0].power;
	}

	public static void main(String[] args)
	{
		int coeff1[]=new int[]{2,3,1};
		int pow1[]=new int[]{3,1,0};
		Poly poly1= new Poly(coeff1.length,coeff1,pow1);
		poly1=simplify(poly1);
		
		int coeff2[]=new int[]{3,2};
		int pow2[]=new int[]{1,0};
		Poly poly2=new Poly(coeff2.length,coeff2,pow2);
		poly2=simplify(poly2);
		
		//addPoly is affecting poly 2 in main so cannot call multiplyPoly and addPoly simultaneously
		//Poly sum=addPoly(poly1,poly2);
		
		//float evaluation=evaluate(2.2f,poly1);
		//System.out.println("value at 2.2="+evaluation);
		
		Poly multipliedPoly=multiplyPoly(poly1, poly2);
		
		int degree=degree(poly1);
		System.out.println("degree of p1="+degree);
		

	}

	
	
}