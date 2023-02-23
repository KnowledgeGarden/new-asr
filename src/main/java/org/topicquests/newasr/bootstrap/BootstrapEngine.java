/**
 * 
 */
package org.topicquests.newasr.bootstrap;

import java.io.File;

import org.topicquests.newasr.ASREnvironment;
import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;
import org.topicquests.support.util.TextFileHandler;

/**
 * @author jackpark
 * A class for importing lists of terms to grow the WordGrams
 */
public class BootstrapEngine {
	private ASREnvironment environment;
	private IAsrModel model;
	

	/**
	 * 
	 */
	public BootstrapEngine(ASREnvironment e) {
		environment = e;
		model = environment.getModel();
	}

	/**
	 * Read and process a file of terms - line by line.
	 * @param inFile
	 * @param pos  can be {@code null}
	 * @return
	 */
	public IResult importTermListFile(File inFile, String pos) {
		IResult result = new ResultPojo();
		TextFileHandler h = new TextFileHandler();
		String line = h.readFirstLine(inFile);
		while (line != null) {
			model.processTerm(line.trim(), pos);
			line = h.readNextLine();
		}
		return result;
	}
}
