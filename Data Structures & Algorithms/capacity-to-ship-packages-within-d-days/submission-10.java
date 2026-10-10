class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int l = 0, r = 0;

        for(int weight : weights) {
            l = Math.max(l , weight);
            r += weight;
        }

        while(l <= r) {
            int m = l + (r - l) / 2;

            int day = noOfDaysToShip(m, weights);

            if(day <= days) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int noOfDaysToShip(int rate, int[] weights) {
        int days = 0, sum = 0;

        for(int weight : weights) {
            sum += weight;

            if(sum == rate) {
                days++;
                sum = 0;
            } else if(sum > rate) {
                days++;
                sum = weight;
            }
        }
        return sum == 0 ? days : days + 1;   

    }
}