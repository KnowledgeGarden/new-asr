/**
 * 
 */
package org.topicquests.newasr.test;

import org.topicquests.newasr.pred.PredicateAssembler;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author jackpark
 *
 */
public class FirstPredicateTest extends TestingRoot {
	private PredicateAssembler handler;
	private final String
		ONE_PRED	= "[[{'strt': 2, 'enx': 6, 'txt': 'have been thought to'}], [{'strt': 6, 'enx': 7, 'txt': 'cause'}]]",
		TWO_PRED	= "[[{'strt': 5, 'enx': 6, 'txt': 'is'}], [{'strt': 1, 'enx': 2, 'txt': 'believe'}, {'strt': 6, 'enx': 7, 'txt': 'caused'}, {'strt': 6, 'enx': 8, 'txt': 'caused by'}]]";
	private JsonObject sentence;
	/**
	 * 
	 */
	public FirstPredicateTest() {
		super();
		handler = new PredicateAssembler(environment);
		sentence = new JsonObject(); // empty fornow
		JsonArray ja = (JsonArray)JsonParser.parseString(ONE_PRED);
		IResult r = handler.processSentencePredicates(sentence, ja);
		// that should print out some stuff
		ja = (JsonArray)JsonParser.parseString(TWO_PRED);
		r = handler.processSentencePredicates(sentence, ja);
		// more stuff
		environment.shutDown();
		System.exit(0);
	}
/*
Counting: 1 [{"strt":6,"enx":7,"txt":"cause"}]
ProcessOne [[{"strt":2,"enx":6,"txt":"have been thought to"}],[{"strt":6,"enx":7,"txt":"cause"}]]
Counting: 2 [{"strt":1,"enx":2,"txt":"believe"},{"strt":6,"enx":7,"txt":"caused"},{"strt":6,"enx":8,"txt":"caused by"}]
ProcessSeveral [[{"strt":5,"enx":6,"txt":"is"}],[{"strt":1,"enx":2,"txt":"believe"},{"strt":6,"enx":7,"txt":"caused"},{"strt":6,"enx":8,"txt":"caused by"}]]

 */
}
