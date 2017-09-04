package com.koo.springmybatis.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class FileHelper {
    private static final Logger LOG = LoggerFactory.getLogger(FileHelper.class);

    /**
     * 演示向文件中写入字节流
     *
     * @param fileName 要写入文件的文件名
     * @param contents 要写入的文件内容
     */
    public void doFileWrite(final String fileName, final String contents) {
        checkNotNull(fileName, "Provided file name for writing must NOT be null.");
        checkNotNull(contents, "Unable to write null contents.");
        final File newFile = new File(fileName);
        try {
            Files.append(contents+"\n", newFile, Charsets.UTF_8);
        } catch (IOException fileIoEx) {
            LOG.error("ERROR trying to write to file {} - {}", fileName, fileIoEx.toString());
        }
    }
    
}

