package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION_NUMBER = -1;
    private static final int DRAW_NUMBER = 0;
    private static final int WIN_POBI_NUMBER = 1;
    private static final int WIN_CRONG_NUMBER = 2;
    private static final int FIRST_PAGE_OF_BOOK = 1;
    private static final int LAST_PAGE_OF_BOOK = 400;



    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isNotTwoElements(pobi) || isNotBookPage(pobi) || isNotSidePage(pobi)) {
            return EXCEPTION_NUMBER;
        }

        if (isNotTwoElements(crong) || isNotBookPage(crong) || isNotSidePage(crong)) {
            return EXCEPTION_NUMBER;
        }

        int pobiLargerNumber = getLarger(pobi);
        int crongLargerNumber = getLarger(crong);

        answer = getAnswerByCompareNumber(pobiLargerNumber, crongLargerNumber);

        return answer;
    }

    private static boolean isNotBookPage(List<Integer>checkList){
        return FIRST_PAGE_OF_BOOK>checkList.get(0) || FIRST_PAGE_OF_BOOK>checkList.get(1) ||
                LAST_PAGE_OF_BOOK<checkList.get(0) ||  LAST_PAGE_OF_BOOK<checkList.get(1);
    }


    private static boolean isNotTwoElements(List<Integer>checkList){
        return checkList.size() != 2;
    }

    private static boolean isNotSidePage(List<Integer>checkList){
        return checkList.get(0)!=checkList.get(1)-1;
    }

    private static Integer getSum(int number){
        int result = 0;
        while(number!=0){
            result += number%10;
            number/=10;
        }
        return result;
    }

    private static int getMul(int number){
        int result = 1;
        while(number!=0){
            result *= number%10;
            number/=10;
        }
        return result;
    }

    private static int getLarger(List<Integer>checkList){
        int leftSumResult = getSum(checkList.get(0));
        int leftMultiplicationResult = getMul(checkList.get(0));
        int rightSumResult = getSum(checkList.get(1));
        int rightMultiplicationResult = getMul(checkList.get(1));

        int leftLargerNum = Math.max(leftSumResult, leftMultiplicationResult);
        int rightLargerNum = Math.max(rightSumResult, rightMultiplicationResult);

        return Math.max(leftLargerNum, rightLargerNum);
    }

    private static int getAnswerByCompareNumber(int pobiNumber, int crongNumber) {
        if (pobiNumber == crongNumber) {
            return DRAW_NUMBER;
        } else if (pobiNumber > crongNumber) {
            return WIN_POBI_NUMBER;
        }

        return WIN_CRONG_NUMBER;
    }
}