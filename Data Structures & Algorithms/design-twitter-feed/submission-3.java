class Twitter {

    public record Tweet(int id, int time) {}

    private final Map<Integer, Set<Integer>> follows;
    private final Map<Integer, List<Tweet>> tweets;
    private int time;

    public Twitter() {
        this.follows = new HashMap<>();
        this.tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        final List<Tweet> posts = tweets.computeIfAbsent(userId, k -> new ArrayList<>());
        posts.add(new Tweet(tweetId, time++));
        if (posts.size() > 10) {
            posts.removeFirst();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        final Set<Integer> followsList = new HashSet<>(follows.getOrDefault(userId, new HashSet<>()));
        followsList.add(userId);

        final Queue<Tweet> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        for (int follow : followsList) {
            if (!tweets.containsKey(follow)) {
                continue;
            }
            List<Tweet> posts = tweets.get(follow);
            for (Tweet post : posts) queue.add(post);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (queue.isEmpty()) break;
            list.add(queue.poll().id);
        }

        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        this.follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        this.follows.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }
}
