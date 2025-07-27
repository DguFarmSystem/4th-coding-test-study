import java.util.*;

//파기 할 개인 정보 찾기

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
                
        int[] answer ={};
        List<Integer> result = new ArrayList<>(); //동적으로 결과 추가

        
        int todayDays = getTotalDays(today);
     
        // 1. 약관 종류 map 저장
        Map<String, Integer> termsMap = new HashMap<>();
   
        for(int i =0; i< terms.length; i++){ //배열 순회도 참고
            String[] termsPart = terms[i].split(" ");
    
            termsMap.put(termsPart[0], Integer.parseInt(termsPart[1]));
            //System.out.println(termsMap);
        }

        // 2. 유효기간 계산
        for(int i =0; i< privacies.length; i++){
            
            String[] privaciesPart= privacies[i].split(" ");
            
            String startDate = privaciesPart[0];
            int startDays = getTotalDays(startDate); //일로 환산

            String termType = privaciesPart[1];
            int termLength = termsMap.get(termType);
            
             // 3. 유효기간 판별 비교
            if(startDays + (termLength*28) <= todayDays){
                result.add(i+1);
                //System.out.println("i : "+i);
       
            }
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    //일로 환산 함수
    private int getTotalDays(String date){
        
        String[] datePart = date.split("\\."); //.에 대한 escape 문자 추가
        int year = Integer.parseInt(datePart[0]);
        int month = Integer.parseInt(datePart[1]);
        int day = Integer.parseInt(datePart[2]);
            
        int totalDays = day + (month * 28) + (year * 12 * 28);
            
        return totalDays;
    }
    
   
    
}

