
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Classroom {
    int id;//eg:101
    int seatNum;//eg:50
    CourseType type;// Lecture or Lab
    Building building;
    Map<CourseTime, Course> schedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Map<CourseTime, Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<CourseTime, Course> schedule) {
        this.schedule = schedule;
    }

    public Classroom() {
        schedule = new HashMap<>();
    }

    public Classroom(int id, int seatNum, Building building, CourseType type) {
        this.id = id;
        this.seatNum = seatNum;
        this.type = type;
        this.building = building;
        schedule = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%sR%d(%d)%s", type, id, seatNum, building.toString());
    }

    public String addCourse(Course course) {
        String result = "";
        if (schedule.containsKey(course.getTime())) {
            result = "ERROR: Another course already exists at the time.";
        } else if (!this.getType().equals(course.getType())) {
            result = "ERROR: Course type not same as classroom.";
        } else if (this.getSeatNum() < course.getCapacity()) {
            result = "ERROR: Not enough seats in the classroom for this course.";
        } else {
            result = "OK: Adding course to classroom success.";
            schedule.put(course.getTime(), course);
        }
        return result;
    }

    public boolean deleteCourse(Course course) {
        return schedule.remove(course.getTime(), course);
    }

    public Course getCourse(CourseTime courseTime) {
        return schedule.get(courseTime);
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
                        schedule.get(courseTime).getTeacher().getName()));
            } else {
                result.append(String.format("%d \n", i));
            }
        }
        return result.toString();
    }

    public String printSchedule() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString()).append(" Schedule\n")
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
