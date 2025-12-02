 

package com.auto.mall.config;

import com.auto.mall.config.codec.FastJsonCodec;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(
        prefix = "mall.redis"
)
public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    private String host = "redis://127.0.0.1:6380";
    private String password = "";
    private ServerModel serverModel;

    public RedisConfig() {
        this.serverModel = com.auto.mall.config.RedisConfig.ServerModel.Single;
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        if (this.serverModel == com.auto.mall.config.RedisConfig.ServerModel.Single) {
            config.useSingleServer().setAddress(this.host);
        }

        logger.info("init redis service:{}, model:{}", this.host, this.serverModel.name());
        config.setCodec(new FastJsonCodec());
        return Redisson.create(config);
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return this.password;
    }

    public ServerModel getServerModel() {
        return this.serverModel;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setServerModel(final ServerModel serverModel) {
        this.serverModel = serverModel;
    }

    public enum ServerModel {


        Single;

        private ServerModel() {
        }
    }
}
