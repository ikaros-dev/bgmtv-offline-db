package run.ikaros.offlinedb.bgmtv.utils;

import java.io.File;
import java.io.IOException;

class FileUtilsTest {

    // @Test
    void unZipFile() throws IOException {
        String zipFilePath = "C:\\Users\\li-guohao\\Documents\\bgmtv\\2022-11-23 050228-011517+0800-bgmtv-dump.zip";
        String destDirPath = "C:\\Users\\li-guohao\\Documents\\bgmtv\\target";
        FileUtils.unZipFile(new File(zipFilePath), destDirPath);
    }
}