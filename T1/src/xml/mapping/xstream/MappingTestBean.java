/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package xml.mapping.xstream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappingTestBean {
    public MappingTestBean() {
        stringParam = "aaa";
        integerParam = new Integer(9);
        arrayStringParam = new String[2];
        arrayStringParam[0] = "ggg";
        arrayStringParam[1] = "hhh";
        listStringParam = new ArrayList<String>();
        listStringParam.add("bbb");
        listStringParam.add("ccc");
        mapStringParam = new HashMap<String, String>();
        mapStringParam.put("e", "eee");
        mapStringParam.put("f", "fff");
    }

    private String stringParam;
    private Integer integerParam;
    private String[] arrayStringParam;
    private List<String> listStringParam;
    private Map<String, String> mapStringParam;
}
