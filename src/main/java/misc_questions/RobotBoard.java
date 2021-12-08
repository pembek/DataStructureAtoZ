package misc_questions;

public class RobotBoard {
    public static int uniquePathsIII(int[][] grid) {
        int count = 0;
        int i = 0, j = 0, k = 1;
        int m = grid.length, n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        for(int x = 0; x < m; x++)
            for(int y = 0; y < n; y++) visited[x][y] = false;

        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(grid[x][y] == 1){
                    i = x;
                    j = y;
                } else if(grid[x][y] == 0) k++;
            }
        }

        count = walkSweep(grid, i, j, visited, k);

        return count;
    }

    public static int walkSweep(int[][] grid, int i, int j, boolean[][] visited, int k){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == -1 || visited[i][j]) return 0;

        int count = 0;

        if(k == 0 && grid[i][j] == 2) return 1;

        if(k == 0) return 0;
        if(grid[i][j] == 2) return 0;

        visited[i][j] = true;

        count += walkSweep(grid, i - 1, j, visited, k-1) +
                walkSweep(grid, i, j + 1, visited, k-1) +
                walkSweep(grid, i + 1, j, visited, k-1) +
                walkSweep(grid, i, j - 1, visited, k-1);

        visited[i][j] = false;

        return count;
    }
}
