class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        StringBuilder cur = new StringBuilder();
        int num = 0;

        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) { 
                num = num * 10 + (c - '0');
            } else if(c == '[') {
                countStack.push(num);
                strStack.push(cur);
                num = 0;
                cur = new StringBuilder();
            } else if(c == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = strStack.pop();

                for(int i = 0; i < repeat;i++) {
                    prev.append(cur);
                }

                cur = prev;
            } else {
                cur.append(c);
            }

        }

        return cur.toString();
    }
}