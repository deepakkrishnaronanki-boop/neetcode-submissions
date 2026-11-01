class Solution {
    public String decodeString(String s) {
        
        Stack<String> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c != ']') {
                stack.push(String.valueOf(c));
            } else {

                StringBuilder str = new StringBuilder();

                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }

                stack.pop();

                StringBuilder count = new StringBuilder();

                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    count.insert(0, stack.pop());
                }

                stack.push(str.toString().repeat(Integer.parseInt(count.toString())));
            }
        }

        StringBuilder res = new StringBuilder();

        for(String str : stack) {
            res.append(str);
        }

        return res.toString();
    }
}