import java.util.Scanner;

public class Main {
	
	static int fib(int[] fib_data, int n) {
		if (n == 1 || n == 2) {
			fib_data[0] += 1;
			return 1;
		}
		else {
			return fib(fib_data, n-1) + fib(fib_data, n-2);
		}
	}

	static int fibonacci(int[] fibo_data, int n) {
		fibo_data[1] = 1;
		fibo_data[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			fibo_data[0] += 1;
			fibo_data[i] = fibo_data[i - 1] + fibo_data[i - 2];
		}
		
		return fibo_data[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] fib_data = new int[41];
		int[] fibo_data = new int[41];
		int n = scanner.nextInt();
		
		fib(fib_data, n);
		fibonacci(fibo_data, n);

		System.out.printf("%d %d%n", fib_data[0], fibo_data[0]);

		scanner.close();

		return;
	}	

}
