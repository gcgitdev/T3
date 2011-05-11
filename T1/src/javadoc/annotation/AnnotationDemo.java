package javadoc.annotation;

/**
 * Demonstrating how to use annotations in java doc
 * 
 * Link:<br>
 * For the usage of HTML tags, see {@link javadoc.html.HtmlTagsDemo}
 * 
 * Annotations: <br>
 * <!-- one place for all "@see", usually ordered from nearest to farest, the method is also in "telescope" order -->
 * 
 * @see #AnnotationDemo()
 * @see DummyClass
 * @see DummyClass#DummyClass()
 * @see DummyClass#DummyClass(String)
 * @see javadoc.html.HtmlTagsDemo
 * @see javadoc.html.HtmlTagsDemo#HtmlTagsDemo() <!-- demo how to ref a method -->
 */
public class AnnotationDemo {
	public AnnotationDemo() {
	}
}
