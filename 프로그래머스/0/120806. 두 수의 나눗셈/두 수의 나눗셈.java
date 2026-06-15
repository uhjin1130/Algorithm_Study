class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        double n1 = num1;
        double n2 = num2;
        
        answer = (int)(n1 / n2 * 1000);
        
        return answer;
    }
}