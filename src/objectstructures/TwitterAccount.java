package objectstructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwitterAccount {
	
	
	private String username;
	private Set<TwitterAccount> following;
	private List<Tweet> tweets;
	private Set<Tweet> retweets;
	
	public TwitterAccount(String username) {
		this.username = username;
		this.following = new HashSet<TwitterAccount>();
		this.tweets = new ArrayList<Tweet>();
		this.retweets = new HashSet<Tweet>();
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public void follow(TwitterAccount account) {
		this.following.add(account);
	}
	
	public void unfollow(TwitterAccount account) {
		this.following.remove(account);
	}
	
	public boolean isFollowing(TwitterAccount account) {
		return this.following.contains(account);
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		return account.isFollowing(this);
	}
	
	public void tweet(String message) {
		this.tweets.add(new Tweet(this,message));
	}
	
	public void retweet(Tweet tweet) {
		this.retweets.add(new Tweet(this,tweet));
	}
	
	public Tweet getTweet(int i) {
		return this.tweets.get(i);
	}
	
	
	public int getTweetCount() {
		return this.tweets.size();
	}
	
	public int getRetweetCount() {
		return this.retweets.size();
	}
	
}
