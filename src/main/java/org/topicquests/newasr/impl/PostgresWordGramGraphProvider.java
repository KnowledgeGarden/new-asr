/**
 * 
 */
package org.topicquests.newasr.impl;

import java.util.List;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrDataProvider;
import org.topicquests.newasr.api.IWordGram;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public class PostgresWordGramGraphProvider implements IAsrDataProvider {
	private ASREnvironment environment;
	private PostgresConnectionFactory dbDriver = null;

	/**
	 * 
	 */
	public PostgresWordGramGraphProvider(ASREnvironment e) {
		environment = e;
		dbDriver = environment.getDatabaseDriver();
	}

	@Override
	public IResult putNode(IWordGram node) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult getNode(long nodeId) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult addNodeProperty(long id, String key, String value) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult addNodeProperties(long id, List<JsonObject> keysVals) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult removeNodeProperty(long id, String key, String value) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

}
