class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int astr : asteroids) {

            while(!stack.isEmpty() && stack.peek() > 0 && astr < 0) {
                int a = Math.abs(stack.peek()), b = Math.abs(astr);
                if(a == b) {
                    stack.pop();
                    astr = 0;
                } else if(a < b){
                    stack.pop();
                } else {
                    astr = 0;
                }
            }

            if(astr != 0) stack.push(astr);
        }

        int[] res = new int[stack.size()];

        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}