/**
 * 
 */
package org.topicquests.newasr.bootstrap;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrModel;

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

	public void bootPredicates() {
		//TODO
	}
}
