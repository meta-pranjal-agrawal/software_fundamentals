import java.util.*;




public class JobScheduler
{
	public int []completion_time_method(int [][] processes,int number_of_processes)
	{
		int completion_time[]= new int[number_of_processes];
		completion_time[0]=processes[0][1];
		int total_time=processes[0][1];
		for(int i=1;i<number_of_processes;i++)
		{
			if(processes[i][0]<=total_time)
			{
				total_time=total_time+processes[i][1];
				completion_time[i]=total_time;
			}
			else
			{
				total_time=(processes[i][0]+processes[i][1]);
				completion_time[i]=total_time;
			}
			
		}
		return completion_time;
	}
	
	
	public int []turn_around_time_method(int []completion_time,int [][]processes)
	{
		int turn_around_time[]=new int[completion_time.length];
		
		for(int i=0;i<completion_time.length;i++)
		{
			turn_around_time[i]=completion_time[i]-processes[i][0];
		}
		
		
		return turn_around_time;
	}
	
	public int []waiting_time_method(int []turn_around_time,int [][]processes)
	{
		int []waiting_time=new int[turn_around_time.length];
		for(int i=0;i<turn_around_time.length;i++)
		{
			waiting_time[i]=turn_around_time[i]-processes[i][1];
		}
		return waiting_time;
	}
	
	
	public static void main(String arg[])
	{
		JobScheduler jobscheduler= new JobScheduler();
		Scanner sc= new Scanner(System.in);
		int [][]process_arr= new int[10][10];
		System.out.println("Enter the no of processes");
		int number_of_processes=sc.nextInt();
		System.out.println("Enter the arrival time and burst time of each process");
		
		for(int i=0;i<number_of_processes;i++)
		{
			for(int j=0;j<2;j++)
			{
				process_arr[i][j]=sc.nextInt();
			}
		}
		
		//calls the completion_time method and returns the array of completion time
		
		int completion_time[]= jobscheduler.completion_time_method(process_arr,number_of_processes);
		for(int i=0;i<number_of_processes;i++)
		{
			System.out.println("competion time of P"+i+" is "+completion_time[i]);
		}
		
		//calls the turn_around_time method and returns the array of turn around time
		
		int turn_around_time[]=jobscheduler.turn_around_time_method(completion_time,process_arr);
		for(int i=0;i<number_of_processes;i++)
		{
			System.out.println("turn around time of P"+i+" is "+turn_around_time[i]);
		}
		
		//calls waiting_time_method and returns the array of waiting time 
		
		int total_waiting_time=0;
		int max_waiting_time=0;
		int waiting_time[]=jobscheduler.waiting_time_method(turn_around_time,process_arr);
		for(int i=0;i<number_of_processes;i++)
		{
			System.out.println("waiting time of P"+i+" is "+waiting_time[i]);
			total_waiting_time=total_waiting_time+waiting_time[i];
			if(max_waiting_time<waiting_time[i])
			{
				max_waiting_time=waiting_time[i];
			}
		}
		
		System.out.println("Average waiting time="+(total_waiting_time/number_of_processes));
		System.out.println("Maximum waiting time= "+max_waiting_time);
		

	}



}