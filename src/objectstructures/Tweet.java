package objectstructures;



public class Tweet {
	
	private TwitterAccount account;
	private String message;
	private Tweet originalTweet;
	private boolean isRetweet;
	private int counter;
	
	public Tweet(TwitterAccount account, String message) {
		this.account = account;
		this.message = message;
		this.isRetweet = false;
		this.counter = 0;
	}
	
	public Tweet(TwitterAccount account, Tweet tweet) {
		if (tweet.getOwner().equals(account)) {
			throw new IllegalArgumentException();
		}
		this.account = account;
		this.message = tweet.getText();
		this.originalTweet = tweet.getOriginalTweet();
		this.originalTweet.countRetweet();
		this.isRetweet = true;
		
	}
	
	public void countRetweet() {
		this.counter += 1;
	}
	
	
	public String getText() {
		return this.message;
	}
	
	public TwitterAccount getOwner() {
		return this.account;
	}
	
	public Tweet getOriginalTweet() {
		return !this.isRetweet ? null : this;
	}
	
	public int getRetweetCount() {
		return this.counter;
	}
	
	
	
	

}
