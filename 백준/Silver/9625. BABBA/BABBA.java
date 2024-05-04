import java.util.Scanner;

public class Main {
	
	public static void DP(int[] cnt) {
		int tmp = cnt[0];
		
		cnt[0] = cnt[1];	//a = b;
		cnt[1] += tmp;		//b = a + b;
		
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int K = scanner.nextInt();
		int[] cnt = new int[2];
		cnt[0] = 1;
		cnt[1] = 0;
		
		for (int i = 0; i < K; i++) {
			DP(cnt);
		}
		
		System.out.printf("%d %d%n", cnt[0], cnt[1]);
		
		scanner.close();

		return;
	}	

}
