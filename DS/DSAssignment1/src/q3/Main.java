package q3;

public class Main 
{
	public static void main(String[] args) 
	{
		
		Main object = new Main();
		
		try{
			Polynomial polynomial=object.polynomialInput();
			polynomial.showPolynomial();
			System.out.println("\nDegree of Polynomial : " +polynomial.degreeOfPolynomial());
		}
		
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	private Polynomial polynomialInput() throws Exception
	{
		Polynomial polynomial = new Polynomial();
		
		//taking input for first term
		TermOfPolynomial term1 = new TermOfPolynomial(1);
		term1.addVariableToTerm(new Variable('x',2));
		term1.addVariableToTerm(new Variable('y',3));
		
		
		polynomial.addTermToPolynomial(term1);
		
		
		TermOfPolynomial term2 = new TermOfPolynomial(2);
		term2.addVariableToTerm(new Variable('x',4));
		term2.addVariableToTerm(new Variable('y',8));

		
		polynomial.addTermToPolynomial(term2);
		
		TermOfPolynomial term3 = new TermOfPolynomial(3);
		
		
		polynomial.addTermToPolynomial(term3);
		
		return polynomial;
	}
}
