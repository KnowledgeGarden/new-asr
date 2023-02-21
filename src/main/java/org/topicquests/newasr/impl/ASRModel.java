/**
 * 
 */
package org.topicquests.newasr.impl;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class ASRModel implements IAsrModel {
	private ASREnvironment environment;

	/**
	 * 
	 */
	public ASRModel(ASREnvironment e) {
		environment = e;
	}

	@Override
	public IResult processSentence(long sentenceId, String sentence) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

}
