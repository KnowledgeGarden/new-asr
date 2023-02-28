/**
 * 
 */
package org.topicquests.newasr.test;

import org.topicquests.newasr.api.IWordGram;
import org.topicquests.newasr.impl.WordGram;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class FirstNodeTest extends TestingRoot {
	public static final String
		TERM	= "Fool Bar",
		POS		= "noun";
	/**
	 * 
	 */
	public FirstNodeTest() {
		super();
		
		//IWordGram wg = new WordGram();
		IResult r = model.processTerm(TERM, POS);
		System.out.println("A "+r.getErrorString());
		System.out.println("B "+r.getResultObject());
		
		environment.shutDown();
		System.exit(0);
	}

}
