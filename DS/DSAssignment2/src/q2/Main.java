package q2;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Main mainObject = new Main();
		mainObject.userInput ();	
	}
	
	private void userInput()
	{
		System.out.println("Enter size of queue : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		Queue queueObject = new Queue(size);
		try 
		{
			while (true)
			{
				System.out.println("Enter 1 to enqueue and 2 to dequeue and 3 to display elements");
				int choice = scanner.nextInt();
				if (choice==1)
				{
					System.out.println("Enter Element to be pushed");
					int element = scanner.nextInt();
					queueObject.enQueue(element);
				}
				else if (choice==2)
				{
					queueObject.deQueue();
				}
				else if (choice==3)
				{
					queueObject.display();
				}
				else
				{
					throw new Exception ("Invalid choice");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
