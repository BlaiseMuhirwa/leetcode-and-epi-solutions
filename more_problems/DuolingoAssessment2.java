package more_problems;

import java.util.*;

/**
 Simple two-tuple class representing that "person1" and "person2"
 are friends.
 */
class Friendship {
    public String person1;
    public String person2;

    public Friendship(String person1, String person2) {
        this.person1 = person1;
        this.person2 = person2;
    }
}

/**
 Wrapper class for the results that bestLanguage is expected to return.
 */
class BestLanguageResult {
    public String language;
    public int numLearners;

    public BestLanguageResult(String language, int numLearners) {
        this.language = language;
        this.numLearners = numLearners;
    }
}


public class DuolingoAssessment2 {

    /**
     * Complete the 'bestLanguage' function below.
     *
     * @param languages A list of the languages to consider
     * @param people    A mapping from the names of people to the set of languages they speak
     * @param friends   A list of Friendship objects that represent that each represent
     *                  that the two named individuals are friends.
     * @return A BestLanguageResult object containing the best language and the number
     * of individuals that have to learn that language.
     */
    public static BestLanguageResult bestLanguage(List<String> languages,
                                                  Map<String, Set<String>> people,
                                                  List<Friendship> friends) {
        Map<String, List<String>> map = new HashMap<>();
        Iterator<Friendship> iter = friends.listIterator();
        while (iter.hasNext()) {
            Friendship fp = iter.next();
            String first = fp.person1;
            String second = fp.person2;
            List<String> values = map.getOrDefault(first, new ArrayList<>());
            values.add(second);
            map.put(first, values);
        }
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        Iterator<String> iterator = languages.listIterator();

        while (iterator.hasNext()) {
            String language = iterator.next();
            counts.put(language, 0);
            for (String person : map.keySet()) {
                visited.put(person, true);
                Iterator<String> neighbors = map.get(person).listIterator();
                while (neighbors.hasNext()) {

                }


                /*
                if (!visited.get(person)) {
                    visited.put(person, true);
                    Iterator<String> neighbors = map.get(person).listIterator();
                    while (neighbors.hasNext()) {
                        String next = neighbors.next();
                        if (people.get(person).contains(language)) {

                        } else if (!canCommunicate(person, next, people)) {
                            counts.put(language, counts.get(language) + 2);
                        }
                    }

                }
                */
            }

        }
        return new BestLanguageResult(languages.get(0), 1);
    }

    private static boolean canCommunicate(String person1, String person2,
                                          Map<String, Set<String>> people) {
        for (String lge : people.get(person1)) {
            if (people.get(person2).contains(lge)) return true;
        }
        return false;
    }

}
