package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TomatoTest {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int width;
    private static int height;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        width = Integer.parseInt(str[0]);
        height = Integer.parseInt(str[1]);

        int[][] arr = new int[width][height];

        for (int i = 0; i < width; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < height; j++) {
                arr[i][j] = Integer.parseInt(str[j]);

            }
        }
        bfs(arr);
    }

    public static void bfs(int[][] arr) {
        Queue<DOT> q = new LinkedList<DOT>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (arr[i][j] == 1)
                    //익은 토마토가 있는 모든 위치를 큐에 담는다.
                    q.add(new DOT(i, j));
            }
        }

        while (!q.isEmpty()) {
            //익은 토마토의 상하좌우는 다음에 익기 때문에 큐에 담아야한다.
            DOT dot = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                //범위 밖 패스
                if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) {
                    continue;
                }
                //다음 위치가 익지 않은 토마토가 아니면 패스
                if (arr[nextX][nextY] != 0) {
                    continue;
                }
                //최대 일수를 구하기 때문에 1로 바꾸는 것이 아니라 현재 일수 +1 을 해줘야한다.
                arr[nextX][nextY] = arr[dot.x][dot.y] + 1;
                q.add(new DOT(nextX, nextY));
            }
        }
        int max = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (arr[i][j] == 0) {
                    //토마토가 모두 익지 못한 상황이라면 -1 을 출력한다.
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }
        //그렇지 않다면 최대값을 출력한다.
        System.out.println(max - 1);

    }
}

class DOT {
    int x;
    int y;

    DOT(int x, int y) {
        this.x = x;
        this.y = y;
    }
}