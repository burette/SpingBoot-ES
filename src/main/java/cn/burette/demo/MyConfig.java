package cn.burette.demo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

@Configuration
public class MyConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {
        TransportAddress node = new TransportAddress(
                InetAddress.getByName("localhost"), 9300
        );
        Settings settings = Settings.builder()
                .put("cluster.name", "burette").build();

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        client.addTransportAddress(node);
//        client.addTransportAddress(node);   //多个节点，前面new多个在此加入

        return client;
    }
}
