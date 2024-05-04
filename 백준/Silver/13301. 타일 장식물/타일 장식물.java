import java.util.Scanner;

public class Main {
	
	public static long DP(long[] tile, int n) {
		if (tile[n] != 0) {
			return tile[n];
		}
		if (n == 1 || n == 2) {
			tile[n] = 1;
		}
		else {
			tile[n] = DP(tile, n - 1) + DP(tile, n - 2);
		}
		return tile[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long[] tile = new long[N + 1];
		long round = 0;
		
		DP(tile, N);
		if (N == 1) {
			round = 4;
		}
		else if (N == 2) {
			round = 6;
		}
		else if (N == 3) {
			round = 10;
		}
		else {
			round = tile[N] * 3 + tile[N - 1] * 2 + tile[N - 2] * 2 + tile[N - 3];
		}
		System.out.printf("%d%n", round);
		
		scanner.close();

		return;
	}	

}
