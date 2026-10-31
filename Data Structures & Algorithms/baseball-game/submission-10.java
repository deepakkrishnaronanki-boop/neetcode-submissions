class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();

        for(String opr : operations) {
            if(opr.equals("+")) {
                int a = stack.pop();
                int b = a + stack.peek();
                stack.push(a);
                stack.push(b);
            } else if(opr.equals("C")) {
                stack.pop();
            } else if(opr.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.parseInt(opr));
            }
        }

        int sum = 0;

        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}