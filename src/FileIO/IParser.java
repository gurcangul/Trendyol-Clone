package FileIO;

import java.util.List;

import User.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
  

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public interface IParser {
    List<User> parseUsers();
    Map parseProductAndCategory() throws FileNotFoundException, IOException, ParseException;

}
