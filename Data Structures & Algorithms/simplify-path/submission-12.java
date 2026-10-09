class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<>();

        String[] splits = path.split("/");


        for(String split : splits) {

            if(split.equals(".") || split.equals("")) {
                continue;
            } else if(split.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(split);
            }
        }

        StringBuilder sb = new StringBuilder();

        if(stack.isEmpty()) return "/";

        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}