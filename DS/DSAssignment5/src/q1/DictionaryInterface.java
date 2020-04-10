package q1;

import java.util.List;

public interface DictionaryInterface 
{
	 void addElementToDictionary(Element element) throws Exception;
	 
	 String getValueOfKey(String key) throws Exception;
	 
	 List<Element> sortKeyValuePairs();
	 
	 void show() throws Exception;
	 void deleteElementFromDictionary(String key) throws Exception;
	 List<Element> sortKeyValuePairsOnCondition(String firstKey,String secondKey) throws Exception;

}
