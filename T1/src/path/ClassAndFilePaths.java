/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package path;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ClassAndFilePaths {
    public static void main(String[] args) throws Exception {
        ClassAndFilePaths cfp = new ClassAndFilePaths();
        cfp.demoPathOfFileSystem();
        cfp.demoPathOfClassloader();
    }

    final String ASCII_PATH_FILE_SYSTEM = "./src/path/test_text_file.ascii.txt";
    final String ASCII_PATH_CLASSLOADER = "./path/test_text_file.ascii.txt";

    public void demoPathOfFileSystem() throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(ASCII_PATH_FILE_SYSTEM));
        BufferedReader reader = new BufferedReader(isr);

        System.out.println("--> Reading file through file system path:" + ASCII_PATH_FILE_SYSTEM);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void demoPathOfClassloader() throws Exception {
        System.out.println("--> Reading file through classloader path:" + ASCII_PATH_CLASSLOADER);
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(ASCII_PATH_CLASSLOADER);
        Properties p = new Properties();
        p.load(in);
        System.out.println(p.get("dirverClass"));
        System.out.println(p.get("user"));
        System.out.println(p.get("password"));
        in.close();
    }
}
