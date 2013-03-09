import java.util.*;
public class Test {
    public static void main (String [] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
            a.add(i+1);
        }
    }
}
