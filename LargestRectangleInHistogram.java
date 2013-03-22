public class rectangle {
    public static void main (String[] args) {
      int [] a = new int [20000];
      for (int i = 0; i < 20000; i++) {
        a[i] = i;
      }
      System.out.println(largestRectangleArea(a));
    }
    public static int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return largest(height, 0, height.length-1);
    }
    public static int largest(int [] height, int left, int right) {
        if (left > right) return 0;
        if (left == right) return height[left];
        
        int smallest = left;
        for (int i = left+1; i <= right; i++) {
            if (height[smallest] > height[i]) smallest = i;
        }
        int val = height[smallest]*(right-left+1);
        System.out.println("left="+left+" right="+right+" smallest="+smallest);
        val = Math.max(val, largest(height, left, smallest-1));
        val = Math.max(val, largest(height, smallest+1, right));
        return val;
    }
}
