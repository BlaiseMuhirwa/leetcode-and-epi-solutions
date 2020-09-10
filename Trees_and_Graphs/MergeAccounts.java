package Trees_and_Graphs;
import java.util.*;

public class MergeAccounts {
    Map<String, String> emailToName = new HashMap<>();
    Map<String, List<String>> graph = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> output = new ArrayList<List<String>>();
        if (accounts == null || accounts.size() == 0) return output;

        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(
                        email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(
                        account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> visitedEmails = new HashSet<>();
        for (String key : graph.keySet()) {
            if (!visitedEmails.contains(key)) {
                visitedEmails.add(key);
                List<String> current = new ArrayList<>();
                LinkedList<String> stack = new LinkedList<>();
                stack.push(key);

                while (!stack.isEmpty()) {
                    String email = stack.pop();
                    current.add(email);
                    Iterator<String> iter = graph.getOrDefault(
                            email, new ArrayList<>()).listIterator();

                    while (iter.hasNext()) {
                        String nextEmail = iter.next();
                        if (!visitedEmails.contains(nextEmail)) {
                            visitedEmails.add(nextEmail);
                            stack.push(nextEmail);
                        }
                    }
                }
                Collections.sort(current);
                current.add(0, emailToName.get(key));
                output.add(current);
            }
        }
        return output;

    }
}
