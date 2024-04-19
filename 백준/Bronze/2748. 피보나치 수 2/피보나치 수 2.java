import java.util.Scanner;

public class Main {

	static long fibonacci(long[] f_data, int pos) {
		if (pos <= 1) {
			return pos;
		}
		if (f_data[pos] != 0L) {
			return f_data[pos];
		}
		f_data[pos] = fibonacci(f_data, pos - 1) + fibonacci(f_data, pos - 2);

		return f_data[pos];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		long[] f_data = new long[91];
		int pos = scanner.nextInt();

		System.out.printf("%d%n", fibonacci(f_data, pos));

		scanner.close();

		return;
	}	

}
