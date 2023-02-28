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
	 * <p>Create an {@link IWordGram} from {@code term} -used for bootstrapping and elsewhere</p>
	 * <p>If term already exists, just returns its ID.
	 * @param term
	 * @param pos can be {@code null}
	 * @return returns term's ID as String
	 */
	IResult processTerm(String term, String pos);
	
	/**
	 * Fetch a term by its {@code id}
	 * @param id
	 * @return
	 */
	IResult getTermById(String id);
	
	/**
	 * Same as $getTermById but does not check cache
	 * @param id
	 * @return
	 */
	IResult getThisTermById(String id);
}
