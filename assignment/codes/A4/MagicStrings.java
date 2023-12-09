public class MagicStrings {

    private String[] ss;
    private int[] priority = new int[26];

    public void setSs(String input) {
        ss = input.split(" ");
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i].replaceAll("[^a-zA-Z]", "");
            ss[i] = s;
        }
    }

    public void setPriority(int[] priority) {
        for (int i = 0; i < priority.length; i++) {
            this.priority[i] = priority[i];
        }
    }

    public void setPriority(String priority) {
        String[] a = priority.split(" ");
        for (int i = 0; i < a.length; i++) {
            this.priority[i] = Integer.parseInt(a[i]);
        }
    }

    public void setPriority(char c, int priority) {
        if (c > 'a' & c < 'z') {
            this.priority[c - '0' - 49] = priority;
        }
        if (c > 'A' & c < 'Z') {
            this.priority[c - '0' - 17] = priority;
        }
    }

    public String[] getSs() {
        return ss;
    }

    public int[] getPriority() {
        return priority;
    }

    public MagicStrings(String s) {
        this.priority = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        setSs(s);
    }

    public MagicStrings(int[] priority, String s) {
        setPriority(priority);
        setSs(s);
    }

    public MagicStrings(String priority, String s) {
        setPriority(priority);
        setSs(s);
    }

    public int stringNum() {
        int count;
        if (ss.length == 0) {
            count = 0;
        } else {
            count = ss.length;
        }
        return count;
    }

    public int compareString(String a, String b) {
        int count = 0;
        String x = a.toLowerCase();
        String y = b.toLowerCase();
        if (!x.equals(y)) {
            for (int i = 0; i < Math.min(x.length(), y.length()); i++) {
                if (x.charAt(i) == y.charAt(i)) {
                    if (x.length() < y.length()) {
                        count = -1;
                        break;
                    } else if (x.length() > y.length()) {
                        count = 1;
                        break;
                    }
                }
                if (priority[x.charAt(i) - '0' - 49] < priority[y.charAt(i) - '0' - 49]) {
                    count = -1;
                    break;
                }
                if (priority[x.charAt(i) - '0' - 49] > priority[y.charAt(i) - '0' - 49]) {
                    count = 1;
                    break;
                }
            }
        }
        return count;
    }

    public void sortSs() {
        for (int j = 0; j < ss.length - 1; j++) {
            for (int i = 0; i < ss.length - 1; i++) {
                int count = compareString(ss[i], ss[i + 1]);
                if (count == -1) {
                    String che = ss[i + 1];
                    ss[i + 1] = ss[i];
                    ss[i] = che;
                }
            }
        }
    }

    public String getStrings() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
