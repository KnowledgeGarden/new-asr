/**
 * 
 */
package org.topicquests.newasr.api;

/**
 * @author jackpark
 *
 */
public interface IConstants {
	//for Wordgrams asr-schema - fields
	public static final String
		ID_FIELD		= "id",
		KEY_FIELD		= "_key",
		VALUE_FIELD		= "_val";
	
	// standard keys
	public static final String
		LOX_KEY			= "lox", 	// locators
		IN_KEY			= "inLinks", // {sentenceId, gramId}
		OUT_KEY			= "outLinks", // {sentenceId, gramId}
		DBPED_KEY		= "dbp",	// dbpedia
		WIKID_KEY		= "wikd",	// wikidata
		POS_KEY			= "pos",	// part of speech
		WORDS_KEY		= "words",	// the text for this gram
		INVERSE_KEY		= "inverse",// inverse predicate - only for passive predicates
		CANNON_KEY		= "cannon",	// canonical NER
		SYNONMY_KEY		= "synon",	// synonyms
		ANTONYM_KEY		= "anton";	// antonyms
}
