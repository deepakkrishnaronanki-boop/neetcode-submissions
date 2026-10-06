class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String s : operations) {

            if(s.equals("D")) {
                stack.push(2 * stack.peek());
            } else if(s.equals("C")) {
                stack.pop();
            } else if(s.equals("+")) {
                int a = stack.pop();
                int b = stack.peek() + a;
                stack.push(a);
                stack.push(b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        int sum = 0;

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}