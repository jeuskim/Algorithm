import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		if (N % 2 == 0) {
			System.out.println("SK");
		}
		else {
			System.out.println("CY");
		}
		
		scanner.close();

		return;
	}	

}
