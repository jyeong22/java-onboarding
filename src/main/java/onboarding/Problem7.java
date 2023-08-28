package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<String>> friendsMap = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();

        // friends를 토대로 friends relation graph에 추가
        for(int i = 0; i<friends.size();++i){
            for(int j = 0; j<2;++j){
                String my_name = friends.get(i).get(j);
                String friend_name = friends.get(i).get(1-j);
                if(!friendsMap.containsKey(my_name)){
                    friendsMap.put(my_name, new ArrayList<>());
                }
                friendsMap.get(my_name).add(friend_name);

            }
        }
        // donut, andole, jun, mrko, shakevan, bedi (1, 20, 20, 20, 1, 3)

        // visitors를 토대로 friends relation graph에 추가
        for(int i = 0; i<visitors.size();++i){
            if(!friendsMap.containsKey(visitors.get(i))){
                friendsMap.put(visitors.get(i), new ArrayList<>());

            }
        }

        // visitors를 토대로 score 갱신
        Set<String> keySet = friendsMap.keySet();
        Iterator<String> it = keySet.iterator();
        while(it.hasNext()){
            score.put(it.next(), 0);
        }
        for(int i = 0; i<visitors.size();++i){
            int temp_score = score.get(visitors.get(i));
            score.replace(visitors.get(i), temp_score+1);
        }

        // friends 관계를 토대로 score 갱신
        List<String> userFriends = friendsMap.get(user);
        for(int i = 0; i<userFriends.size();++i){
            String userFriend = userFriends.get(i);

            List<String> userFriendsFriends = friendsMap.get(userFriend);
            for(int j = 0; j<userFriendsFriends.size();++j){
                int temp_score = score.get(userFriendsFriends.get(j));
                score.replace(userFriendsFriends.get(j), temp_score+10);
            }
        }

        System.out.println(score);

        // score value 기준으로 정렬


        List<Map.Entry<String, Integer>> list = new ArrayList<>(score.entrySet());
        list.sort((entry1, entry2) -> {
            int cmp = entry2.getValue().compareTo(entry1.getValue());
            if (cmp == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return cmp;
        });

        int count = 0;

        for (Map.Entry<String, Integer> entry : list) {
            String key = entry.getKey();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            if(score.get(key)!=0 && !key.equals(user) && !friendsMap.get(user).contains(key)){
                answer.add(key);
                ++count;
            }
            if(count == 5){
                break;
            }
        }

        //donut, shakevan
        return answer;
    }
}
