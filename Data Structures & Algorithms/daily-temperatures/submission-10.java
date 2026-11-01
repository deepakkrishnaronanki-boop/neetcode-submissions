class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int tmp = temperatures[i];

            while(!stack.isEmpty() && tmp > stack.peek()[0]) {
                int tmpIndex = stack.pop()[1];
                res[tmpIndex] = i - tmpIndex;
            }

            stack.push(new int[]{tmp, i});
        }

        return res;
    }
}
