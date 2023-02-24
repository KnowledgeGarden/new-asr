/**
 * 
 */
package org.topicquests.newasr.impl;

import java.util.List;
import java.util.Iterator;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrDataProvider;
import org.topicquests.newasr.api.IConstants;
import org.topicquests.newasr.api.IWordGram;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonArray;
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
	    IPostgresConnection conn = null;
	    JsonObject data = node.getData();
	    long objectId=node.getId();
	    JsonArray foo =null;
	    try {
	      conn = dbDriver.getConnection();
	      String key;
	      Iterator<String> itr = data.keySet().iterator();
	      while (itr.hasNext()) {
	    	  key = itr.next();
	    	  // which key is important -we already have the id key's value
	    	  if (key.equals(IConstants.LOX_KEY)) {
	    		  putStringArray(objectId, IConstants.LOX_KEY, node.listTopicLocators(), conn, result);
	    	  } else if (key.equals(IConstants.IN_KEY)) {
	    		  putStringArray(objectId, IConstants.IN_KEY, node.listInLinks(), conn, result);
	    	  } else if (key.equals(IConstants.OUT_KEY)) {
	    		  putStringArray(objectId, IConstants.OUT_KEY, node.listOutLinks(), conn, result);
	    	  } else if (key.equals(IConstants.DBPED_KEY)) {
	    		  putStringArray(objectId, IConstants.DBPED_KEY, node.listDBpedia(), conn, result);
	    	  } else if (key.equals(IConstants.WIKID_KEY)) {
	    		  putStringArray(objectId, IConstants.WIKID_KEY, node.listWikidata(), conn, result);
	    	  } else if (key.equals(IConstants.POS_KEY)) {
	    		  putStringArray(objectId, IConstants.POS_KEY, node.listPOS(), conn, result);
	    	  } else if (key.equals(IConstants.WORDS_KEY)) {
	    		  putProperty(objectId, IConstants.WORDS_KEY, node.getWords(), conn, result);
	    	  } else if (key.equals(IConstants.INVERSE_KEY)) {
	    		  putLongProperty(objectId, IConstants.INVERSE_KEY, node.getInverseTerm(), conn, result);
	    	  } else if (key.equals(IConstants.CANNON_KEY)) {
	    		  putLongProperty(objectId, IConstants.CANNON_KEY, node.getCannonTerm(), conn, result);
	    	  } else if (key.equals(IConstants.SYNONYM_KEY)) {
    		  putStringArray(objectId, IConstants.SYNONYM_KEY, node.listSynonyms(), conn, result);
	    	  } else if (key.equals(IConstants.ANTONYM_KEY)) {
	    		  putStringArray(objectId, IConstants.ANTONYM_KEY, node.listAntonyms(), conn, result);
	    	  }	    	  
 	      }
	    } catch (Exception e) {
	      result.addErrorString("PDD-4 "+objectId+" "+e.getMessage());
	      environment.logError("PDD-5 "+objectId+" "+result.getErrorString(), null);
	    }
	    conn.closeConnection(result);
		return result;
	}
	private void putLongProperty(long id, String key, long value, IPostgresConnection conn, IResult r) {
		if (value == -1) return;
		//TODO
	}

	private void putProperty(long id, String key, String value, IPostgresConnection conn, IResult r) {
		if (value == null) return;
		//TODO
	}
	private void putStringArray(long id, String key, JsonArray vals, IPostgresConnection conn, IResult r) {
		if (vals == null) return;
		
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
