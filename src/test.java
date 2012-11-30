import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.VerbSynset;
import edu.smu.tspell.wordnet.WordNetDatabase;
/*
 * author:apple
 * date: 11 29th 2012
 * goal: analysis query using wordnet2.1
 * detail: find the parent /subslings /children of some word
 *         get the distance between two words */

public class test {
	
	private static void test1()
	{
		//set the dict path,get file
		System.setProperty("wordnet.database.dir","C:/Program Files (x86)/WordNet/2.1/dict");
		WordNetDatabase database = WordNetDatabase.getFileInstance();
//		suppose you want to get all the noun synsets for some word
		NounSynset nounSynset;
		NounSynset[] hyponyms;
		Synset[] synsets = database.getSynsets("fly",SynsetType.NOUN);
		for(int i=0;i<synsets.length;i++)
		{
			nounSynset = (NounSynset)(synsets[i]);
			hyponyms = nounSynset.getHyponyms();
			System.out.println(nounSynset.getWordForms()[0]+
					": "+nounSynset.getDefinition()+") has "+hyponyms.length+" hyponyms");
			
		}
	}
	
	private static void tesverb()
	{
		//set the dict path,get file
		System.setProperty("wordnet.database.dir","C:/Program Files (x86)/WordNet/2.1/dict");
		WordNetDatabase database = WordNetDatabase.getFileInstance();
//		suppose you want to get all the noun synsets for some word
		VerbSynset verbSynset;
		VerbSynset[] hyponyms;
		Synset[] synsets = database.getSynsets("fly",SynsetType.VERB);
		for(int i=0;i<synsets.length;i++)
		{
			verbSynset = (VerbSynset)(synsets[i]);
			hyponyms = verbSynset.getHypernyms();
			System.out.println(verbSynset.getWordForms()[0]+
					": "+verbSynset.getDefinition()+") has "+hyponyms.length+" hyponyms");
			
		}
	}
	
	//failed!!!!
	private static void testcompareTo(){
		System.setProperty("wordnet.database.dir","C:/Program Files (x86)/WordNet/2.1/dict");
		WordNetDatabase database = WordNetDatabase.getFileInstance();
		String str = "people";
		SynsetType people = SynsetType.NOUN;
		int i = SynsetType.NOUN.compareTo(SynsetType.ADJECTIVE);
		System.out.println(i);
		
//		System.out.println(.getCode());
		/*getCode */
		
	}
	public static void main(String args[])
	{
//		testcompareTo();
		tesverb();
	}
}
