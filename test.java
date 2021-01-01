import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class test {
    public static void main(String[] args) {
        ArrayList<Integer> num = new ArrayList<>(Arrays.asList(4, 8, 15, 16, 23, 42));
        int a11, a22, a34, a45;
        int[] out = new int[6];
        Scanner scanner = new Scanner(System.in);

        System.out.println("? 1 1");
        a11 = scanner.nextInt();
        System.out.flush();

        System.out.println("? 2 2");
        a22 = scanner.nextInt();
        System.out.flush();

        System.out.println("? 3 4");
        a34 = scanner.nextInt();
        System.out.flush();

        System.out.println("? 4 5");
        a45 = scanner.nextInt();
        System.out.flush();

        for (Integer integer : num) {
            if (integer * integer == a11) {
                out[0] = integer;
            } else if (integer * integer == a22) {
                out[1] = integer;
            }
        }
        num.remove((Integer) out[0]);
        num.remove((Integer) out[1]);

        for (Integer i : num) {
            //能除断，商在列表中，且商不为自己
            if (a34 % i == 0 && num.indexOf(a34 / i) != -1 && num.indexOf(a34 / i) != num.indexOf(i)) {
                out[2] = i; out[3] = a34 / i;
                if (a45 % out[3] == 0 && num.indexOf(a45 / out[3]) != -1 && num.indexOf(a45 / out[3]) != num.indexOf(out[3])) {
                    out[4] = a45 / out[3];
                    break;
                } else {
                    int temp = out[2];
                    out[2] = out[3];
                    out[3] = temp;
                    if (a45 % out[3] == 0 && num.indexOf(a45 / out[3]) != -1 && num.indexOf(a45 / out[3]) != num.indexOf(out[3])) {
                        out[4] = a45 /out[3];
                        break;
                    }
                }
            }
        }
        num.remove((Integer) out[2]);
        num.remove((Integer) out[3]);
        num.remove((Integer) out[4]);
        out[5] = num.get(0);

        System.out.print("!");
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + out[i]);
        }
        System.out.print("\n");
    }
}

  	 	 			  	          								