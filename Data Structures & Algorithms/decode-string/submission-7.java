class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();


        for(int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ']') {
                StringBuilder str = new StringBuilder();
                while(!stack.peek().equals("[")){
                    str.insert(0, stack.pop());
                }

                stack.pop();

                StringBuilder repeat = new StringBuilder();

                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    repeat.insert(0, stack.pop());
                }

                stack.push(str.toString().repeat(Integer.parseInt(repeat.toString())));

            } else {
                stack.push(String.valueOf(c));
            }
        }

        StringBuilder res = new StringBuilder();

        for(String str : stack) {
            res.append(str);
        }

        return res.toString();
    }
}