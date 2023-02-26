/**
 * 
 */
package org.topicquests.newasr.wg;

import com.google.common.base.Splitter;

/**
 * @author jackpark
 *
 */
public class WordGramUtil {

	/**
	 * 
	 */
	public WordGramUtil() {
		// TODO Auto-generated constructor stub
	}

	public String [] splitSentence(String sentence) {
		String [] result = null;
		Iterable<String> ix = Splitter.on(' ')
			       .trimResults()
			       .omitEmptyStrings()
			       .split(sentence);
		return result;
	}
}
