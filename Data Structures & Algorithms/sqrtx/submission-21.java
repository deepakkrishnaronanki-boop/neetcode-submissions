class Solution {
    public int mySqrt(int x) {
        
        int l = 1, r = x;

        while (l <= r) {
            int m = l + (r - l) / 2;

            double square = (double) m * m;

            if(square == x) {
                return m;
            } else if (square > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r;
    }
}