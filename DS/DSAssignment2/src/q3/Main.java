package q3;

public class Main {
	public static void main(String args[]){
		try{
			CounsellingClass counsellor = new CounsellingClass();
			counsellor.allocatePrograms();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
