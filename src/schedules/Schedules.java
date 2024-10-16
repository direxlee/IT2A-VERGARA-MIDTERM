package Schedules;

import java.util.Scanner;

public class Schedules {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String resp;
        do {

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            Schedule  = new Schedule();
            switch (action) {
                case 1:
                    app.addSchedule();
                    break;
                case 2:
                    app.viewSchedule();
                    break;
                case 3:
                    app.viewSchedule();
                    app.updateSchedule();
                    break;
                case 4:
                    app.viewSchedule();
                    app.deleteSchedule();
                    app.viewSchedule();
                    break;
            }

            System.out.print("Continue? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));
        System.out.println("Thank You!");
    }

    // ADD schedule
    public void addSchedule() {
        Scanner sc = new Scanner(System.in);
        Config conf = new Config();
        System.out.print("Course ID: ");
        int course_id = sc.nextInt();
        System.out.print("Instructor ID: ");
        int instructor_id = sc.nextInt();
        System.out.print("Day of Week: ");
        String day_of_week = sc.next();
        System.out.print("Start Time (HH:MM): ");
        String start_time = sc.next();
        System.out.print("End Time (HH:MM): ");
        String end_time = sc.next();

        String sql = "INSERT INTO tbl_schedule (course_id, instructor_id, day_of_week, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, course_id, instructor_id, day_of_week, start_time, end_time);
    }

    // VIEW schedule
    private void viewSchedule() {
        String qry = "SELECT * FROM tbl_schedule";
        String[] hdrs = {"ID", "Course ID", "Instructor ID", "Day", "Start Time", "End Time"};
        String[] clms = {"schedule_id", "course_id", "instructor_id", "day_of_week", "start_time", "end_time"};

        Config conf = new Config();
        conf.viewRecords(qry, hdrs, clms);
    }

    // UPDATE schedule
    private void updateSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Schedule ID to Update: ");
        int id = sc.nextInt();

        System.out.print("Enter new Course ID: ");
        int ncourse_id = sc.nextInt();
        System.out.print("Enter new Instructor ID: ");
        int ninstructor_id = sc.nextInt();
        System.out.print("Enter new Day of Week: ");
        String nday_of_week = sc.next();
        System.out.print("Enter new Start Time (HH:MM): ");
        String nstart_time = sc.next();
        System.out.print("Enter new End Time (HH:MM): ");
        String nend_time = sc.next();

        String qry = "UPDATE tbl_schedule SET course_id = ?, instructor_id = ?, day_of_week = ?, start_time = ?, end_time = ? WHERE schedule_id = ?";
        Config conf = new Config();
        conf.updateRecord(qry, ncourse_id, ninstructor_id, nday_of_week, nstart_time, nend_time, id);
    }

    // DELETE schedule
    private void deleteSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Schedule ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_schedule WHERE schedule_id = ?";
        Config conf = new Config();
        conf.deleteRecord(qry, id);
    }
}
