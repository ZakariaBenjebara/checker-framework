import org.checkerframework.checker.index.qual.*;

public class LessThanLen {

    public static void m1() {
        int[] shorter = new int[5];
        int[] longer = new int[shorter.length * 2];
        for (int i = 0; i < shorter.length; i++) {
            longer[i] = shorter[i];
        }
    }

    public static void m2(int[] shorter) {
        int[] longer = new int[shorter.length * 2];
        for (int i = 0; i < shorter.length; i++) {
            longer[i] = shorter[i];
        }
    }

    public static void m3(int[] shorter) {
        int[] longer = new int[shorter.length + 1];
        for (int i = 0; i < shorter.length; i++) {
            longer[i] = shorter[i];
        }
    }

    public static void m4(int[] shorter) {
        int[] longer = new int[shorter.length * 1];
        // :: error: (assignment.type.incompatible)
        @LTLengthOf("longer") int x = shorter.length;
        @LTEqLengthOf("longer") int y = shorter.length;
    }

    public static void m5(int[] shorter) {
        // :: error: (array.length.negative)
        int[] longer = new int[shorter.length * -1];
        // :: error: (assignment.type.incompatible)
        @LTLengthOf("longer") int x = shorter.length;
        // :: error: (assignment.type.incompatible)
        @LTEqLengthOf("longer") int y = shorter.length;
    }

    public static void m6(int[] shorter) {
        int[] longer = new int[4 * shorter.length];
        @LTLengthOf("longer") int x = shorter.length;
        @LTEqLengthOf("longer") int y = shorter.length;
    }
}
