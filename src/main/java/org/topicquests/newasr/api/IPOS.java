/**
 * 
 */
package org.topicquests.newasr.api;

/**
 * @author jackpark
 * @see https://universaldependencies.org/u/pos/all.html
 * Important @see https://spacy.io/usage/linguistic-features
 */
public interface IPOS {

	public static final String
		ADJ_POS		= "adj",
		ADV_POS		= "adv",
		ADVP_POS	= "advp",
		CADVP_POS	= "cadvp",
		CCONJ_POS	= "cconj",
		CONJ_POS	= "conj",
		DET_POS		= "det",
		NG_POS		= "gernd", 	// gerund can be noun or verb THIS DOES NOT MATCH a bootstrap file path name
		NOUN_POS	= "noun",
		PREP_POS	= "prp",  	// preposition --> adb is cover for preposition and postposition terms
		ADP_POS		= "adp",
		SCONJ_POS	= "sconj";
	//TODO this is far from complete and possibly wrong
		
		
}
