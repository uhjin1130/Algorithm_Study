import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todaySplit = today.split("\\.");
        int todayTotal = toDate(Integer.parseInt(todaySplit[0]),
                                Integer.parseInt(todaySplit[1]),
                                Integer.parseInt(todaySplit[2]));

        HashMap<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] parts = t.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] dateParts = privacy[0].split("\\.");

            int privacyTotal = toDate(Integer.parseInt(dateParts[0]),
                                      Integer.parseInt(dateParts[1]),
                                      Integer.parseInt(dateParts[2]));

            int expireTotal = privacyTotal + termMap.get(privacy[1]) * 28;

            if (todayTotal >= expireTotal) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int toDate(int year, int month, int day) {
        return year * 12 * 28 + month * 28 + day;
    }
}