package javadoc;

/**
 * <!-- first sentence is showing as "desc" for the class --> <br>
 * Demonstrating how to write java doc, for html tags, annotations in java doc,
 * see other related demo files.
 * 
 */
public class JavaDocDemo {

	/**
	 * For the demo of comments on method.
	 * 
	 * <pre>
	 * public class Example {
	 * 	final int a = 1;
	 * 	final boolean b = true;
	 * }
	 * </pre>
	 * 
	 * @param firstString whom to greet
	 * @param secondString whom to greet
	 * @return whether the two string are the same
	 */
	public boolean concat(String firstString, String secondString) {
		return firstString.equals(secondString);
	}
}