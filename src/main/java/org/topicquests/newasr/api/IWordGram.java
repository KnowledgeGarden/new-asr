/**
 * 
 */
package org.topicquests.newasr.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
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
	JsonArray listDBpedia();
	
	void addDBpedia(String dbPediaJson);
	
	/**
	 * Can return {@code null}
	 * @return list of wikidata identifiers
	 */
	JsonArray listWikidata();
	
	void addWikidata(String wikidataId);
	
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
}
