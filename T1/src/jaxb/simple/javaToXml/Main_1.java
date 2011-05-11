/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package jaxb.simple.javaToXml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main_1 {

    public static void main(String[] args) throws JAXBException, IOException {

        Bookstore bookstore = createBookstore();
        StringWriter sw = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(bookstore, sw);

        sw.flush();
        String xml = sw.toString();
        sw.close();
        System.out.println(xml);

        Unmarshaller um = context.createUnmarshaller();
        Bookstore bookstore2 = (Bookstore) um.unmarshal(new StringReader(xml));

        for (int i = 0; i < bookstore2.getBooksList().toArray().length; i++) {
            System.out.println("Book " + (i + 1) + ": " + bookstore2.getBooksList().get(i).getName() + " from "
                    + bookstore2.getBooksList().get(i).getAuthor());
        }
    }

    private static Bookstore createBookstore() {
        ArrayList<Book> bookList = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setName("The Game");
        book1.setAuthor("Neil Strauss");
        bookList.add(book1);
        Book book2 = new Book();
        book2.setName("Feuchtgebiete");
        book2.setAuthor("Charlotte Roche");
        bookList.add(book2);

        Bookstore bookstore = new Bookstore();
        bookstore.setName("Fraport Bookstore");
        bookstore.setLocation("Frankfurt Airport");
        bookstore.setBookList(bookList);

        return bookstore;
    }
}
