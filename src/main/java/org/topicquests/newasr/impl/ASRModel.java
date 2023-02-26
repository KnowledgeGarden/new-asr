/**
 * 
 */
package org.topicquests.newasr.impl;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrDataProvider;
import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.newasr.api.IDictionary;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class ASRModel implements IAsrModel {
	private ASREnvironment environment;
	private IDictionary dictionary;
	private IAsrDataProvider database;

	/**
	 * 
	 */
	public ASRModel(ASREnvironment e) {
		environment = e;
		dictionary = environment.getDictionary();
		database = environment.getDatabase();
	}

	///////////////////////////////
	// A sentence is broken into a word array, and from there, into WordGram instances
	// A sentence is passed to external agents to identify:
	//		DBpedia entries --> JSON structures for hits of entities
	//		Wikidata identifiers
	//		Eventually - if needed
	//			spaCy models for parse trees
	//	Individual WordGram sequences which are found to be noun or verb phrases are replaced
	//		with their phrase WordGram equivalent
	////////////////////////////////
	@Override
	public IResult processSentence(long sentenceId, String sentence) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	///////////////////////////////
	// A mechanism for bootstrapping the WordGram graph
	// This means we need access to the Dictionary
	///////////////////////////////
	@Override
	public IResult processTerm(String term, String pos) {
		System.out.println("ModelProcessingTerm "+term+" | "+pos);
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public IResult getTermById(String id) {
		IResult result = new ResultPojo();
		// TODO Auto-generated method stub
		return result;		
	}
}
