public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board.length == 0) return;
        int width = board[0].length;
        ArrayList<Integer> checkList = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    boolean flag = false;
                    checkList.clear();
                    checkList.add(i*width+j);
                    int k = 0;
                    while (k < checkList.size()) {
                        int now = checkList.get(k);
                        int y = now / width;
                        int x = now % width;
                        if (x == 0 || x == board[0].length-1
                            || y == 0 || y == board.length-1)
                            flag = true;
                        if (x > 0 && board[y][x-1] == 'O') {
                            checkList.add(y*width+x-1);
                            board[y][x-1] = '1';
                        }
                        if (x < board[0].length-1 && board[y][x+1] == 'O') {
                            checkList.add(y*width+x+1);
                            board[y][x+1] = '1';
                        }
                        if (y > 0 && board[y-1][x] == 'O') {
                            checkList.add((y-1)*width+x);
                            board[y-1][x] = '1';
                        }
                        if (y < board.length-1 && board[y+1][x] == 'O') {
                            checkList.add((y+1)*width+x);
                            board[y+1][x] = '1';
                        }
                        k++;
                    }
                    if (!flag) for (int current: checkList) {
                        board[current / width][current % width] = 'X';
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
            }
    }
}
