package run.ikaros.offlinedb.bgmtv.utils;

import java.io.File;

public class SystemVarUtils {
    public static String getCurrentAppDirPath() {
        return System.getProperty("user.dir");
    }

    public static String getCurrentAppCacheDirPath() {
        String cacheDirPath = getCurrentAppDirPath() + File.separator + "caches";
        File cacheDir = new File(cacheDirPath);
        if(!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDirPath;
    }

    public static synchronized void clearCurrentAppCacheDir() {
        String currentAppDirPath = getCurrentAppDirPath();
        File cacheDir = new File(currentAppDirPath);
        File[] files = cacheDir.listFiles();
        for (File file : files) {
            if(file.exists()) {
                file.delete();
            }
        }
    }
}
