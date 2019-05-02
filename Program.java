import java.util.ArrayList;
import java.util.HashSet;

public class Program {
	private HashSet<Cluster> clusters;
	private String name;

	public Program(String name, HashSet<Cluster> clusters) {
		this.name = name;
		this.clusters = clusters;
	}

	public String toString() {
		return toString(true);
	}

	public String toString(boolean verbose) {
		String s = "Program: " + this.name + "\n";

		for (Cluster c : clusters) {
			s += c.toString(verbose) + "\n";
		}
		return s;
	}

	public HashSet<Cluster> getClusters() {
		return this.clusters;
	}

	public String export() {
		String text = "[PROGRAM]\n";

		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		clusters.addAll(this.clusters);
		for (int i = 0; i < clusters.size(); i++) {
			text += "[CLUSTER]";
			text += clusters.get(i).getName() +","+ clusters.get(i).getRule() + "\n";

			ArrayList<Course> courses = new ArrayList<Course>();
			courses.addAll(clusters.get(i).getCourses());
			for (int co = 0; co < courses.size(); co++) {
				text += "[COURSE]";
				text += courses.get(co).toString(true);

			}

		}
		return text;
	}
}