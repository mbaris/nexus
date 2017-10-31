package io.baris.esports.repository.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.baris.esports.dto.TwitterStatus;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Repository
public class ElasticsearchTwitterStatusRepository implements TwitterStatusRepository {

    private TransportClient client;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() throws UnknownHostException {
        client= new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    @Override
    public IndexResponse save(TwitterStatus twitterStatus) throws JsonProcessingException {
        return client.prepareIndex("esports", "status").setSource(objectMapper.writeValueAsString(twitterStatus), XContentType.JSON).execute().actionGet();
    }

    @Override
    public void delete(TwitterStatus twitterStatus) {

    }

    @Override
    public TwitterStatus findOne(String id) {
        return null;
    }

    @Override
    public Iterable<TwitterStatus> findAll() {
        return null;
    }
}
