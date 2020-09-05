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

    private static boolean canCommunicate(String person1, String person2,
                                          Map<String, Set<String>> people) {
        for (String lge : people.get(person1)) {
            if (people.get(person2).contains(lge)) return true;
        }
        return false;
    }

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
            Map<String, Set<String>> addedLanguages = new HashMap<>();
            for (String person : map.keySet()) {
                Iterator<String> neighbors = map.get(person).listIterator();
                while (neighbors.hasNext()) {
                    String next = neighbors.next();
                    if (visited.containsKey(next)) {
                        continue;
                    }
                    else {
                        if (canCommunicate(person, next, people)) {
                            continue;
                        } else {
                            if (!people.get(person).contains(language) &&
                                    !addedLanguages.getOrDefault(person, new HashSet<>()).contains(language)) {
                                Set<String> value = new HashSet<>();
                                value.add(language);
                                addedLanguages.put(person, value);
                                counts.put(language, counts.get(language) + 1);
                            }
                            if (!people.get(next).contains(language) &&
                                    !addedLanguages.getOrDefault(next, new HashSet<>()).contains(language)) {
                                Set<String> value = new HashSet<>();
                                value.add(language);
                                addedLanguages.put(next, value);
                                counts.put(language, counts.get(language) + 1);
                            }
                        }
                    }
                }
                visited.put(person, true);
            }
            addedLanguages.clear();
        }
        List<Integer> minimumLearners = new ArrayList(counts.values());
        Collections.sort(minimumLearners);
        int value = minimumLearners.get(0);
        for (String key : counts.keySet()) {
            if (counts.get(key) == value) {
                return new BestLanguageResult(key, value);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] array = new String[] {"Korean", "French", "Romanian"};
        String[] aliceLges = new String[] {"Korean", "French"};
        String[] bobLges = new String[] {"Romanian"};
        String[] chrisLges = new String[] {"Korean"};
        String[] danielleLges = new String[] {"Romanian"};

        List<String> languages = Arrays.asList(array);
        Map<String, Set<String>> people = new HashMap<>();
        people.put("Alice", new HashSet<>(Arrays.asList(aliceLges)));
        people.put("Bob", new HashSet<>(Arrays.asList(bobLges)));
        people.put("Chris", new HashSet<>(Arrays.asList(chrisLges)));
        people.put("Danielle", new HashSet<>(Arrays.asList(danielleLges)));

        List<Friendship> friends = new ArrayList<>();
        friends.add(new Friendship("Alice", "Chris"));
        friends.add(new Friendship("Chris", "Alice"));
        friends.add(new Friendship("Alice", "Bob"));
        friends.add(new Friendship("Bob", "Alice"));
        friends.add(new Friendship("Bob", "Chris"));
        friends.add(new Friendship("Chris", "Bob"));
        friends.add(new Friendship("Bob", "Danielle"));
        friends.add(new Friendship("Danielle", "Bob"));

        BestLanguageResult output = bestLanguage(languages, people, friends);
        System.out.println("Language = " + output.language + ". Number of learners = " + output.numLearners);
    }


}
