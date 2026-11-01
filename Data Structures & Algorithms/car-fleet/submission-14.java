class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Map<Integer, Integer> posToSpeed = new HashMap<>();

        for(int i = 0; i < position.length; i++) {
            posToSpeed.put(position[i], speed[i]);
        }

        Stack<Double> fleet = new Stack<>();

        Arrays.sort(position);

        for(int i = position.length - 1; i >= 0; i--) {
            int pos = position[i];
            int spd = posToSpeed.get(pos);

            double time = (double) (target - pos) / spd;

            if(fleet.isEmpty() || time > fleet.peek()) {
                fleet.push(time);
            }

            
        }

        return fleet.size();
    }
}
