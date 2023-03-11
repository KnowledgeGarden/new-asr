/**
 * 
 */
package org.topicquests.newasr.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
/**
 * @author jackpark
 *
 */
public interface IWordGram extends IAddressable {
	JsonObject getData();
	
	String getWords();
	
	void setWords(String words);
	
	JsonArray listInLinks();
	JsonArray listOutLinks();
	
	void addInLink(long sentenceId, long gramId);
	void addOutlink(long sentenceId, long gramId);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listTopicLocators();
	
	void addTopicLosator(String locator);
	
	/**
	 * Can return {@code null}
	 * @return - list of JSON objects
	 */
	String getDBpedia();
	
	void setDBpedia(String dbPediaJson);
	
	/**
	 * Can return {@code null}
	 * @return list of wikidata identifiers
	 */
	String getWikidata();
	
	void setWikidata(String wikidataId);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listPOS();
	
	void addPOS(String pos);
	
	void setInverseTerm(long inverseTermId);
	/**
	 * Can return {@code -1} if no inverse termexists
	 * @return
	 */
	long getInverseTerm();
	
	/**
	 * Shortcut
	 * @return
	 */
	boolean hasInverseTerm();
	
	void setCannonTerm(long cannonTermId);
	/**
	 * Can return {@code -1} if no cannonical term exists
	 * @return
	 */
	long getCannonTerm();
	
	/**
	 * Shortcut
	 * @return
	 */
	boolean hasCannonicalTerm();
	
	void addSynonymTerm(long synonymTermId);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listSynonyms();
	
	void addAntonymTerm(long antonymTermId);
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonArray listAntonyms();
	
	/**
	 * Predicate tense,e.g.past
	 * @param tense
	 */
	void setTense(String tense);
	/**
	 * Can return {@code null}
	 * @return
	 */
	String getTense();
	/**
	 * Epistemic status e.g. speculative
	 * @param status
	 */
	void setEpistemicStatus(String status);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	String getEpistemicStatus();
	
	/**
	 * <p>An <em>extension property</em> is one we haven't thought of yet.</p>
	 * <p>To enable processing, the {@code key} should be distinctive, such as, e.g. {@code _myKey}</p>
	 * @param key
	 * @param value
	 */
	void addExtensionProperty(String key, String value);
	//void addExtensionProperty(String key, JsonObject value);
	//void addExtensionProperty(String key, JsonArray value);

	/**
	 * A {@link JsonElement} can be cast to many objects such as String, long, JsonArray, etc
	 * @param key
	 * @return
	 */
	JsonElement getExtensionProperty(String key);
	
	/**
	 * Can return {@code null}
	 * @return
	 */
	JsonObject getExtensionPropeties();
}
