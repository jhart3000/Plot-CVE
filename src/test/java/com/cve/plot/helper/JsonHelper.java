package com.cve.plot.helper;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.readAllBytes;
import static org.springframework.util.ResourceUtils.getFile;

public class JsonHelper {

  public static String loadJsonFile(String path) throws IOException {
    File file = getFile("classpath:" + path);
    return new String(readAllBytes(file.toPath()));
  }
}
