## Synopsis
This will be a project to monitor trending tweets on given keywords.

It will use an api to search tweets and visualize them to create charts and feeds

The tech stack in my head is:

A message queue like rabbitmq(redis or kafka maybe?)
Elasticsearch for indexing
A rest api with spring boot
React for frontend

## Motivation
Improve my knowledge about technologies i am interested in
To create a continuous integration/deployment process
To practice tdd and refactor without any deadlines

## Installation

Add a twitter4j.properties file under src/main/resources with the following format

```
oauth.consumerKey=*******************
oauth.consumerSecret=*******************
oauth.accessToken=*******************
oauth.accessTokenSecret=*******************
```

Run elasticsearch on localhost:9200

