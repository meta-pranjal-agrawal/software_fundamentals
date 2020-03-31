package q1;

public class Stack 
{
		//size of stack
		private int sizeOfStack;
		private String[] stack;
		
		//pointing to the latest added element of stack
		private int top = -1;

		//constructor
		public Stack(int length) {
			this.sizeOfStack = length;
			this.stack = new String[sizeOfStack];
		}

		/*
		 * function to push element into stack
		 * @param element is the element to be pushed to stack
		 */
		
		public void push(String element) throws Exception 
		{
			if (top==(sizeOfStack-1)){
				throw new Exception ("Stack is full");
			}
			top = top+1;
			stack[top] = element;
		}

		/*
		 * function to remove element from stack
		 * @return popped element
		 * @throws exception if stack is empty
		 */
	
		public String pop() throws Exception 
		{
			
			if (top==-1){
				throw new Exception ("Stack is empty");
			}
			String poppedElement = stack[top];
			top = top-1;
			return poppedElement;
		}
		
		/*
		 * function to check whether stack is empty
		 * @return true if stack is empty, false otherwise
		 */
		
		public Boolean isEmpty()
		{
			if (top==-1){
				return true;
			}
			return false;
		}
		
		/*
		 * function to return the topmost element of stack.
		 */
	
		public String peek() throws Exception
		{
			if (top==-1){
				throw new Exception ("Stack is empty");
			}
			return stack[top];
		}
}
