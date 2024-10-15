import java.util.Scanner;

public class Main {
    static String[] moves = {"L", "R", "B", "T", "LB", "LT", "RB", "RT"}; // L: 왼, R: 오, B: 아래, T: 위
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    // string 좌표를 int로 변환
    public static int[] getPosition(String posStr) {
        int [] pos = new int[]{posStr.charAt(0) - 'A', posStr.charAt(1) - '1'};

        return pos;
    }

    // int 좌표를 string으로 변환
    public static String getPosString(int[] pos) {
        String posStr = (char)(pos[0] + 'A') + Integer.toString(pos[1] + 1);

        return posStr;
    }

    // 이동 후 좌표
    public static int[] getMove(int[] pos, String move) {
        int index = -1;
        int[] newPos = new int[pos.length];

        for (int i = 0; i < moves.length; i++) {
            if (moves[i].equals(move)) {
                index = i;
                break;
            }
        }

        newPos[0] = pos[0] + dx[index];
        newPos[1] = pos[1] + dy[index];

        return newPos;
    }

    // 좌표의 유효성 확인
    public static boolean isValid(int[] pos) {
        return (pos[0] >= 0) && (pos[0] < moves.length) && (pos[1] >= 0) && (pos[1] < moves.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String kingPosStr = sc.next();
        String stonePosStr = sc.next();
        int moveCount = sc.nextInt();
        sc.nextLine();  // nextInt() 함수는 개행문자를 받지 않기 때문에 필요

        int[] kingPos = getPosition(kingPosStr);
        int[] stonePos = getPosition(stonePosStr);

        for (int i = 0; i < moveCount; i++) {
            String move = sc.nextLine();
            int[] nextKingPos = getMove(kingPos, move);

            if (!isValid(nextKingPos)) {
                continue;
            }

            if (nextKingPos[0] == stonePos[0] && nextKingPos[1] == stonePos[1]) {
                int[] newStonePos = getMove(stonePos, move);

                if (!isValid(newStonePos)) {
                    continue;
                }

                stonePos = newStonePos;
            }

            kingPos = nextKingPos;
        }

        System.out.println(getPosString(kingPos));
        System.out.println(getPosString(stonePos));

        sc.close();
        return;
    }
}
