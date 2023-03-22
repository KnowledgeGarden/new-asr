/**
 * 
 */
package org.topicquests.newasr.pred;

import java.util.Iterator;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * @author jackpark
 *
 */
public class PredicateAssembler {
	private ASREnvironment environment;
	private IAsrModel model;

	private final int _ANTECENDS = 0, _PREDICATES = 1;
	private final String
		START_FIELD		= "strt",
		END_FIELD		= "enx",
		TEXT_FIELD		= "txt";
	/**
	 * 
	 */
	public PredicateAssembler(ASREnvironment e) {
		environment = e;
		model = environment.getModel();
	}

	/******************************
		Sentence: Scientists believe that climate change is caused by  carbon dioxide
		Predicates:
			[
				[{
					'strt': 5,
					'enx': 6,
					'txt': 'is'
				}],
				[{
					'strt': 1,
					'enx': 2,
					'txt': 'believe'
				}, {
					'strt': 6,
					'enx': 7,
					'txt': 'caused'
				}, {
					'strt': 6,
					'enx': 8,
					'txt': 'caused by'
				}]
			]
		Sentence: Scientists believe  that co2 causes climate change
		[
			[],
			[{
				'strt': 1,
				'enx': 2,
				'txt': 'believe'
			}, {
				'strt': 5,
				'enx': 6,
				'txt': 'causes'
			}]
		]
		Sentence: Greenhouse gasses have been thought to cause climate change
		[
			[{
				'strt': 2,
				'enx': 6,
				'txt': 'have been thought to'
			}],
			[{
				'strt': 6,
				'enx': 7,
				'txt': 'cause'
			}]
		]
		Sentence: Climate change has been thought to have been caused by greenhouse gasses
		[
			[{
				'strt': 2,
				'enx': 6,
				'txt': 'has been thought to'
			}, {
				'strt': 2,
				'enx': 8,
				'txt': 'has been thought to have been'
			}],
			[{
				'strt': 8,
				'enx': 9,
				'txt': 'caused'
			}, {
				'strt': 8,
				'enx': 10,
				'txt': 'caused by'
			}]
]
	 ******************************/ 
	/*
	 * 
	 * @param sentence
	 * @param predicates
	 * @return
	 */
	public IResult processSentencePredicates(JsonObject sentence, JsonArray predicates) {
		IResult result = new ResultPojo();
		JsonArray antecedents = predicates.get(_ANTECENDS).getAsJsonArray();
		System.out.println("ANTS: "+antecedents);
		JsonArray preds = predicates.get(_PREDICATES).getAsJsonArray();
		System.out.println("PREDS: "+preds);
		int predCount = countPredicates(preds);
		if (predCount == 1) 
			processOnePredicate(sentence, antecedents,preds, result);
		else
			processSeveralPredicates(sentence, antecedents, preds, predCount, result);
		return result;
	}
	
	void processOnePredicate(JsonObject sentence, JsonArray ants, JsonArray predicate, IResult result) {
		System.out.println("ProcessOne "+predicate);
		int plen = predicate.size();
		int alen = ants.size();
		JsonObject je;
		String thePred = "";
		String temp;
		for (int i=0;i<plen;i++) {
			je = predicate.get(i).getAsJsonObject();
			temp =je.get(TEXT_FIELD).getAsString();
			//System.out.println("FOO: "+temp.length()+" "+temp);
			if (temp.length() > thePred.length())
				thePred = temp;
			//System.out.println("BAR: "+temp);

		}
		String theAnt = "";
		for (int i=0;i<alen;i++) {
			je = ants.get(i).getAsJsonObject();
			temp =je.get(TEXT_FIELD).getAsString();
			if (temp.length() > theAnt.length())
				theAnt = temp;
		}
		String predPhrase = theAnt+" "+thePred.trim();
		System.out.println("P1: "+predPhrase);
	}
	
	void processSeveralPredicates(JsonObject sentence, JsonArray ants, JsonArray predicates, int predicateCount, IResult result) {
		System.out.println("ProcessSeveral "+predicates);
		// Results go here
		// They are to be JsonObjects with start location and predicate phrase txt
		JsonArray results = new JsonArray();
		JsonObject workingObject;
		JsonArray antCluster = new JsonArray();
		JsonArray predCluster = new JsonArray();
		JsonArray tempCluster = null;
		JsonObject je;
		int startField= 0;
		int temp;
		// Predicates first
		for (int i=0;i<predicateCount;i++) {
			je = predicates.get(i).getAsJsonObject();
			temp = je.get(START_FIELD).getAsJsonPrimitive().getAsInt();
			if (i == 0)  {
				tempCluster = new JsonArray();
				tempCluster.add(je);
				startField = temp;
			} else if (temp == startField) {
				tempCluster.add(je);
			} else {
				predCluster.add(tempCluster);
				tempCluster = new JsonArray();
				tempCluster.add(je);
				startField = temp;
			}
		}
		int antCount = countAntecedents(ants);
		// wonder if they are the same
		System.out.println("Ants-Preds "+antCount+" "+predicateCount);
		for (int i=0;i<antCount;i++) {
			je = ants.get(i).getAsJsonObject();
			temp = je.get(START_FIELD).getAsJsonPrimitive().getAsInt();
			if (i == 0)  {
				tempCluster = new JsonArray();
				tempCluster.add(je);
				startField = temp;
			} else if (temp == startField) {
				tempCluster.add(je);
			} else {
				antCluster.add(tempCluster);
				tempCluster = new JsonArray();
				tempCluster.add(je);
				startField = temp;
			}
		}
		System.out.println("PS\n"+antCluster+"\n"+predCluster);
	}
	int countPredicates(JsonArray preds) {
		int result = 0;
		int len = preds.size();
		JsonObject je;
		int startField= 0;
		int temp;
		for (int i=0;i<len;i++) {
			je = preds.get(i).getAsJsonObject();
			temp = je.get(START_FIELD).getAsJsonPrimitive().getAsInt();
			if (temp > startField) {
				//if (startField > 0)
					result++;
				startField = temp;
			}
		}
		System.out.println("CountingP: "+result+" "+preds);
		return result;
	}
	int countAntecedents(JsonArray preds) {
		int result = 0;
		int len = preds.size();
		JsonObject je;
		int startField= 0;
		int temp;
		for (int i=0;i<len;i++) {
			je = preds.get(i).getAsJsonObject();
			temp = je.get(START_FIELD).getAsJsonPrimitive().getAsInt();
			if (temp > startField) {
				//if (startField > 0)
					result++;
				startField = temp;
			}
		}
		System.out.println("CountingA: "+result+" "+preds);
		return result;
	}

}
