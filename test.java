import java.util.*;
class Node {
    public int x = 0;
    public int y = 0;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
}

public class test {
  public static void main(String [] args) {
    int [][] a = {"XXX","X0X","XXX"};
    System.out.println(longestConsecutive(a));
  
  }
  public static void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Node> checkList = new ArrayList<Node>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '0') {
                    boolean flag = false;
                    checkList.clear();
                    checkList.add(new Node(j, i));
                    int k = 0;
                    while (k < checkList.size()) {
                        Node now = checkList.get(k);
                        if (now.x == 0 || now.x == board[0].length-1
                            || now.y == 0 || now.y == board.length-1)
                            flag = true;
                        if (now.x > 0 && board[now.y][now.x-1] == '0')
                            checkList.add(new Node(now.x-1, now.y));
                        if (now.x < board[0].length-1 && board[now.y][now.x+1] == '0')
                            checkList.add(new Node(now.x+1, now.y));
                        if (now.y > 0 && board[now.y-1][now.x] == '0')
                            checkList.add(new Node(now.x, now.y-1));
                        if (now.y < board.length-1 && board[now.y+1][now.x] == '0')
                            checkList.add(new Node(now.x, now.y+1));
                        k++;
                    }
                    if (flag) {
                        for (Node current: checkList) {
                            board[current.y][current.x] = '1';
                        }
                    }
                    else for (Node current: checkList) {
                        board[current.y][current.x] = 'X';
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') board[i][j] = '0';
            }
    }
}
