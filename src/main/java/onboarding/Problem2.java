package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        boolean check = true;
        String answer = "answer";
        while (check) {
            answer = getAnswerWithoutDuplicate(cryptogram);
            if (answer.equals(cryptogram) || answer.equals("")) {
                check = false;
            }
            cryptogram = answer;
        }

        return answer;
    }

    private static String getAnswerWithoutDuplicate(String cryptogram) {
        StringBuilder temp_answer = new StringBuilder();
        for (int i = 0; i < cryptogram.length(); ++i) {
            if (i == 0) {
                if (cryptogram.charAt(i) != cryptogram.charAt(i + 1)) {
                    temp_answer.append(cryptogram.charAt(i));
                }

            } else if (i == cryptogram.length() - 1) {
                if (cryptogram.charAt(i) != cryptogram.charAt(i - 1)) {
                    temp_answer.append(cryptogram.charAt(i));
                }

            } else {
                if ((cryptogram.charAt(i) != cryptogram.charAt(i - 1)) &&
                        (cryptogram.charAt(i) != cryptogram.charAt(i + 1))) {
                    temp_answer.append(cryptogram.charAt(i));
                }
            }
        }
        System.out.println("result = " + temp_answer);
        return temp_answer.toString();
    }


}
