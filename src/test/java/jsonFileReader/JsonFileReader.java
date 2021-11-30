package jsonFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



public class JsonFileReader {
	public static String reader(String objname, String key) throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		
		String filepath=System.getProperty("user.dir")+File.separator+"JsonResouce"+File.separator+"data.json";
		JsonElement jsonelement=(new JsonParser()).parse(new FileReader(filepath));// It converts json file to the json element so that we can read it by creating json object
		JsonObject obj=jsonelement.getAsJsonObject();// converted to json object
		JsonElement ele=obj.get(objname);//earlier we converted whole json file into object now we are converting its element into json obj OR whatever is inside getuser it is jsonelement
		JsonObject eleObj=ele.getAsJsonObject();
		HashMap<String,String> map=new HashMap<String,String>();
		Iterator itr=eleObj.entrySet().iterator();// converted to entry set and now it will iterate through entryset
		while(itr.hasNext())
		{
			Entry ent=(Entry) itr.next(); // here data type was set converted to entry
			map.put(ent.getKey().toString(), ent.getValue().toString());
		}
		return map.get(key);
		
		
	}

}
