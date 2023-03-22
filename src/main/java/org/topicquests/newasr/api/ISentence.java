/**
 * 
 */
package org.topicquests.newasr.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public interface ISentence extends IAddressable {

	JsonObject getData();
	
	void setText(String text);
	String getText();
	
	void setPredicatePhrases(JsonArray preds);
	
	/**
	 * Might return {@code null}
	 * @return
	 */
	JsonArray getPredicatePhrases();
}
