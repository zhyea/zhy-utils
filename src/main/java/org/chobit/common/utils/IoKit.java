package org.chobit.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * IO操作类
 */
public final class IoKit {


    private static final Logger logger = LoggerFactory.getLogger(IoKit.class);


    /**
     * 将数据保存到本地
     *
     * @param src        源数据
     * @param targetPath 本地路径
     */
    public static void save(byte[] src, String targetPath) {
        try (FileOutputStream out = new FileOutputStream(targetPath)) {
            out.write(src);
            out.flush();
        } catch (IOException e) {
            logger.error("write to {} error.", targetPath, e);
        }
    }


    /**
     * 读取txt文本文件
     *
     * @param path 文件路径
     * @return 读取到的文本
     */
    public static String readTxt(String path) {
        try (
                InputStream input = Files.newInputStream(Paths.get(path));
                InputStreamReader read = new InputStreamReader(input);
                BufferedReader bufferedReader = new BufferedReader(read)
        ) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            logger.error("read txt file failed. path:{}", path, e);
        }
        return "";
    }


    private IoKit() {
        throw new UnsupportedOperationException("Private constructor, cannot be accessed.");
    }

}
