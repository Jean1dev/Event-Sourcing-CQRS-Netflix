package com.stream.filme.hd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {

    @Autowired
    private S3Service s3;

    public StreamResource get() {
        return StreamResource.builder()
                .stream(s3.getVideo("teste.mkv"))
                .size(5083276)
                .ext("video-hd.mp4")
                .build();
    }
}
