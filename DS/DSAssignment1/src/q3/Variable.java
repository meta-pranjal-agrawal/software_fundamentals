package q3;

public class Variable {
	private char variable;
	private int degree;
	private Variable nextVariable;

	
	Variable(char variable, int degree) throws Exception{
		
		if (degree<0){
			throw new Exception ("Degree cannot be less than zero");
		}
		
		this.variable = variable;
		this.degree = degree;
	}
	
	
	public char getVariable() {
		return variable;
	}
	
	public void setVariable(char variable) {
		this.variable = variable;
	}

	public int getDegree() {
		return degree;
	}

	public Variable getNextVariable() {
		return nextVariable;
	}

	public void setNextVariable(Variable nextVariable) {
		this.nextVariable = nextVariable;
	}
}
