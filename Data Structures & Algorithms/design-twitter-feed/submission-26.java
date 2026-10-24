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
        Set<Integer> users = new HashSet<>(followeesMap.getOrDefault(userId, Collections.emptySet()));
        users.add(userId);

        List<Integer> res = new ArrayList<>();

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for(int user : users) {
            List<Tweet> userTweets = tweetsMap.getOrDefault(user, new ArrayList<>());
            if(userTweets.size() > 0) {
                Tweet tweet = userTweets.get(userTweets.size() - 1);
                maxHeap.offer(new int[]{tweet.tweetId,tweet.timestamp,userTweets.size()-1,user});
            }
        }

        while(!maxHeap.isEmpty() && res.size() < 10) {
            int[] tweet = maxHeap.poll();
            int index = tweet[2];
            int user = tweet[3];

            if(index > 0) {
                List<Tweet> userTweets = tweetsMap.getOrDefault(user, new ArrayList<>());
                Tweet userTweet = userTweets.get(index-1);
                maxHeap.offer(new int[]{userTweet.tweetId,userTweet.timestamp,index-1,user});
            }
            res.add(tweet[0]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followeesMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if(followeesMap.containsKey(followerId)) {
            followeesMap.get(followerId).remove(followeeId);
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
