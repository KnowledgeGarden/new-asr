/**
 * 
 */
package org.topicquests.newasr.bootstrap;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;
import org.topicquests.support.util.TextFileHandler;

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
		TextFileHandler h = new TextFileHandler();
		String line = h.readFirstLine(PATH);
		String [] vals;
		
		// itnore thefirst line
		//,Prediate,Tense,ActivePred,Cannon,Negation,Episataus,Comments
		String pred=null, tense=null,inverse=null, cannon=null, neg=null, epi=null;
		int len = 0;
		IResult rx;
		while ((line = h.readNextLine()) != null)  {
			if (line.trim().length() > 3)  {
				System.out.println("PRED: "+line);
				vals = line.split(",");
				len=vals.length;
				//System.out.println("SZ "+len+" "+vals[1]);
				pred = vals[1].trim();
				tense = vals[2].trim();
				if (len > 3) {
					inverse = vals[3].trim();
					if (len > 4) {
						cannon = vals[4].trim();
						if (len > 5) {
								neg = vals[5].trim();
								if (len > 6)
									epi = vals[6].trim();
						}
					}
				}
				System.out.println(pred+"|"+tense+"|"+inverse+"|"+cannon+"|"+neg+"|"+epi);
				rx = model.processPredicate(pred,tense,inverse,cannon,epi, (neg==null || neg.equalsIgnoreCase("TRUE")));
				if (rx.hasError())
					result.addErrorString(rx.getErrorString());
				pred=tense=inverse=cannon=neg=epi=null;
			}
		}
		return result;
	}
}
