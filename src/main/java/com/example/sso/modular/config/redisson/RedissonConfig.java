package com.example.sso.modular.config.redisson;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonConfig {

    @Autowired
    private RedissonProperties redissonProperties;


    /**
     * 单机模式自动装配
     * @return
     */
    @Bean
    RedissonClient redissonClient() {
        Config config = new Config();
        config.setCodec(new StringCodec());
        String address = redissonProperties.getAddress();
        if(null!=address ){
            address = "redis://127.0.0.1:6379";
            redissonProperties.setAddress(address);
        }

        if(address.indexOf(",")>=0){
            String[] split = address.split(",");
            List<String> strings = Arrays.asList(split);
            ClusterServersConfig clusterServersConfig = config.useClusterServers();
            clusterServersConfig.setScanInterval(2000);
            for (String string : strings) {
                clusterServersConfig.addNodeAddress(string);
            }
            clusterServersConfig.setTimeout(redissonProperties.getTimeout());

            if(null!=(redissonProperties.getPassword())) {
                clusterServersConfig.setPassword(redissonProperties.getPassword());
            }

            return Redisson.create(config);
        }else{
            SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setTimeout(redissonProperties.getTimeout())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());

            if(null!=(redissonProperties.getPassword())) {
                serverConfig.setPassword(redissonProperties.getPassword());
            }

            return Redisson.create(config);
        }
    }


}
