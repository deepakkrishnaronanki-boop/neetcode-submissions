class Twitter {

    private Map<Integer, List<Tweet>> tweetsMap;
    private Map<Integer, Set<Integer>> followeesMap;
    private int tweetCounter;

    public Twitter() {
        tweetCounter = 0;
        tweetsMap = new HashMap<>();
        followeesMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, tweetCounter++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = followeesMap.getOrDefault(userId, new HashSet<>());
        users.add(userId);

        PriorityQueue<Tweet> tweets = new PriorityQueue<>((a, b) -> Integer.compare(b.timestamp, a.timestamp));

        for(int user : users) {
            List<Tweet> userTweets = tweetsMap.getOrDefault(user, new ArrayList<>());
            for(Tweet tweet : userTweets) {
                tweets.offer(tweet);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!tweets.isEmpty()) {
            res.add(tweets.poll().tweetId);
            if(res.size() >= 10) return res;
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followeesMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(followeesMap.containsKey(followerId)) {
            followeesMap.get(followerId).remove((Integer) followeeId);
        }
    }
}

class Tweet {
    int tweetId;
    int timestamp;

    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
}
