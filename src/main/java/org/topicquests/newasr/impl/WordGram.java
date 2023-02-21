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
		data.addProperty(IConstants.ID_FIELD, new Long(id));

	}

	@Override
	public long getId() {
		return data.get(IConstants.ID_FIELD).getAsLong();
	}

	@Override
	public JsonObject getData() {
		return data;
	}

	@Override
	public String getWords() {
		return data.get(IConstants.WORDS_FIELD).getAsString();
	}

	@Override
	public void setWords(String words) {
		data.addProperty(IConstants.WORDS_FIELD, words);
	}

	@Override
	public JsonArray listInLinks() {
		JsonElement jo = data.get(IConstants.IN_FIELD);
		if (jo == null) return null;
		return jo.getAsJsonArray();
	}

	@Override
	public JsonArray listOutLinks() {
		JsonElement jo = data.get(IConstants.OUT_FIELD);
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
		data.add(IConstants.IN_FIELD, ja);
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
		data.add(IConstants.OUT_FIELD, ja);
	}

	@Override
	public JsonArray listTopicLocators() {
		JsonElement jo = data.get(IConstants.LOX_FIELD);
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
		data.add(IConstants.LOX_FIELD, ja);
	}

	@Override
	public JsonArray listDBpedia() {
		JsonElement jo = data.get(IConstants.DBPED_FIELD);
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
		data.add(IConstants.DBPED_FIELD, ja);

	}

	@Override
	public JsonArray listWikidata() {
		JsonElement jo = data.get(IConstants.WIKID_FIELD);
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
		data.add(IConstants.WIKID_FIELD, ja);
	}

	@Override
	public JsonArray listPOS() {
		JsonElement jo = data.get(IConstants.POS_FIELD);
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
		data.add(IConstants.POS_FIELD, ja);
	}

}
