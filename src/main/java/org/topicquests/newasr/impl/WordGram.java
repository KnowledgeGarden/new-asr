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
		JsonObject jo = new JsonObject();
		jo.addProperty(Long.toString(sentenceId), gramId);
		ja.add(jo);
		data.add(IConstants.IN_KEY, ja);
	}

	@Override
	public void addOutlink(long sentenceId, long gramId) {
		JsonArray ja = listOutLinks();
		if (ja == null) {
			ja = new JsonArray();
		}
		JsonObject jo = new JsonObject();
		jo.addProperty(Long.toString(sentenceId), gramId);
		ja.add(jo);
		data.add(IConstants.OUT_KEY, ja);
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
	public JsonArray listDBpedia() {
		JsonElement jo = data.get(IConstants.DBPED_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public void addDBpedia(String dbPediaJson) {
		JsonArray ja = listDBpedia();
		if (ja == null) {
			ja = new JsonArray();
		}
		ja.add(dbPediaJson);
		data.add(IConstants.DBPED_KEY, ja);

	}

	@Override
	public JsonArray listWikidata() {
		JsonElement jo = data.get(IConstants.WIKID_KEY);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public void addWikidata(String wikidataId) {
		JsonArray ja = listWikidata();
		if (ja == null) {
			ja = new JsonArray();
		}
		ja.add(wikidataId);
		data.add(IConstants.WIKID_KEY, ja);
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
		JsonObject extendedProperties = data.get(IConstants.EXTENSION_KEY).getAsJsonObject();
		if (extendedProperties == null) {
			extendedProperties = new JsonObject();
			data.add(IConstants.EXTENSION_KEY, extendedProperties);
		}
		extendedProperties.addProperty(key, value);
	}
	@Override
	public void addExtensionProperty(String key, JsonObject value) {
		JsonObject extendedProperties = data.get(IConstants.EXTENSION_KEY).getAsJsonObject();
		if (extendedProperties == null) {
			extendedProperties = new JsonObject();
			data.add(IConstants.EXTENSION_KEY, extendedProperties);
		}
		extendedProperties.add(key, value);
	}

	@Override
	public void addExtensionProperty(String key, JsonArray value) {
		JsonObject extendedProperties = data.get(IConstants.EXTENSION_KEY).getAsJsonObject();
		if (extendedProperties == null) {
			extendedProperties = new JsonObject();
			data.add(IConstants.EXTENSION_KEY, extendedProperties);
		}
		extendedProperties.add(key, value);
	}

	@Override
	public JsonElement getExtensionProperty(String key) {
		JsonObject extendedProperties = data.get(IConstants.EXTENSION_KEY).getAsJsonObject();
		if (extendedProperties == null)
			return null;
		return extendedProperties.get(key);
	}


}
