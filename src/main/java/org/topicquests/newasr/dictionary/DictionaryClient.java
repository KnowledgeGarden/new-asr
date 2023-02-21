/**
 * 
 */
package org.topicquests.newasr.dictionary;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IDictionary;
import org.topicquests.newasr.api.IDictionaryClient;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public class DictionaryClient implements IDictionary {
	private ASREnvironment environment;
	private IDictionaryClient dictionaryClient;
	/**
	 * 
	 */
	public DictionaryClient(ASREnvironment e) {
		environment = e;
		dictionaryClient = environment.getDictionaryClient();
	}

	@Override
	public String getTerm(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTermId(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IResult addTerm(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject getDictionary() {
		// TODO Auto-generated method stub
		return null;
	}

}
