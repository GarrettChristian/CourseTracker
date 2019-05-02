import java.util.ArrayList;
import java.util.HashSet;

public class ZPlanner {

	private String name;
	private Semester currentSemester;
	private HashSet<Course> coursesTaken;
	private int totalCreditsNeeded;
	private CourseGraph courseGraph;

	private Course[][] year = new Course[8][5]; // 8 semesters, 5 classes each

	private HashSet<Program> programs;

	public ZPlanner() {

	}

	public ZPlanner(String studentName, Semester currentSemester, HashSet<Program> programs, int creditsToGraduate) {
		this.name = studentName;
		this.currentSemester = currentSemester;
		this.programs = programs;
		this.totalCreditsNeeded = creditsToGraduate;
		this.courseGraph = new CourseGraph();
	}

	/**
	 * Test method for inserting classes into planner
	 */
	public void doit() {
		int count = 0;
		ArrayList<Program> majors = new ArrayList<Program>();
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		ArrayList<Course> courses = new ArrayList<Course>();
		// clusters.addAll(programs);
		majors.addAll(programs);
		System.out.println("Num of majors " + majors.size());
		for (int m = 0; m < majors.size(); m++) {
			clusters = new ArrayList<Cluster>();
			clusters.addAll(majors.get(m).getClusters());
			System.out.println("Clusteres " + clusters.size());
			for (int cl = 0; cl < clusters.size(); cl++) {
				courses = new ArrayList<Course>();
				courses.addAll(clusters.get(cl).getCourses());
				System.out.println(clusters.get(cl).getName() + " (" + courses.size() + ")");
				int classesToAdd = 0;
				if (clusters.get(cl).getRule() == Rule.TAKE_ALL)
					classesToAdd = courses.size();
				if (clusters.get(cl).getRule() == Rule.TAKE_ONE)
					classesToAdd = 1;
				if (clusters.get(cl).getRule() == Rule.TAKE_TWO)
					classesToAdd = 2;
				if (clusters.get(cl).getRule() == Rule.TAKE_THREE)
					classesToAdd = 3;
				for (int co = 0; co < classesToAdd; co++) {
					System.out.print(courses.get(co).toString(false));
				}
			}

		}
		System.out.println(year.toString());
	}

}