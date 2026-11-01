class Solution {
    public String simplifyPath(String path) {
        
        if(null == path || path.length() == 0) return "/";

        String[] splits = path.split("/");

        Stack<String> stack = new Stack<>();

        for(String split : splits) {
            if(split.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (split.equals(".") || split.equals("")) {
                continue;
            } else {
                stack.push(split);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();

        for(String split : stack) {
            sb.append("/").append(split);
        }

        return sb.toString();
    }
}