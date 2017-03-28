public class BinarySearch {
    // prev: a[j] >= a[j + 1] && a.length && a' = a
    // && (r == a.length || (r < a.length && a[r] <= x)) && (l == -1 || (0 <= l < a.length && a[l] > x)) &&
    // && r' - l' == (r - l + 1) div 2 && l <= r - 1
    static int binarySearchRecursion(int[] array, int l, int r, int x) {
        if (!(l < r - 1)) {
            // prev && l + 1 == r
            // 1) a.length == 0 (just return) && r == a.length == 0
            // 2) a[a.length -1] > x (never visit if(a[m] <= x) in previous recursions) -> r = a.length
            // 3) r < a.length && prev -> a[r] <= key
            // 3a) r == 0
            // 3b) r > 0 && prev && l <= r - 1 -> a[r - 1] > key
            return r;
        } else {
            // prev && l < r - 1
            int m = (l + r) / 2;
            // prev && m = (l + r) div 2 && l < m < r && l < r - 1
            if (array[m] <= x) {
                // prev && m = (l + r) div 2 && l < m < r && l < r - 1 && a[m] <= x
                // r' = m && l' = l -> m - l' = (l + r) div 2 - l = (r - l + 1) div 2
                // l' = l -> (l' == -1 || (0 <= l' < a.length && a[l'] > x))
                // (Pre && a[r'] <= x) ->  r' < a.length && a[r'] <= x
                // l < r - 1 && r' == m && l < m < r -> l' <= r' - 1
                // a' = a
                return binarySearchRecursion(array, l, m, x);
                // post was Ok before and a' = a
            } else {
                // prev && m = (l + r) div 2 && l < m < r && l < r - 1 && a[m] > x
                // r' = r' && l' = m -> r' - m == r - (r + l) div 2 == (r - l + 1) div 2
                // r' = r -> (r' == a.length || (r' < a.length && a[r'] <= x))
                // (Pre && a[l'] > x) -> 0 <= l' < a.length && a[l'] > x
                // l < r - 1 && l' = m && l < m < r -> l' <= r' - 1
                // a' = a
                return binarySearchRecursion(array, m, r, x);
                // post was Ok before and a' = a
            }
        }
    }
    // post: (a.length == 0 && R == 0) || (a[a.length - 1] > x && R = a.length) ||
    // || (R < a.length && a[R] <= x && (R == 0 || a[R - 1] > x))

    // prev: a[j] >= a[j + 1]
    static int binarySearchIterative(int[] array, int x) {
        // prev && a[j] >= a[j + 1]
        int l = -1;
        // prev && a[j] >= a[j + 1] ^ l = -1
        int r = array.length;
        // prev && a[j] >= a[j + 1] ^ l = -1 ^ r = array.length
        // I: (r' == a.length || (r' < a.length && a[r'] <= x)) && (l' == -1 || (0 <= l' < a.length && a[l'] > x)) &&
        // && r'' - l'' == (r' - l' + 1) div 2 && l' <= r' - 1
        while (l < r - 1) {
            // prev && Inv
            int m = (l + r) / 2;
            // prev &&  Inv && m = (l' + r') div 2 && l' < m < r'
            if (array[m] <= x) {
                // prev && Inv && l' < r' - 1 && m = (l' + r') div 2 && array[m] <= x && l' < m < r'
                r = m; // r'' = m && l'' = l' -> m - l'' = (l' + r') div 2 - l' = (r' - l' + 1) div 2
                // l'' = l' -> (l'' == -1 || (0 <= l'' < a.length && a[l''] > x))
                // (Pre && a[r''] <= x) ->  r'' < a.length && a[r''] <= x
                // l' < r' - 1 && r'' == m && l' < m < r' -> l'' <= r'' - 1
            } else {
                // prev && Inv && l' < r' - 1 && m = (l' + r') div 2 && array[m] > x && l' < m < r'
                l = m; // r'' = r' && l'' = m -> r'' - m == r' - (r' + l') div 2 == (r' - l' + 1) div 2
                // r'' = r' -> (r'' == a.length || (r'' < a.length && a[r''] <= x))
                // (Pre && a[l''] > x) -> 0 <= l'' < a.length && a[l''] > x
                // l' < r' - 1 && l'' = m && l' < m < r' -> l'' <= r'' - 1
            }
        }
        // !(r' - l') > 1 && l' <= r' - 1 -> l' + 1 == r'
        // 1) a.length == 0 (never go while(...))&& r' == a.length == 0
        // 2) a[a.length -1] > x (never visit if(a[m] <= x)) -> r' = a.length
        // 3) r' < a.length && Inv -> a[r'] <= key
        // 3a) r' == 0
        // 3b) r' > 0 && Inv && l' <= r' - 1 -> a[r' - 1] > key
        return r;
    }
    // post: (a.length == 0 && R == 0) || (a[a.length - 1] > x && R = a.length) ||
    // || (R < a.length && a[R] <= x && (R == 0 || a[R - 1] > x))

    static int[] createArray(String[] args) {
        int[] array = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            array[i] = Integer.parseInt(args[i + 1]);
        }
        return array;
    }


    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int[] array = createArray(args);
        System.out.println(binarySearchRecursion(array, -1, array.length, x));
        //System.out.println(binarySearchIterative(array, x));
    }
}