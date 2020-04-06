package q2;

public class Queue {
	private int[] queue;
	private int front;
	private int rear;
	private int sizeOfQueue;

	//constructor
	public Queue(int sizeOfQueue)
	{
		this.sizeOfQueue = sizeOfQueue;
		this.queue = new int[sizeOfQueue];
		this.front = -1;
		this.rear = -1;
	}

	/*
	 * function to add element to queue
	 * @param element to be added
	 * @throw Exception when queue is full
	 */

	public void enQueue(int element) throws Exception 
	{

		if (isFull()){
			throw new Exception ("Queue is full");
		}

		else if (isEmpty())
		{
			rear = 0;
			front = 0;
		}
		else
		{
			rear =  (rear+1) % sizeOfQueue;
		}
		
		queue[rear] = element;
	}

	/*
	 * function to remove element from queue
	 * @throw Exception when queue is empty
	 */
	public int deQueue() throws Exception 
	{
		
		if (isEmpty())
		{
			throw new Exception ("Queue is empty");	
		}

		int element = queue[front];
		if (front == rear)
		{
			front = -1;
			rear = -1;
		}
		front = (front+1) % sizeOfQueue;
		return element;
	}

	/*
	 * function to check if queue is empty 
	 * @return true if queue is empty , false otherwise
	 */

	public Boolean isEmpty()
	{
		if (rear == -1){
			return true;
		}
		return false;
	}

	/*
	 * function to check if queue is full
	 * @return true if queue is full, false otherwise
	 */

	public boolean isFull() 
	{
		if (((front == 0) && (rear == sizeOfQueue-1)) || (front == (rear+1))) 
		{
			return true;
		}
		return false;
	}	
	
	/**
	 * function to display all the elements of the queue
	 * @throws Exception
	 */
	public void display() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception ("Queue is empty");
		}
		else
		{
			int i=front;
			while(i!=rear)
			{
				System.out.println(queue[i]);
				i=(i+1) % sizeOfQueue;
			}
			System.out.println(queue[i]);
		}
		
	}
}
