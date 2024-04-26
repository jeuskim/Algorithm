import java.util.Scanner;

public class Main {
	
	static double factorial_numerator(double m, double n) {
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
	
	static double factorial_denominator(double n) {
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
		double N = 0, M = 0;
		
		for (int i = 0; i < T; i++) {
			N = scanner.nextDouble();
			M = scanner.nextDouble();			
			//System.out.printf("%f %f%n", factorial_numerator(M, N), factorial_denominator(N));
			if (M / 2 < N) {
				N = M - N;
			}
			System.out.println((long)(factorial_numerator(M, N) / factorial_denominator(N)));
		}

		scanner.close();

		return;
	}	

}
