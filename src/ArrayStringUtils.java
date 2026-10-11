
public class ArrayStringUtils {


    public static void rotateRight(int[] a, int k) {
        if (a == null || a.length == 0) {
            return;
        }

        int n = a.length;
        k = ((k % n) + n) % n;

        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
    }


    private static void reverse(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }


    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            return a == b;
        }

        if (a.length() != b.length()) {
            return false;
        }

        int[] frequency = new int[65536];

        for (int i = 0; i < a.length(); i++) {
            frequency[a.charAt(i)]++;
            frequency[b.charAt(i)]--;
        }

        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


    public static int[] twoSumSorted(int[] a, int target) {
        if (a == null) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            long sum = (long) a[left] + a[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }


    public static boolean isBalanced(String expr) {
        if (expr == null) {
            return false;
        }

        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if ((c == ')' && opening != '(') ||
                        (c == ']' && opening != '[') ||
                        (c == '}' && opening != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
