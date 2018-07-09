package Design;

import java.util.*;

public class DesignTwitter {
    public class Tweet {
        int time;
        int tweetId;

        public Tweet(int tweetId, int time) {
            this.time = time;
            this.tweetId = tweetId;
        }
    }

    private int tweetCount;
    private Map<Integer, HashSet<Integer>> followees;
    private Map<Integer, List<Tweet>> tweets;

    public DesignTwitter() {
        this.tweetCount = 0;
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Tweet>());
        }
        tweets.get(userId).add(new Tweet(tweetId, ++tweetCount));
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        if (!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<Integer>());
        }
        followees.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        if (!followees.containsKey(followerId)) return;
        followees.get(followerId).remove(followeeId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> res = new ArrayList<>();
        HashSet<Integer> followee = followees.get(userId);
        List<Tweet> tweet = tweets.get(userId);
        if (tweet!=null) {
            for (int i=tweet.size()-1; i>=Math.max(0, tweet.size()-10); --i){
                res.add(tweet.get(i));

            }
        }
        if (followee!=null){
            for (Integer f : followee){
                tweet=tweets.get(f);
                // System.out.println(tweet.size());
                if (tweet==null) continue;
                for (int i=tweet.size()-1; i>=Math.max(0, tweet.size()-10); --i){
                    res.add(tweet.get(i));
                }
            }
        }
        Collections.sort(res, new Comparator<Tweet>(){
            public int compare(Tweet o1, Tweet o2){
                return o2.time-o1.time;
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<Math.min(10, res.size()); i++){
            list.add(res.get(i).tweetId);
        }
        return list;
    }
}

