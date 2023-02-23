/**
 * 
 */
package org.topicquests.newasr.test;

import java.io.File;

import org.topicquests.newasr.api.IPOS;
import org.topicquests.newasr.bootstrap.BootstrapEngine;
import org.topicquests.support.util.TextFileHandler;

/**
 * @author jackpark
 *
 */
public class BootstrapTest extends TestingRoot {
	private BootstrapEngine booter;
	private final String
		FOLDER_PATH = "./data/en/"; 
	/**
	 * 
	 */
	public BootstrapTest() {
		super();
		System.out.println("Starting Bootstrap");
		booter = environment.getBootstrapEngine();
		TextFileHandler h = new TextFileHandler();
		File dir = new File(FOLDER_PATH);
		System.out.println("DIR: "+dir+" "+dir.exists());
		if (dir.exists()) {
			String [] fNames = dir.list();
			int len = fNames.length;
			System.out.println("LEN: "+len);
			String fpath;
			File f;
			String PATH = null;
			for (int i=0;i<len;i++) {
				PATH = fNames[i];
				System.out.println("PTH: "+FOLDER_PATH+PATH);
				if (PATH.endsWith(".txt")) {
					f = new File(FOLDER_PATH+PATH);
					System.out.println("F: "+f+" "+f.exists());
					if (f.exists()) {
						String pos = getPOS(f.getName());
						booter.importTermListFile(f, pos);
					}
				}	
			}
		}
		environment.shutDown();
		System.exit(0);
	}
	
	String getPOS(String PATH) {
		String result = null;
		if (PATH.startsWith(IPOS.ADJ_POS))
			result = IPOS.ADJ_POS;
		else if (PATH.startsWith(IPOS.ADV_POS))
			result = IPOS.ADV_POS;
		else if (PATH.startsWith(IPOS.ADVP_POS))
			result = IPOS.ADVP_POS;
		else if (PATH.startsWith(IPOS.CADVP_POS))
			result = IPOS.CADVP_POS;
		else if (PATH.startsWith(IPOS.CCONJ_POS))
			result = IPOS.CCONJ_POS;
		else if (PATH.startsWith(IPOS.CONJ_POS))
			result = IPOS.CONJ_POS;
		else if (PATH.startsWith(IPOS.DET_POS))
			result = IPOS.DET_POS;
		else if (PATH.startsWith(IPOS.NG_POS))
			result = IPOS.NG_POS;
		else if (PATH.startsWith(IPOS.NOUN_POS))
			result = IPOS.NOUN_POS;
		else if (PATH.startsWith(IPOS.PREP_POS))
			result = IPOS.PREP_POS;
		else if (PATH.startsWith(IPOS.ADP_POS))
			result = IPOS.ADP_POS;
		else if (PATH.startsWith(IPOS.SCONJ_POS))
			result = IPOS.SCONJ_POS;
		return result;
	}

}
