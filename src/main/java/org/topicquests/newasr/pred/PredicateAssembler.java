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
		JsonArray antecedents = predicates.get(_ANTECENDS).deepCopy().getAsJsonArray();
		JsonArray preds = predicates.get(_PREDICATES).deepCopy().getAsJsonArray();
		int predCount = countPredicates(preds);
		if (predCount == 1) 
			processOnePredicate(sentence, antecedents,predicates, result);
		else
			processSeveralPredicates(sentence, antecedents, predicates, result);
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
		}
	}
	void processSeveralPredicates(JsonObject sentence, JsonArray ants, JsonArray predicates, IResult result) {
		System.out.println("ProcessSeveral "+predicates);

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
		System.out.println("Counting: "+result+" "+preds);
		return result;
	}
}
