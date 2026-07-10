class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (int i = myString.length() - 1; i >= 0; i--) {
            sb.append(myString.charAt(i));
        }
        return sb.toString();
    }
}