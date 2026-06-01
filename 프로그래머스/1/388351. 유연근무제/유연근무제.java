class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;

        for (int i = 0; i < timelogs.length; i++) {
            int limit = toMinutes(schedules[i]) + 10;

            for (int j = 0; j < 7; j++) {
                int weekday = (startday + j) % 7; // 0=일, 6=토
                if (weekday == 0 || weekday == 6) continue; // 주말 스킵

                if (toMinutes(timelogs[i][j]) > limit) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    int toMinutes(int time) {
        return (time / 100) * 60 + (time % 100);
    }
}