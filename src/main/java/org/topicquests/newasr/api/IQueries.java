/**
 * 
 */
package org.topicquests.newasr.api;

/**
 * @author jackpark
 *
 */
public interface IQueries {

	public static final String
		GET_NODE =
			"SELECT * FROM public.properties WHERE id=?",
		PUT_PROPERTY =
			"INSERT INTO public.properties (id, _key, _val) VALUES (?, ?, ?)",
		REMOVE_PROPERTY =
			"DELETE FROM public.properties where id=? _key=? _val=?"; // TODO may need AND
}
