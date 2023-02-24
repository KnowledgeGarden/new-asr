/**
 * 
 */
package org.topicquests.newasr.api;

import java.util.List;

import org.topicquests.support.api.IResult;

import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public interface IAsrDataProvider {

	/**
	 * Insert an {@link IWordGram} into the database
	 * @param node
	 * @return
	 */
	IResult putNode(IWordGram node);

	/**
	 * Return an {@link IWordGram} or {@code null}
	 * @param nodeId
	 * @return
	 */
	IResult getNode(long nodeId);
	
	IResult addNodeProperty(long id, String key, String value);
	
	/**
	 * Insert a collection of key/value pairs against a single nodeID
	 * @param id
	 * @param keysVals
	 * @return
	 */
	IResult addNodeProperties(long id, List<JsonObject> keysVals);
	
	IResult removeNodeProperty(long id, String key, String value);
	

}
