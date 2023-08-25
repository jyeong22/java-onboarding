package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nickname = new ArrayList<>();
        for(int i = 0; i< forms.size();++i){
            nickname.add(forms.get(i).get(1));
        }
        for(int i = 0; i<nickname.size();++i){
            for(int j = i+1; j<nickname.size();++j){
                if(IsDuplicated(nickname.get(i), nickname.get(j))) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        answer = removeDuplicate(answer);
        sortIncresed(answer);
        return answer;
    }

    private static boolean IsDuplicated(String str1, String str2){
        boolean check = false;
        for(int i = 0; i<str1.length()-1;++i){
            for(int j = 0; j<str2.length()-1;++j){
                if(str1.charAt(i) == str2.charAt(j) && str1.charAt(i+1) == str2.charAt(j+1)){
                    check = true;
                    return check;
                }
            }
        }
        return check;
    }

    private static List<String> removeDuplicate(List<String> answer){
       Set<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        return answer;
    }

    private static void sortIncresed(List<String> answer){
        Collections.sort(answer);
    }
}
