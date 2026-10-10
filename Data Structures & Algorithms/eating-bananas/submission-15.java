class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1, r = 0;

        for(int pile : piles) {
            r = Math.max(pile, r);
        }

        while(l <= r) {
            int m = l + (r - l) / 2;

            int hours = getHoursToEat(m, piles);

            if(hours <= h) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private int getHoursToEat(int rate, int[] piles) {

        int hours = 0;

        for(int pile : piles) {
            hours += Math.ceil((double) pile / rate);
        }

        return hours;
    }
}
