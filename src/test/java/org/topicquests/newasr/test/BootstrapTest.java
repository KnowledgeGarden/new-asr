/**
 * 
 */
package org.topicquests.newasr.test;

import java.io.File;

import org.topicquests.newasr.bootstrap.BootstrapEngine;
import org.topicquests.support.util.TextFileHandler;

/**
 * @author jackpark
 *
 */
public class BootstrapTest extends TestingRoot {
	private BootstrapEngine booter;
	private final String
		PATH = "PathToTermFile"; //TODO
	/**
	 * 
	 */
	public BootstrapTest() {
		super();
		booter = environment.getBootstrapEngine();
		TextFileHandler h = new TextFileHandler();
		File f = new File(PATH);
		if (f.exists()) {
			if (PATH.endsWith(".txt")) {
				String pos = getPOS(PATH);
				booter.importTermListFile(f, pos);
			}
		}
	}
	
	String getPOS(String filePath) {
		String result = null;
		
		return result;
	}

}
