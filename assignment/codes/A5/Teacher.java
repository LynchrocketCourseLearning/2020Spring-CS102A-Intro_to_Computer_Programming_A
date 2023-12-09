import java.util.*;

public class Teacher extends Person implements CourseOperator {
    private Location preferLocation;

    public Location getPreferLocation() {
        return preferLocation;
    }

    public void setPreferLocation(Location preferLocation) {
        this.preferLocation = preferLocation;
    }

    public Teacher() {
        super();
    }

    public Teacher(String id, String name) {
        super(id, name);
    }

    public List<Classroom> getFreeClassroom(CourseTime time, int capacity, CourseType type) {
        boolean che = false;
        List<Classroom> freeRooms = new ArrayList<>();
        for (Building building : Db.buildings) {
            if (building.getLocation().equals(preferLocation)) {
                for (Classroom classroom : building.getRooms()) {
                    if (!classroom.getSchedule().containsKey(time)
                            & classroom.getSeatNum() >= capacity
                            & classroom.getType().equals(type)) {
                        freeRooms.add(classroom);
                        che = true;
                    }
                }
            }
        }
        if (!che) {
            for (Building building : Db.buildings) {
                for (Classroom classroom : building.getRooms()) {
                    if (!classroom.getSchedule().containsKey(time)
                            & classroom.getSeatNum() >= capacity
                            & classroom.getType().equals(type)) {
                        freeRooms.add(classroom);
                    }
                }
            }
        }
        return freeRooms;
    }

    boolean createCourse(Course course) {
        boolean result = false;
        if (!schedule.containsKey(course.getTime())
                & course.getRoom() != null
                & course.getTime() != null) {
            if (!course.getRoom().getSchedule().containsKey(course.getTime())
                    & course.getRoom().getSeatNum() >= course.getCapacity()
                    & course.getType().equals(course.getRoom().getType())) {
                schedule.put(course.getTime(), course);
                course.getRoom().getSchedule().put(course.getTime(), course);
                result = true;
            }
        }
        return result;
    }


    boolean createCourse(String code, String name, String abbrevName,
                         CourseTime time, Classroom room, int capacity, CourseType type) {
        Course course = new Course(code, name, abbrevName, this, capacity, type, time, room);
        return createCourse(course);
    }

    @Override
    public boolean dropCourse(Course course) {
        boolean result = false;
        if (schedule.containsKey(course.getTime())) {
            if (schedule.get(course.getTime()).equals(course)
                    & course.getCode().equals(schedule.get(course.getTime()).getCode())//
                    & course.getTeacher().equals(this)) {//
                schedule.remove(course.getTime(), course);
                course.getRoom().getSchedule().remove(course.getTime(), course);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean changeCourse(Course oldCourse1, Course newCourse2) {
        boolean result = false;
        if (dropCourse(oldCourse1)) {
            if (createCourse(newCourse2)) {
                result = true;
            } else {
                createCourse(oldCourse1);
                result = false;
            }
        }
        return result;
    }

    public String printCourse(Day day) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            CourseTime courseTime = new CourseTime(day, i);
            if (schedule.get(courseTime) != null) {
                result.append(String.format("%d %s, %s, %s\n",
                        i,
                        schedule.get(courseTime).getCode(),
                        schedule.get(courseTime).getAbbrevName(),
                        schedule.get(courseTime).getRoom().toString()));
            } else {
                result.append(String.format("%d \n", i));
            }
        }
        return result.toString();
    }

    public String printSchedule() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s's Schedule\n", name))
                .append("Monday\n").append(printCourse(Day.Monday))
                .append("Tuesday\n").append(printCourse(Day.Tuesday))
                .append("Wednesday\n").append(printCourse(Day.Wednesday))
                .append("Thursday\n").append(printCourse(Day.Thursday))
                .append("Friday\n").append(printCourse(Day.Friday))
                .append("Saturday\n").append(printCourse(Day.Saturday))
                .append("Sunday\n").append(printCourse(Day.Sunday));
        return sb.toString();
    }

    public int getScheduleCourseNum() {
        return schedule.values().size();
    }
}
