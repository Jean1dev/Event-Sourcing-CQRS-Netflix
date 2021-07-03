package com.stream.filme.hd;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StreamResource {

    private S3ObjectInputStream stream;
    private long size;
    private String ext;
}
