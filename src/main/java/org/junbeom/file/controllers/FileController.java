package org.junbeom.file.controllers;

import lombok.RequiredArgsConstructor;
import org.junbeom.file.entities.FileInfo;
import org.junbeom.file.services.FileUploadService;
import org.junbeom.global.exceptions.RestExceptionProcessor;
import org.junbeom.global.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController implements RestExceptionProcessor {

    private final FileUploadService uploadService;

        @PostMapping("/upload")
        public ResponseEntity <JSONData> upload(@RequestPart("file")MultipartFile[] files,
                                              @RequestParam(name="gid", required = false )
                                              String gid,
                                              @RequestParam(name="location", required = false)
                                                        String location) {

            List<FileInfo> items = uploadService.upload(files, gid, location);
            HttpStatus status = HttpStatus.CREATED;
            JSONData data = new JSONData(items);
            data.setStatus(status);

            return ResponseEntity.status(status).body(data);

        }

        private String getUid() {
            return UUID.randomUUID().toString();
        }
    }

