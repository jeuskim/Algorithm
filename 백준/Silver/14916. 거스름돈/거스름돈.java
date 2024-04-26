import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		if (n == 1 || n == 3) {
			System.out.println(-1);
		}
		else if ((n % 5) % 2 == 0) {
			System.out.println((n / 5) + ((n % 5) / 2));
		}
		else {
			System.out.println(((n / 5) - 1) + (((n % 5) + 5) / 2));
		}
		
		scanner.close();

		return;
	}	

}
