class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int boats = 0;

        Arrays.sort(people);

        int l = 0, r = people.length-1;

        while(l <= r) {
            int weight = people[l] + people[r];

            if(weight <= limit) {
                l++;
                r--;
            } else {
                r--;
            }

            boats++;
        }

        return boats;
    }
}