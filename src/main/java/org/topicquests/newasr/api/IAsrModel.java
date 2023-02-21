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
}
