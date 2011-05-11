/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package compress.gzip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import compress.Constants;

public class SampleOnByteArray {

    static byte[] bytes = null;
    static byte[] buf = new byte[1024];
    static int count = -1;

    public static void main(String args[]) throws Exception {
        byte[] b1 = gzip(Constants.textForCompress.getBytes());
        byte[] b2 = ungzip(b1);
        String newStr = new String(b2);
        System.out.println();

        if (Constants.textForCompress.equals(newStr)) {
            System.out.println("-- Demo success!");
        } else {
            System.out.println("-- Demo failed!");
        }
    }

    private static byte[] gzip(byte[] data) throws Exception {
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        GZIPOutputStream gzipOs = new GZIPOutputStream(byteOs);

        gzipOs.write(data);
        gzipOs.finish();
        bytes = byteOs.toByteArray();

        byteOs.close();
        gzipOs.close();
        return bytes;
    }

    private static byte[] ungzip(byte[] data) throws Exception {
        GZIPInputStream gzipIs = new GZIPInputStream(new ByteArrayInputStream(data));
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();

        while ((count = gzipIs.read(buf)) > 0) {
            byteOs.write(buf, 0, count);
        }
        byteOs.flush();
        bytes = byteOs.toByteArray();

        byteOs.close();
        gzipIs.close();
        return bytes;
    }
}
