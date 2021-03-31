package codingInterview.chapt8;

import basic.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 8.2 격자판(grid) 상의 로봇 : 행의 개수는 r, 열의 개수는 c인 격자판의 왼쪽 상단 꼭짓점에 로봇이 놓여있다고 상상해보자.
 * 이 로봇은 오른쪽 아니면 아래쪽으로만 이동할 수 있다.
 *
 * (r, c)로 가려면 결국 (r-1, c), (r, c-1)로 먼저 가야한다. 따라서 (r-1, c)와 (r, c-1)로 가는 경로를 찾아야 한다.
 */
public class Problem2_GetPathTest {

    @Test
    void solution() {
        boolean[][] maze = new boolean[4][4];
        getPath(maze);
    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length-1, maze[0].length-1, path)) {
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        boolean isAtOrigin = row == 0 && col == 0;

        /* 경로가 존재하면 현재 위치를 더한다. */
        if (isAtOrigin || getPath(maze, row, col - 1, path) ||
        getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    ArrayList<Point> getPathWithHashSet(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPathWithHashSet(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private boolean getPathWithHashSet(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        /* 범위를 벗어났거나 지나갈 수 없으면 false를 반환 */
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        if(failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        /* 경로가 존재하면 현재 위치를 더한다. */
        if (isAtOrigin || getPathWithHashSet(maze, row, col - 1, path, failedPoints) ||
            getPathWithHashSet(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }


}
