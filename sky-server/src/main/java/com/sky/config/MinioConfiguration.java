/*package com.sky.config;

import com.sky.properties.MinioProperties;
import com.sky.utils.MinioUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*//**
 * 配置类，用于船舰AliOssutil对象
 *//*
@Configuration
@Slf4j
public class MinioConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public MinioUtill minioUtill(MinioProperties minioProperties){
        log.info("开始上传minio文件工具类对象：{}",minioProperties);
        return new MinioUtill(minioProperties.getEndpoint(),
                minioProperties.getAccessKey(),
                minioProperties.getSecretKey(),
                minioProperties.getBucketName());
    }
}*/
