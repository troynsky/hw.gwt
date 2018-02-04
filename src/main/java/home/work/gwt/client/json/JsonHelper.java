package home.work.gwt.client.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import home.work.gwt.common.model.User;

public class JsonHelper {

	@SuppressWarnings("unchecked")
	public static List<User> parseDataList(String json) {
		List<User> userList = new ArrayList<>();
		JSONValue jsonVal = JSONParser.parseStrict(json);
		JSONArray object = jsonVal.isArray();
		JsArray<JsUser> array = (JsArray<JsUser>) object.getJavaScriptObject();
		if (array != null) {
			for (int i = 0; i < array.length(); i++) {
				JsUser jsUser = array.get(i);
				String title = jsUser.name();
				userList.add(new User());
			}
		}
		return userList;
	}
}
