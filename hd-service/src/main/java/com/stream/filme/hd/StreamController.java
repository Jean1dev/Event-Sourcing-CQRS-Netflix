package com.stream.filme.hd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hd")
public class StreamController {

    @Autowired
    private DownloadService downloadService;

    @GetMapping(produces = "video/mp4")
    public ResponseEntity<InputStreamResource> stream() {
        StreamResource resource = downloadService.get();

        InputStreamResource inputStreamResource = new InputStreamResource(resource.getStream());
        long size = resource.getSize();

        return ResponseEntity.ok()
                .contentLength(size)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getExt() + "\"")
                .body(inputStreamResource);
    }
}
