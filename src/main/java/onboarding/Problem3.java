package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i<=number;++i){
            answer += play369Game(i);
        }
        return answer;
    }

    private static int play369Game(int i){
        int tmp_sum = 0;
        while(i>0){
            int num = i%10;
            if(num == 3 || num == 6 || num == 9){
                ++tmp_sum;
            }
            i/=10;
        }
        return tmp_sum;

    }
}
