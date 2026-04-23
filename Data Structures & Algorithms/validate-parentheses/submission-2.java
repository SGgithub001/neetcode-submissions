class Solution {
    public char getVal(char ch){
        switch(ch){
            case ']' : return '[';
            case ')' : return '(';
            case '}' : return '{';
            default : return ' ';
        }
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        String opening = "({[";
        String closing = ")}]";
        for(char ch : s.toCharArray()){
            if(opening.indexOf(ch) != -1){
                st.push(ch);
            } else {
                if(st.size() == 0) return false;
                char temp = st.pop();
                if(getVal(ch) != temp){
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}
