import java.util.ArrayList;

public class RoomManager {
    private static ArrayList<Room> roomInfoLynn = new ArrayList<>();
    private static ArrayList<Room> roomInfoYidan = new ArrayList<>();
    private static ArrayList<Room> roomInfoLearningNexus = new ArrayList<>();

    public static boolean addRoom(String rid, Library location, int capacity) {
        boolean che = true;
        if (!checkRid(rid) | capacity <= 0) {
            che = false;
        }
        if (checkRid(rid) & capacity > 0) {
            Room room = new Room(rid, location, capacity);
            if (location == Library.Lynn) {
                for (Room id : roomInfoLynn) {
                    if (id.getRid().equals(rid)) {
                        che = false;
                        break;
                    }
                }
                if (che) {
                    roomInfoLynn.add(room);
                }
            }
            if (location == Library.Yidan) {
                for (Room id : roomInfoYidan) {
                    if (id.getRid().equals(rid)) {
                        che = false;
                        break;
                    }
                }
                if (che) {
                    roomInfoYidan.add(room);
                }
            }
            if (location == Library.LearningNexus) {
                for (Room id : roomInfoLearningNexus) {
                    if (id.getRid().equals(rid)) {
                        che = false;
                        break;
                    }
                }
                if (che) {
                    roomInfoLearningNexus.add(room);
                }
            }
        }
        return che;
    }

    public static boolean addRoom(String rid, Library library, int capacity, boolean hasDisplay, boolean hasWhiteboard) {
        boolean che = false;
        boolean che1 = true;
        boolean che2 = true;
        boolean che3 = true;
        if (checkRid(rid) & capacity > 0) {
            Room room = new Room(rid, library, capacity, hasDisplay, hasWhiteboard);
            if (library == Library.Lynn) {
                for (Room id : roomInfoLynn) {
                    if (id.getRid().equals(rid)) {
                        che1 = false;
                        break;
                    }
                }
                if (che1) {
                    roomInfoLynn.add(room);
                    che = true;
                }
            }
            if (library == Library.Yidan) {
                for (Room id : roomInfoYidan) {
                    if (id.getRid().equals(rid)) {
                        che2 = false;
                        break;
                    }
                }
                if (che2) {
                    roomInfoYidan.add(room);
                    che = true;
                }
            }
            if (library == Library.LearningNexus) {
                for (Room id : roomInfoLearningNexus) {
                    if (id.getRid().equals(rid)) {
                        che3 = false;
                        break;
                    }
                }
                if (che3) {
                    roomInfoLearningNexus.add(room);
                    che = true;
                }
            }
        }
        return che;
    }

    public static boolean orderRoom(Library library, String rid, String SID, int start, int end, int numberOfTeammates) {
        boolean che = false;
        boolean che1 = true;
        boolean che2 = true;
        boolean che3 = true;
        if (!checkRid(rid)) {
            che = false;
        }
        if (checkRid(rid)) {
            Room orderRoom = new Room(rid);
            if (library == Library.Lynn) {
                for (Room sid : roomInfoLynn) {
                    if (sid.checkApplicantSID(sid.getApplicants(), SID)) {
                        che1 = false;
                        break;
                    }
                }
                if (che1) {
                    for (Room sid : roomInfoLynn) {
                        if (sid.getRid().equals(rid)) {            //若列表中有rid该如何
                            che = orderRoom.setApplicant(start, end, SID, numberOfTeammates);
                        }
                    }
                }
            }
            if (library == Library.Yidan) {
                for (Room sid : roomInfoYidan) {
                    if (sid.checkApplicantSID(sid.getApplicants(), SID)) {
                        che2 = false;
                        break;
                    }
                }
                if (che2) {
                    for (Room sid : roomInfoYidan) {
                        if (sid.getRid().equals(rid)) {
                            che = orderRoom.setApplicant(start, end, SID, numberOfTeammates);
                        }
                    }
                }
            }
            if (library == Library.LearningNexus) {
                for (Room sid : roomInfoLearningNexus) {
                    if (sid.checkApplicantSID(sid.getApplicants(), SID)) {
                        che3 = false;
                        break;
                    }
                }
                if (che3) {
                    for (Room sid : roomInfoLearningNexus) {
                        if (sid.getRid().equals(rid)) {
                            che = orderRoom.setApplicant(start, end, SID, numberOfTeammates);
                        }
                    }
                }
            }
        }
        return che;
    }

    public static boolean cancelOrder(String SID) {
        boolean che = true;
        for (Room id : roomInfoLynn) {
            che = id.removeApplicant(SID);
        }
        for (Room id : roomInfoYidan) {
            che = id.removeApplicant(SID);
        }
        for (Room id : roomInfoLearningNexus) {
            che = id.removeApplicant(SID);
        }
        return che;
    }

    public static boolean cancelOrder(String SID, Library location) {
        boolean che = true;
        switch (location) {
            case Lynn:
                for (Room id : roomInfoLynn) {
                    for (String s : id.getApplicants()) {
                        if (s.equals(SID)) {
                            che = id.removeApplicant(SID);
                        } else {
                            che = false;
                        }
                    }
                }
                break;
            case Yidan:
                for (Room id : roomInfoYidan) {
                    for (String s : id.getApplicants()) {
                        if (s.equals(SID)) {
                            che = id.removeApplicant(SID);
                        } else {
                            che = false;
                        }
                    }
                }
                break;
            case LearningNexus:
                for (Room id : roomInfoLearningNexus) {
                    for (String s : id.getApplicants()) {
                        if (s.equals(SID)) {
                            che = id.removeApplicant(SID);
                        } else {
                            che = false;
                        }
                    }
                }
                break;
        }
        return che;
    }

    public static ArrayList<Room> searchRoom(Library location, int start, int end, boolean needDisplay, boolean needWhiteboard) {
        ArrayList<Room> inter = new ArrayList<>();
        boolean che1 = false;
        boolean che2 = false;
        switch (location) {
            case Lynn:
                for (Room search : roomInfoLynn) {
                    che1 = (search.isHasDisplay() == needDisplay | (search.isHasDisplay() & !needDisplay));
                    che2 = (search.isHasWhiteboard() == needWhiteboard | (search.isHasWhiteboard() & !needWhiteboard));
                    if (che1 & che2) {
                        if (search.testTime(start, end)) {
                            inter.add(search);
                        }
                    }
                }
                break;
            case Yidan:
                for (Room search : roomInfoYidan) {
                    che1 = (search.isHasDisplay() == needDisplay | (search.isHasDisplay() & !needDisplay));
                    che2 = (search.isHasWhiteboard() == needWhiteboard | (search.isHasWhiteboard() & !needWhiteboard));
                    if (che1 & che2) {
                        if (search.testTime(start, end)) {
                            inter.add(search);
                        }
                    }
                }
                break;
            case LearningNexus:
                for (Room search : roomInfoLearningNexus) {
                    che1 = (search.isHasDisplay() == needDisplay | (search.isHasDisplay() & !needDisplay));
                    che2 = (search.isHasWhiteboard() == needWhiteboard | (search.isHasWhiteboard() & !needWhiteboard));
                    if (che1 & che2) {
                        if (search.testTime(start, end)) {
                            inter.add(search);
                        }
                    }
                }
                break;
        }
        ArrayList<Room> result = sortRoom(inter);
        return result;
    }

    public static ArrayList<Room> searchRoom(int start, int end) {
        ArrayList<Room> inter = new ArrayList<>();
        for (Room search : roomInfoLynn) {
            if (search.testTime(start, end)) {
                inter.add(search);
            }
        }
        for (Room search : roomInfoYidan) {
            if (search.testTime(start, end)) {
                inter.add(search);
            }
        }
        for (Room search : roomInfoLearningNexus) {
            if (search.testTime(start, end)) {
                inter.add(search);
            }
        }
        return sortRoom(inter);
    }

    public static ArrayList<Room> searchRoom(int start, int end, Landmark landmark) {
        ArrayList<Room> inter = new ArrayList<>();
        for (Room search : roomInfoLynn) {
            if (search.testTime(start, end)) {
                inter.add(search);
            }
        }
        for (Room search : roomInfoYidan) {
            if (search.testTime(start, end)) {
                inter.add(search);
            }
        }
        for (Room search : roomInfoLearningNexus) {
            if (search.testTime(start, end)) {
                inter.add(search);
            }
        }
        return sortRoom(inter, landmark);
    }

    public static String showOrder(ArrayList<Room> list) {
        String showOrder = "No room to show.";
        StringBuilder sc = new StringBuilder();
        if (list.size() == 0){
            showOrder = "No room to show.";
        }
        if (list.size() != 0) {
            for (Room sa : list) {
                StringBuilder sb = new StringBuilder(sa.toString());
                sc.append(sb);
            }
            showOrder = sc.toString();
        }
        return showOrder;
    }


    //sort rooms by rid
    public static ArrayList<Room> sortRid(ArrayList<Room> list) {
        ArrayList<Room> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                int test1 = Integer.parseInt(list.get(j).getRid().substring(1));
                int test2 = Integer.parseInt(list.get(j + 1).getRid().substring(1));
                if (test2 < test1) {
                    Room inter = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, inter);
                }
            }
        }
        return result;
    }

    //sort rooms by location
    public static ArrayList<Room> sortRoom(ArrayList<Room> inter) {
        ArrayList<Room> result = new ArrayList<>();
        ArrayList<Room> inter1 = new ArrayList<>();
        ArrayList<Room> inter2 = new ArrayList<>();
        ArrayList<Room> inter3 = new ArrayList<>();
        for (Room sort : inter) {
            if (sort.getLocation() == Library.Yidan) {
                inter1.add(sort);
            }
        }
        for (Room sort : inter) {
            if (sort.getLocation() == Library.Lynn) {
                inter2.add(sort);
            }
        }
        for (Room sort : inter) {
            if (sort.getLocation() == Library.LearningNexus) {
                inter3.add(sort);
            }
        }
        result.addAll(sortRid(inter1));
        result.addAll(sortRid(inter2));
        result.addAll(sortRid(inter3));
        return result;
    }

    public static ArrayList<Room> sortRoom(ArrayList<Room> inter, Landmark landmark) {
        Library[] location = landmark.getPriority();
        ArrayList<Room> result = new ArrayList<>();
        ArrayList<Room> inter1 = new ArrayList<>();
        ArrayList<Room> inter2 = new ArrayList<>();
        ArrayList<Room> inter3 = new ArrayList<>();
        for (Room sort : inter) {
            if (location[0] == sort.getLocation()) {
                inter1.add(sort);
            }
        }
        for (Room sort : inter) {
            if (location[1] == sort.getLocation()) {
                inter2.add(sort);
            }
        }
        for (Room sort : inter) {
            if (location[2] == sort.getLocation()) {
                inter3.add(sort);
            }
        }
        result.addAll(sortRid(inter1));
        result.addAll(sortRid(inter2));
        result.addAll(sortRid(inter3));
        return result;
    }

    //checkers
    public static boolean checkRid(String rid) {
        if (rid.substring(1).length() == 3 & rid.charAt(0) == 'R' & Integer.parseInt(rid.substring(1)) > 100) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkTeammates(int numberOfTeammates, int capacity) {
        if (numberOfTeammates <= capacity - 1 & numberOfTeammates >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
