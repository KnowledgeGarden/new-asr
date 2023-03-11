/**
 * 
 */
package org.topicquests.newasr.bootstrap;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 *
 */
public class PredicateImporter {
	private ASREnvironment environment;
	private IAsrModel model;
	private final String PATH;
	/**
	 * 
	 */
	public PredicateImporter(ASREnvironment e) {
		environment = e;
		model = environment.getModel();
		PATH = environment.getStringProperty("PredCSV");
	}

	public IResult bootPredicates() {
		IResult result = new ResultPojo();
		//TODO
		return result;
	}
}
