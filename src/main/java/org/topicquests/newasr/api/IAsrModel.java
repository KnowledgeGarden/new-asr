/**
 * 
 */
package org.topicquests.newasr.api;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public interface IAsrModel {

	/**
	 * Process a given {@code sentence}
	 * @param sentenceId
	 * @param sentence
	 * @return
	 */
	IResult processSentence(long sentenceId, String sentence);
	
	/**
	 * Create an {@link IWordGram} from {@code term} -used for bootstrapping and elsewhere
	 * @param term
	 * @param pos can be {@code null}
	 * @return returns term's ID as String
	 */
	IResult processTerm(String term, String pos);
}
