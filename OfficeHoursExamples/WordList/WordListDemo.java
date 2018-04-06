import edu.odu.cs.extract.wordlists.WordLists;

class WordListDemo 
{
    public static void main(String[] args)
    {               
        Iterator<String> wordIt = WordLists.stopList();
        //Iterator<String> wordIt = WordLists.englishDictionary();

        List<String> myWords = new ArrayList<String>;

        while (wordIt.hasNext()) {
            String nextWord = wordIt.next();

            myWords.add(nextWord);
        }

        // Other stuff

    }
}