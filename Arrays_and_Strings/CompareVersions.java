package Arrays_and_Strings;

/**
 * Given two version numbers, version1 and version2, compare them.
 *
 * Version numbers consist of one or more revisions joined by a dot '.'.
 * Each revision consists of digits and may contain leading zeros.
 * Every revision contains at least one character. Revisions are 0-indexed from
 * left to right, with the leftmost revision being revision 0, the next revision
 * being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order.
 * Revisions are compared using their integer value ignoring any leading zeros.
 * This means that revisions 1 and 001 are considered equal. If a version number
 * does not specify a revision at an index, then treat the revision as 0.
 * For example, version 1.0 is less than version 1.1 because their revision
 * 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 */
public class CompareVersions {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
    }

    public static int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) return 0;
        if (version1.length() == 0 && version2.length() == 0) return 0;

        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");

        int len1 = v1.length;
        int len2 = v2.length;
        if (len1 <= len2) {
            for (int i = 0; i < len1; i++) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            }
            for (int i = len1; i < len2; i++) {
                if (Integer.parseInt(v2[i]) > 0) return -1;
            }
            return 0;
        }
        for (int i = 0; i < len2; i++) {
            if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            }
        }
        for (int i = len2; i < len1; i++) {
            if (Integer.parseInt(v1[i]) > 0) return 1;
        }
        return 0;
    }
}
