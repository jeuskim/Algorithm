import java.util.Scanner;

public class Main {
	
	static long factorial_numerator(long m, long n) {
		if (n == 0) {
			return 1;
		}
		else if (n == 1) {
			return m;
		}
		else {
			return m * factorial_numerator(m - 1, n - 1);
		}
	}
	
	static long factorial_denominator(long n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		else {
			return n * factorial_denominator(n - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		long N = 0, M = 0;
		
		for (int i = 0; i < T; i++) {
			N = scanner.nextLong();
			M = scanner.nextLong();			
			if (M / 2 < N) {
				N = M - N;
			}
			System.out.println((factorial_numerator(M, N) / factorial_denominator(N)));
		}

		scanner.close();

		return;
	}	

}
