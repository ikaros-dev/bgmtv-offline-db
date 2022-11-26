package run.ikaros.offline.db.bgmtv.utils;


import org.springframework.util.Assert;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


public class FileUtils {


    private static final String BASE_UPLOAD_DIR_NAME = "upload";

    private static final String BASE_UPLOAD_DIR_PATH
        = System.getProperty("user.dir") + File.separator + BASE_UPLOAD_DIR_NAME;

    public enum Hash {
        MD5("MD5"),
        SHA1("SHA1"),
        SHA256("SHA-256"),
        SHA512("SHA-512");
        private final String name;

        Hash(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }



    public static byte[] checksum(byte[] bytes, Hash hash) throws RuntimeException {
        try (InputStream in = new ByteArrayInputStream(bytes)) {
            MessageDigest digest = MessageDigest.getInstance(hash.getName());
            byte[] block = new byte[4096];
            int length;
            while ((length = in.read(block)) > 0) {
                digest.update(block, 0, length);
            }
            return digest.digest();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String checksum2Str(byte[] bytes, Hash hash)
        throws RuntimeException {
        return DatatypeConverter.printHexBinary(checksum(bytes, hash));
    }

    public static void deleteDirByRecursion(String dirPath) {
        File parentFile = new File(dirPath);
        boolean deleteSuccess = true;
        File[] files = parentFile.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            deleteDirByRecursion(file.getPath());
            if (file.exists()) {
                deleteSuccess = file.delete();
            }
            if (!deleteSuccess) {
                throw new RuntimeException("delete file fail, current path: " + file.getAbsolutePath());
            }
        }
    }


    /**
     * @return 条目数据的文件路径，格式：[upload/yyyy/MM/dd/HH/随机生成的UUID.postfix]
     */
    public static String buildAppUploadFilePath(String postfix) {
        Assert.hasText(postfix, "'postfix' must not be blank");
        return buildAppUploadFileBasePath(LocalDateTime.now())
            + File.separator + UUID.randomUUID().toString().replace("-", "")
            + (('.' == postfix.charAt(0))
            ? postfix : "." + postfix);
    }

    /**
     * @param uploadedTime 条目数据上传的时间
     * @return 基础的上传目录路径，格式：[upload/yyyy/MM/dd/HH]
     */
    public static String buildAppUploadFileBasePath(LocalDateTime uploadedTime) {
        Assert.notNull(uploadedTime, "'uploadedTime' must not be null");
        String locationDirPath = BASE_UPLOAD_DIR_PATH
            + File.separator + uploadedTime.getYear()
            + File.separator + uploadedTime.getMonthValue()
            + File.separator + uploadedTime.getDayOfMonth();

        File locationDir = new File(locationDirPath);
        if (!locationDir.exists()) {
            locationDir.mkdirs();
        }
        return locationDirPath;
    }

    public static String parseFilePostfix(String originalFilename) {
        Assert.hasText(originalFilename, "'originalFilename' must has text");
        int dotIndex = originalFilename.lastIndexOf(".");
        return originalFilename.substring(dotIndex + 1);
    }

    public static String parseFileName(String filePath) {
        Assert.hasText(filePath, "'filePath' must has text");
        return filePath.substring(filePath.lastIndexOf("/") + 1);
    }
}
