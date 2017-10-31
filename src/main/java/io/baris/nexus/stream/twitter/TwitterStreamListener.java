package io.baris.nexus.stream.twitter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PostConstruct;

@Component
public class TwitterStreamListener {

    @Autowired
    private TwitterStatusInterceptor twitterStatusInterceptor;

    @PostConstruct
    public void init(){
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterStatusInterceptor);
        twitterStream.sample();
    }
}
