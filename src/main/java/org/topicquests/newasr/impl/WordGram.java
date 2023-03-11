/**
 * 
 */
package org.topicquests.newasr.impl;

import org.topicquests.newasr.api.IConstants;
import org.topicquests.newasr.api.IWordGram;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

/**
 * @author jackpark
 *
 */
public class WordGram implements IWordGram {
	private JsonObject data;
	/**
	 * 
	 */
	public WordGram() {
		data = new JsonObject();
	}
	
	public WordGram(JsonObject d) {
		data = d;
	}

	@Override
	public void setId(long id) {
		data.addProperty(IConstants.ID_KEY, new Long(id));

	}

	@Override
	public long getId() {
		return data.get(IConstants.ID_KEY).getAsLong();
	}

	@Override
	public JsonObject getData() {
		return data;
	}

	@Override
	public String getWords() {
		return data.get(IConstants.WORDS_KEY).getAsString();
	}

	@Override
	public void setWords(String words) {
		data.addProperty(IConstants.WORDS_KEY, words);
	}

	@Override
	public JsonArray listInLinks() {
		JsonElement jo = data.get(IConstants.IN_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public JsonArray listOutLinks() {
		JsonElement jo = data.get(IConstants.OUT_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public void addInLink(long sentenceId, long gramId) {
		JsonArray ja = listInLinks();
		if (ja == null) {
			ja = new JsonArray();
		}
		//JsonObject jo = new JsonObject();
		//jo.addProperty(Long.toString(sentenceId), gramId);
		//ja.add(jo);
		String thelink = Long.toString(sentenceId) + ","  +Long.toString(gramId);
		data.addProperty(IConstants.IN_KEY, thelink);
	}

	@Override
	public void addOutlink(long sentenceId, long gramId) {
		JsonArray ja = listOutLinks();
		if (ja == null) {
			ja = new JsonArray();
		}
		//JsonObject jo = new JsonObject();
		//jo.addProperty(Long.toString(sentenceId), gramId);
		//ja.add(jo);
		String thelink = Long.toString(sentenceId) + ","  +Long.toString(gramId);
		data.addProperty(IConstants.OUT_KEY, thelink);
	}

	@Override
	public JsonArray listTopicLocators() {
		JsonElement jo = data.get(IConstants.LOX_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public void addTopicLosator(String locator) {
		JsonArray ja = listTopicLocators();
		if (ja == null) {
			ja = new JsonArray();
		}
		ja.add(locator);
		data.add(IConstants.LOX_KEY, ja);
	}
	@Override
	public void setTopicLocators(JsonArray locators) {
		data.add(IConstants.LOX_KEY, locators);
	}


	@Override
	public String getDBpedia() {
		JsonElement jo = data.get(IConstants.DBPED_KEY);
		if (jo == null) return null;
		return jo.getAsString();
	}

	@Override
	public void setDBpedia(String dbPediaJson) {
		data.addProperty(IConstants.DBPED_KEY, dbPediaJson);

	}

	@Override
	public String getWikidata() {
		JsonElement jo = data.get(IConstants.WIKID_KEY);
		if (jo == null) return null;
		return jo.getAsString();
	}

	@Override
	public void setWikidata(String wikidataId) {
		data.addProperty(IConstants.WIKID_KEY, wikidataId);
	}

	@Override
	public JsonArray listPOS() {
		JsonElement jo = data.get(IConstants.POS_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public void addPOS(String pos) {
		JsonArray ja = listPOS();
		if (ja == null) {
			ja = new JsonArray();
		}
		ja.add(pos);
		data.add(IConstants.POS_KEY, ja);
	}
	
	@Override
	public void setPOS(JsonArray pos) {
		data.add(IConstants.POS_KEY, pos);
	}


	@Override
	public void setInverseTerm(long inverseTermId) {
		data.addProperty(IConstants.INVERSE_KEY, inverseTermId);
	}

	@Override
	public long getInverseTerm() {
		JsonElement jo = data.get(IConstants.INVERSE_KEY);
		if (jo == null) return -1;
		return jo.getAsLong();
	}

	@Override
	public void setCannonTerm(long cannonTermId) {
		data.addProperty(IConstants.CANNON_KEY, cannonTermId);
	}

	@Override
	public long getCannonTerm() {
		JsonElement jo = data.get(IConstants.CANNON_KEY);
		if (jo == null) return -1;
		return jo.getAsLong();
	}

	@Override
	public void addSynonymTerm(long synonymTermId) {
		data.addProperty(IConstants.SYNONYM_KEY, synonymTermId);
	}

	@Override
	public JsonArray listSynonyms() {
		JsonElement jo = data.get(IConstants.SYNONYM_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public void addAntonymTerm(long antonymTermId) {
		data.addProperty(IConstants.ANTONYM_KEY, antonymTermId);
	}

	@Override
	public JsonArray listAntonyms() {
		JsonElement jo = data.get(IConstants.ANTONYM_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public boolean hasInverseTerm() {
		return (this.getInverseTerm() > -1);
	}

	@Override
	public boolean hasCannonicalTerm() {
		return (this.getCannonTerm() > -1);
	}

	@Override
	public void addExtensionProperty(String key, String value) {
		JsonElement je = data.get(IConstants.EXTENSION_KEY);
		JsonObject extendedProperties = null;
		if (je == null) {
			extendedProperties = new JsonObject();
			data.add(IConstants.EXTENSION_KEY, extendedProperties);
		}
		extendedProperties.addProperty(key, value);
	}
/*	@Override
	public void addExtensionProperty(String key, JsonObject value) {
		JsonElement je = data.get(IConstants.EXTENSION_KEY);
		JsonObject extendedProperties = null;
		if (je == null) {
			extendedProperties = new JsonObject();
			data.add(IConstants.EXTENSION_KEY, extendedProperties);
		}
		extendedProperties.add(key, value);
	}

	@Override
	public void addExtensionProperty(String key, JsonArray value) {
		JsonElement je = data.get(IConstants.EXTENSION_KEY);
		JsonObject extendedProperties = null;
		if (je == null) {
			extendedProperties = new JsonObject();
			data.add(IConstants.EXTENSION_KEY, extendedProperties);
		}
		extendedProperties.add(key, value);
	}
*/

	@Override
	public JsonElement getExtensionProperty(String key) {
		JsonElement je = data.get(IConstants.EXTENSION_KEY);
		JsonObject extendedProperties = null;
		if (je == null) 
			return null;
		else 
			extendedProperties = je.getAsJsonObject();
		return extendedProperties.get(key);
	}

	@Override
	public void setTense(String tense) {
		data.addProperty(IConstants.TENSE_KEY, tense);
	}

	@Override
	public String getTense() {
		JsonElement jo = data.get(IConstants.TENSE_KEY);
		if (jo == null) return null;
		return jo.getAsString();
	}

	@Override
	public void setEpistemicStatus(String status) {
		data.addProperty(IConstants.EPI_KEY, status);
	}

	@Override
	public String getEpistemicStatus() {
		JsonElement jo = data.get(IConstants.EPI_KEY);
		if (jo == null) return null;
		return jo.getAsString();
	}

	@Override
	public JsonObject getExtensionPropeties() {
		JsonElement extendedProperties = data.get(IConstants.EXTENSION_KEY);
		if (extendedProperties == null)
			return null;
		return extendedProperties.getAsJsonObject();
	}



}
