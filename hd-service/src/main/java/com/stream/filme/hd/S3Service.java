package com.stream.filme.hd;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    @Value("${s3.access.key}")
    private String accessKey;

    @Value("${s3.access.secret}")
    private String secretKey;

    @Value("${s3.access.host}")
    private String host;

    @Value("${s3.access.bucket}")
    private String bucket;

    public S3ObjectInputStream getVideo(String path) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client s3Client = new AmazonS3Client(credentials, new ClientConfiguration().withSignerOverride("S3SignerType"));

        s3Client.setS3ClientOptions(S3ClientOptions.builder()
                .setPathStyleAccess(true)
                .build());

        s3Client.setEndpoint(host);

        S3Object object = s3Client.getObject(bucket, path);

        return object.getObjectContent();
    }
}
