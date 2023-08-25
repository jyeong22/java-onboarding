package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i<word.length();++i){
            int charToInt = word.charAt(i);
            int reverse;
            if(Character.isUpperCase(word.charAt(i))){
                reverse = 155 - charToInt;
                answer+=(char)reverse;
            }
            else if(Character.isLowerCase(word.charAt(i))){
                reverse = 219 - charToInt;
                answer+=(char)reverse;
            }
            else{
                answer+=' ';
            }

        }

        return answer;
    }
}
