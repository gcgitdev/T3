/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package jdbc.javadb;

import org.apache.derby.drda.NetworkServerControl;

public class StartNetworkServer {
    public static void main(String[] args) throws Exception {
        String[] args2 = new String[1];
        args2[0] = "start";
        NetworkServerControl.main(args2);
    }
}
