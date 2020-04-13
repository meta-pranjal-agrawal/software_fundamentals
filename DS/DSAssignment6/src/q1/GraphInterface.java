package q1;

import java.util.List;

public interface GraphInterface 
{
	boolean isConnected();
	
	List<Integer> reachable (int vertex) throws Exception;
	
	GraphInterface minimumSpanningTree() throws Exception;
	
	
	List<Integer> shortestPath(int source,int destination) throws Exception;
}
