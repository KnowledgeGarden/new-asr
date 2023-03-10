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
		ID_KEY			= "id",
		LOX_KEY			= "lox", 	// locators
		IN_KEY			= "inLinks", // {sentenceId, gramId}
		OUT_KEY			= "outLinks", // {sentenceId, gramId}
		DBPED_KEY		= "dbp",	// dbpedia
		WIKID_KEY		= "wikd",	// wikidata
		TENSE_KEY		= "tense",  // predicate tense,e.g.past,present,
		EPI_KEY		= "epi",	// epistemic status,e.g. speculative,can be null
		POS_KEY			= "pos",	// part of speech
		WORDS_KEY		= "words",	// the text for this gram
		INVERSE_KEY		= "inverse",// inverse predicate - only for passive predicates
		CANNON_KEY		= "cannon",	// canonical NER
		SYNONYM_KEY		= "synon",	// synonyms
		ANTONYM_KEY		= "anton",	// antonyms
		EXTENSION_KEY	= "extns";	// for extension properties
}
