package com.apple.query.stem;

import org.tartarus.snowball.SnowballStemmer;

public class Stemwords {
	private static String stem(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		String result = null;
		String[] inputs = input.split(" ");
		Class stemClass = Class.forName("com.apple.query.stem.englishStemmer");
		SnowballStemmer stemmer = (SnowballStemmer) stemClass.newInstance();
		for(int i =0;i<inputs.length;i++)
		{
			stemmer.setCurrent(inputs[i]);
			stemmer.stem();
//			System.out.println(stemmer.getCurrent());
			result += stemmer.getCurrent();
		}
		
		return result;
	}
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		stem("boys and girls are playing togather");
	}

}
