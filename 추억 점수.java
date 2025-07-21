import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int count = 0;
        
        for (int i = 0; i < photo.length; i++) {
            count = 0;
            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++) {
                    if (photo[i][j].equals(name[k])) {
                        count += yearning[k];
                    }
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        List<String[]> tempList = new ArrayList<>();
        String[] name = sc.nextLine().split(" ");
        int[] yearning = Arrays.stream(sc.nextLine().split(" "))
                       .mapToInt(Integer::parseInt)
                       .toArray();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            tempList.add(line.split(" "));
        }

        String[][] photo = tempList.toArray(new String[0][]);
        
        Solution sol = new Solution();
        sol.solution(name, yearning, photo);
    }
}
