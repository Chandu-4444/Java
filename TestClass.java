import java.util.*;
import java.io.IOException;
import java.lang.*;

class TestClass {
    public static void main(String[] args) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            while (t-- > 0) {
                solve(in);
            }
        } catch (Exception e) {
            return;
        }

    }

    static void solve(Scanner in) {
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> h = new ArrayList<Integer>();
        LinkedHashSet<Integer> set1 = new LinkedHashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            h.add(in.nextInt());
        }
        Collections.sort(h);
        sum = h.get(n - 1);
        set1.add(h.get(n - 1));
        int ans = -1;
        for (int i = n - 2; i >= 0; i--) {
            LinkedHashSet<Integer> set2 = new LinkedHashSet<Integer>();
            sum = sum + h.get(i);
            Iterator iter1 = set1.iterator();
            while (iter1.hasNext()) {
                int l = (int) (iter1.next());
                set2.add(l);
                set2.add(h.get(i));
                set2.add(l + h.get(i));
                if ((l + h.get(i) >= k) && (sum - l - h.get(i) >= k)) {
                    ans = n - i;
                    break;
                }
                if ((h.get(i) >= k) && (sum - h.get(i) >= k)) {
                    ans = n - i;
                    break;
                }
            }
            if (ans != -1) {
                break;
            }
            set1 = set2;
        }
        System.out.println(ans);

    }
}