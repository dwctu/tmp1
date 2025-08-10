package org.jivesoftware.smack.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public final class FileUtils {
    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    public static boolean addLines(String str, Set<String> set) throws IOException {
        InputStream streamForUrl = getStreamForUrl(str, null);
        if (streamForUrl == null) {
            return false;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(streamForUrl));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return true;
            }
            set.add(line);
        }
    }

    public static List<ClassLoader> getClassLoaders() {
        ClassLoader[] classLoaderArr = {FileUtils.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return arrayList;
    }

    public static InputStream getStreamForUrl(String str, ClassLoader classLoader) throws IOException {
        URI uriCreate = URI.create(str);
        if (uriCreate.getScheme() == null) {
            throw new MalformedURLException("No protocol found in file URL: " + str);
        }
        if (!uriCreate.getScheme().equals("classpath")) {
            return uriCreate.toURL().openStream();
        }
        List<ClassLoader> classLoaders = getClassLoaders();
        if (classLoader != null) {
            classLoaders.add(0, classLoader);
        }
        Iterator<ClassLoader> it = classLoaders.iterator();
        while (it.hasNext()) {
            InputStream resourceAsStream = it.next().getResourceAsStream(uriCreate.getSchemeSpecificPart());
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
        }
        return null;
    }

    public static String readFile(File file) {
        try {
            return readFileOrThrow(file);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.FINE, "readFile", (Throwable) e);
            return null;
        } catch (IOException e2) {
            LOGGER.log(Level.WARNING, "readFile", (Throwable) e2);
            return null;
        }
    }

    public static String readFileOrThrow(File file) throws Throwable {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[8192];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i = fileReader.read(cArr);
                if (i < 0) {
                    String string = sb.toString();
                    fileReader.close();
                    return string;
                }
                sb.append(cArr, 0, i);
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                fileReader2.close();
            }
            throw th;
        }
    }

    public static boolean writeFile(File file, String str) {
        try {
            writeFileOrThrow(file, str);
            return true;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "writeFile", (Throwable) e);
            return false;
        }
    }

    public static void writeFileOrThrow(File file, String str) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(str);
        fileWriter.close();
    }
}
