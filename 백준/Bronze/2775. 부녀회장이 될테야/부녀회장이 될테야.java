import java.util.Scanner;

public class Main {

	public static int DP(int[][] apart, int k, int n) {
		if (k <= 0) {
			return n;
		}
		if (n <= 0) {
			return 1;
		}
		if (apart[k][n] != 0) {
			return apart[k][n];
		}

		if (apart[k][n-1] == 0) {
			DP(apart, k, n-1);
		}
		if (apart[k-1][n] == 0) {
			DP(apart, k-1, n);
		}
		apart[k][n] = apart[k][n-1] + apart[k-1][n];
		//System.out.printf("[%d, %d] : %d + %d = %d%n", k, n, apart[k][n-1], apart[k-1][n], apart[k][n]);

		return apart[k][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[][] apart = new int[15][14];
		for (int n = 0; n <= 13; n++) {
			apart[0][n] = n + 1;
		}
		for (int k = 1; k <= 14; k++) {
			apart[k][0] = 1;
		}
		int T = scanner.nextInt();
		for (int t = 1; t <= T; t++) {
			int K = scanner.nextInt();
			int N = scanner.nextInt();
			N -= 1;

			apart[K][N] = DP(apart, K, N);
			System.out.printf("%d%n", apart[K][N]);

		}

		scanner.close();
	}	

}
