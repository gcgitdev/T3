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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.thoughtworks.xstream.XStream;

public class XstreamMapping {

    private static XStream xstream = new XStream();

    public static void main(String[] args) {
        xstream.alias("MappingTestBean", MappingTestBean.class);
        xstream.alias("Target", String.class);
        testFromObjToXml();
        testFromXmlToObj();
    }

    private static void testFromObjToXml() {
        MappingTestBean mtb = new MappingTestBean();
        String xml = xstream.toXML(mtb);
        System.out.println(xml);
    }

    /*
     * Notice that the fields are private. XStream doesn't care about the
     * visibility of the fields. No getters or setters are needed. Also, XStream
     * does not limit you to having a default constructor.
     */
    private static void testFromXmlToObj() {
        String xml2 = "<xml.mapping.xstream.MappingTestBean> <stringParam>aaa</stringParam> <integerParam>9</integerParam> <arrayStringParam> <string>ggg</string> <string>hhh</string> <string>222</string> </arrayStringParam> <listStringParam> <string>bbb</string> <string>ccc</string> <string>111</string> </listStringParam> <mapStringParam> <entry> <string>f</string> <string>fff</string> </entry> <entry> <string>e</string> <string>eee</string> </entry> </mapStringParam> </xml.mapping.xstream.MappingTestBean>";
        String xml3 = "<MappingTestBean> <stringParam>aaa</stringParam> <integerParam>9</integerParam> <arrayStringParam> <string>ggg</string> <string>hhh</string> <string>222</string> </arrayStringParam> <listStringParam> <string>bbb</string> <string>ccc</string> <string>111</string> </listStringParam> <mapStringParam> <entry> <string>f</string> <string>fff</string> </entry> <entry> <string>e</string> <string>eee</string> </entry> </mapStringParam> </MappingTestBean>";
        MappingTestBean mtb2 = (MappingTestBean) xstream.fromXML(xml2);
        MappingTestBean mtb3 = (MappingTestBean) xstream.fromXML(xml3);
        System.out.println(ReflectionToStringBuilder.toString(mtb2));
        System.out.println(ReflectionToStringBuilder.toString(mtb3));
    }

}
