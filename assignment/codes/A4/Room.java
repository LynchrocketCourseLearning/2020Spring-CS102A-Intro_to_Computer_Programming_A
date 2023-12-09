public class Room {
    public String getRid() {
        return rid;
    }

    public String[] getApplicants() {
        return applicants;
    }

    public boolean isHasDisplay() {
        return hasDisplay;
    }

    public boolean isHasWhiteboard() {
        return hasWhiteboard;
    }

    public Library getLocation() {
        return location;
    }

    private String rid = "R101";
    private Library location = Library.Lynn;
    private int capacity = 3;
    private boolean hasDisplay = true;
    private boolean hasWhiteboard = true;
    private String[] applicants = new String[]{"null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"};
    private String[] timetable = new String[]{"08:00   ", "09:00   ", "10:00   ", "11:00   ", "12:00   ", "13:00   ", "14:00   ", "15:00   ", "16:00   ", "17:00   ", "18:00   ", "19:00   ", "20:00   ", "21:00   "};

    public Room(String rid) {
        int test = Integer.parseInt(rid.substring(1));
        if (rid.substring(1).length() == 3 & test > 100 & rid.charAt(0) == 'R') {
            this.rid = rid;
        }
    }

    public Room(String rid, Library location, int capacity) {
        int test = Integer.parseInt(rid.substring(1));
        if (rid.substring(1).length() == 3 & test > 100 & rid.charAt(0) == 'R') {
            this.rid = rid;
            this.location = location;
            this.capacity = capacity;
        }
    }

    public Room(String rid, Library location, int capacity, boolean hasDisplay, boolean hasWhiteboard) {
        int test = Integer.parseInt(rid.substring(1));
        if (rid.substring(1).length() == 3 & test > 100 & rid.charAt(0) == 'R') {
            this.rid = rid;
            this.location = location;
            this.capacity = capacity;
            this.hasDisplay = hasDisplay;
            this.hasWhiteboard = hasWhiteboard;
        }
    }

    public String toString() {
        StringBuilder inter1 = new StringBuilder("|");
        StringBuilder inter2 = new StringBuilder();
        for (String t : timetable) {
            inter1.append(t).append("|");
        }
        for (int i = 0; i < applicants.length; i++) {
            if (applicants[i].equals("null")) {
                applicants[i] = "EMPTY   ";
            }
            if (applicants[i].equals("        ")) {
                inter2.append(" ").append(applicants[i]);
            } else {
                inter2.append("|").append(applicants[i]);
            }
        }
        String s1 = inter1.toString();
        String s2 = inter2.append("|").toString();
        String roomInformation = String.format("%s %s, capacity=%s, hasDisplay=%s, hasWhiteboard=%s",
                location,
                rid,
                capacity,
                hasDisplay,
                hasWhiteboard
        );
        String result = String.format("%s\n%s\n%s\n",
                roomInformation,
                s1,
                s2
        );
        return result;
    }

    public String toString(int start, int end) {
        String result = "null";
        if (start > end) {
            return null;
        } else if (start < end) {
            StringBuilder inter1 = new StringBuilder("|");
            StringBuilder inter2 = new StringBuilder();
            for (int i = start - 8; i < end - 8; i++) {
                inter1.append(timetable[i]).append("|");
            }
            for (int i = start - 8; i < end - 8; i++) {
                if (applicants[i].equals("null")) {
                    applicants[i] = "EMPTY";
                }
                if (applicants[i].equals("        ")) {
                    inter2.append(" ").append(applicants[i]);
                } else {
                    inter2.append("|").append(applicants[i]);
                }

            }
            String s1 = inter1.toString();
            String s2 = inter2.append("|").toString();
            String roomInformation = String.format("%s %s, capacity=%s, hasDisplay=%s, hasWhiteboard=%s",
                    location,
                    rid,
                    capacity,
                    hasDisplay,
                    hasWhiteboard
            );
            result = String.format("%s\n%s\n%s\n",
                    roomInformation,
                    s1,
                    s2
            );
        }
        return result;
    }

    public boolean setApplicant(int start, int end, String SID, int numberOfTeammates) {
        boolean result = false;
        int di = end - start;
        if (!checkTeammates(numberOfTeammates, capacity) | hasOrdered(SID)) {
            result = false;
        } else if (start >= 8 & end <= 22 & di >= 1 & di <= 2) {
            if (applicants[start - 8].equals("null")) {
                result = true;
            }
        }
        if (result) {
            if (di == 1) {
                applicants[start - 8] = SID;
                result = true;
            }
            if (di == 2) {
                if (applicants[start - 7].equals("null")) {
                    applicants[start - 7] = "        ";
                    applicants[start - 8] = SID;
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean removeApplicant(String SID) {
        boolean result = false;
        for (int i = 0; i < applicants.length; i++) {
            if (applicants[i].equals(SID)) {
                applicants[i] = "null";
                if (i + 1 < applicants.length) {
                    if (applicants[i + 1].equals("        ")) {
                        applicants[i + 1] = "EMPTY   ";
                    }
                }
                result = true;
            }
        }
        return result;
    }

    public boolean hasOrdered(String SID) {
        boolean che = false;
        for (String s : applicants) {
            if (s.equals(SID)) {
                che = true;
                break;
            }
        }
        return che;
    }

    //to test if there is a suited time
    public boolean testTime(int start, int end) {
        boolean result = false;
        for (int i = start - 8; i < end - 8; i++) {
            if (applicants[i].equals("null")) {
                result = true;
            }
        }
        return result;
    }

    //check SID in applicant
    public boolean checkApplicantSID(String[] applicants, String SID) {
        boolean che = false;
        for (String s : applicants) {
            if (s.equals(SID)) {
                che = true;
                break;
            }
        }
        return che;
    }

    //checkers
    public boolean checkRid(String rid) {
        int test = Integer.parseInt(rid.substring(1));
        if (rid.substring(1).length() == 3 & test > 100 & rid.charAt(0) == 'R') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkTeammates(int numberOfTeammates, int capacity) {
        if (numberOfTeammates <= capacity - 1 & numberOfTeammates >= 0) {
            return true;
        } else {
            return false;
        }
    }


}



