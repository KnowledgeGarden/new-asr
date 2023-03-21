/**
 * 
 */
package org.topicquests.newasr.pred;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public class PredicateAssembler {
	private ASREnvironment environment;

	/**
	 * 
	 */
	public PredicateAssembler(ASREnvironment e) {
		environment = e;
	}

	public IResult processSentencePredicates(JsonObject sentence, JsonObject predicates) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}
}
