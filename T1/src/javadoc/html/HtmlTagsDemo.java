package javadoc.html;

/**
 * Shows the usage of html tags in java doc. Still many thing included like not often used tags, most attributes.<br>
 * 
 * <h4>Formats</h4><br>
 * Format: (the title of this part "Formats" above, is in "h4" tag)<br>
 * Format: <big> text in "big" (big font) tag </big> <br>
 * Format: <s> text in "s" (strike line) tag </s> <br>
 * Format: <u> text in "u" (under line) tag </u> <br>
 * Format: <i> text in "i" (italic) tag </i> <br>
 * Format: <em> text in "em" (emphasize) tag </em> <br>
 * Format: <b> text in "b" (bold) tag </b> <br>
 * Format: <strong> text in "strong" (like bold) tag </strong> <br>
 * Format: <sup> text in "sup" (superscript) tag </sup> <br>
 * Format: <sub> text in "sub" (subscript) tag </sub> <br>
 * Format: <code> text in "code" tag --> public void main(Sting[] argv) </code> <br>
 * Format: <small> text in "small" tag </small> <br>
 * Format: <q>text in "q" (quta?) tag</q> <br>
 * Format: <font size=3> Now the font size is 3. </font> <br>
 * Format: <font size=6> Now the font size is 6. </font> <br>
 * 
 * <h4>Code Sample</h4><br>
 * <pre>
 * public class Example {
 *     final int a = 1;
 *     final boolean b = true;
 * }
 * </pre>
 * 
 * <h4>Lists</h4><br>
 * &lt;ol&gt; & &lt;/ol&gt; is ordered list
 * <ol>
 * <li>&lt;li&gt; is the list item
 * <li>&lt;li&gt; is the list item
 * </ol>
 * <p>
 * 
 * &lt;ul&gt; & &lt;/ul&gt; is unordered list
 * <ul>
 * <li>&lt;li&gt; is the list item
 * <li>&lt;li&gt; is the list item
 * </ul>
 * 
 * &lt;dl&gt; & &lt;/dl&gt; is definition list, use &lt;dt&gt; & &lt;dd&gt; for the item name & definition
 * <dl>
 * <dt>Cat
 * <dd>Some kind of animal....
 * <dt>Dog
 * <dd>Also some kind of animal....
 * </dl>
 * 
 * <h4>Tables</h4><br>
 * <table border=1>
 * <caption> This is the table caption </caption>
 * <tr>
 * <th>Tag
 * <th>Attribute
 * <th>Usage
 * <tr> 
 * <td>&lt;table&gt;
 * <td> 
 * <td>defines a table
 * <tr> 
 * <td>
 * <td>border
 * <td>border line weight
 * <tr> 
 * <td>&lt;tr&gt;
 * <td> 
 * <td>new line of the table
 * <tr> 
 * <td>&lt;td&gt;
 * <td>
 * <td>new tab of the line
 * </table>
 * 
 * <h4>Appearance</h4><br>
 * &xxx; Shows the original tag like &lt;q&gt; &lt;/q&gt; <br>
 * &lt;p&gt; New a paragraph <br>
 * &lt;br&gt; Force a line break: "\<br\>" force a text split <br>
 * &lt;hr&gt; Show a horizon line break <br>
 * &lt;center&gt; Show the content in center <br>
 * 
 * <h4>Resource</h4><br>
 * <!-- note, the path is based on the generated html file path -->
 * <a href="../../../resource/html_tags/HTML_Tags.HTM"> HTML Tags </a> <br>
 * <a href="../../../resource/html_tags/HTML_Reference.HTM"> HTML Reference </a> <br>
 * <a href="../../../resource/html_tags/HTML_Index.HTM"> HTML Index </a> <br>
 */
public class HtmlTagsDemo {
}
