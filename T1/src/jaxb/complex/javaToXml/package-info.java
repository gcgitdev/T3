// every java.util.Date class in the vet package should be
// processed by DateAdapter
@XmlJavaTypeAdapter(value = DateAdapter.class, type = Date.class)
package jaxb.complex.javaToXml;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

