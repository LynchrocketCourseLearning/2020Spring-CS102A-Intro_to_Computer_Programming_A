import java.util.Collection;

public class Student extends Person implements CourseOperator {

    public Student() {
        super();
    }

    public Student(String id, String name) {
        super(id, name);
    }

    public boolean courseExist(String code, String name, CourseType type) {
        boolean result = false;
        Collection<Course> courseList = schedule.values();
        for (Course course : courseList) {
            if (course.getCode().equals(code)
                    & course.getName().equals(name)
                    & course.getType().equals(type)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean courseExist(Course course) {
        return courseExist(course.getCode(), course.getName(), course.getType());
    }

    public boolean chooseCourse(Course course) {
        boolean result = false;
        if (!courseExist(course) & schedule.get(course.getTime()) == null) {
            if (course.getStudents() == null) {
                schedule.put(course.getTime(), course);
                course.getStudents().add(this);
                result = true;
            }else if(course.getStudents().size() < course.getCapacity()){
                schedule.put(course.getTime(), course);
                course.getStudents().add(this);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean dropCourse(Course course) {
        boolean result = false;
        if (schedule.containsValue(course)) {
            schedule.remove(course.getTime(), course);
            course.getStudents().remove(this);
            result = true;
        }
        return result;
    }

    @Override
    public boolean changeCourse(Course oldCourse1, Course newCourse2) {
        boolean result = false;
        if (newCourse2 != null
                & newCourse2.getStudents().size() < newCourse2.getCapacity()) {
            schedule.remove(oldCourse1.getTime(), oldCourse1);
            schedule.put(newCourse2.getTime(), newCourse2);
            oldCourse1.getStudents().remove(this);
            newCourse2.getStudents().add(this);
            result = true;
        }
        return result;
    }

    public String printCourse(Day day) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            CourseTime courseTime = new CourseTime(day, i);
            if (schedule.get(courseTime) != null) {
                result.append(String.format("%d %s, %s, %s, %s\n",
                        i,
                        schedule.get(courseTime).getCode(),
                        schedule.get(courseTime).getAbbrevName(),
                        schedule.get(courseTime).getTeacher().getName(),
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