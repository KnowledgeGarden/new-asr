/**
 * 
 */
package org.topicquests.newasr;

import org.topicquests.newasr.api.IAsrModel;
import org.topicquests.newasr.impl.ASRModel;
import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class ASREnvironment extends RootEnvironment {
	private PostgresConnectionFactory dbDriver = null;
	private IAsrModel model;
	/**
	 * 
	 */
	public ASREnvironment() {
		super("asr-config.xml", "logger.properties");
		String schemaName = getStringProperty("DatabaseSchema");
		String dbName = getStringProperty("DatabaseName");
		dbDriver = new PostgresConnectionFactory(dbName, schemaName);
		model = new ASRModel(this);
	}

	public IAsrModel getModel() {
		return model;
	}
	public PostgresConnectionFactory getDatabaseDriver() {
		return dbDriver;
	}
	
	@Override
	public void shutDown() {
		System.out.println("Shutting down");

	}

}
