import java.util.*;

class Emo {
    public int price;
    public int discount;
    
    public Emo(int price, int discount) {
        this.price = price;
        this.discount = discount;
    }
    
    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

class Solution {
    
    public static int totalServ = 0;
    public static int totalEmo = 0;
    public static Emo[] emoList;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        emoList = new Emo[emoticons.length];
        for(int i = 0; i < emoList.length; i++){
            emoList[i] = new Emo(emoticons[i], 0);
        }
        
        search(0, users);
        
        int[] answer = {totalServ, totalEmo};
        return answer;
    }
    
    public static void search(int idx, int[][] users) {
        if(idx == emoList.length) {
            int totalCnt = 0;
            int totalSum = 0;
            
            for(int i = 0; i < users.length; i++) {
                int minPer = users[i][0];
                int maxPrice = users[i][1];
                
                int tempPrice = 0;
                for(int j = 0; j < emoList.length; j++) {
                    if(emoList[j].discount >= minPer) {
                        tempPrice += emoList[j].price * (100 - emoList[j].discount) / 100;
                    }
                }
                
                if(tempPrice >= maxPrice) {
                    totalCnt++;
                } else {
                    totalSum += tempPrice;
                }
            }
            
            if(totalCnt > totalServ) {
                totalServ = totalCnt;
                totalEmo = totalSum;
            } else if(totalCnt == totalServ && totalSum > totalEmo) {
                totalEmo = totalSum;
            }
            
            return;
        }
        
        for(int i = 10; i <= 40; i+=10) {
            emoList[idx].setDiscount(i);
            search(idx + 1, users);
        }
    }
}