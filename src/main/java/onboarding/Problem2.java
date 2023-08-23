package onboarding;

public class Problem2 {
    static boolean check = true;
    public static String solution(String cryptogram) {
        String answer = "answer";
        while(check){
            answer = getAnswerWithoutDuplicate(cryptogram);
            if(answer == cryptogram || answer == ""){
                check = false;
            }
            cryptogram = answer;
        }

        return answer;
    }

    private static String getAnswerWithoutDuplicate(String cryptogram) {
        String temp_answer = "";
        for (int i = 0; i < cryptogram.length(); ++i) {
            if (i == 0) {

            } else if (i == cryptogram.length() - 1) {

            } else {

            }
        }
        return temp_answer;
    }


}
