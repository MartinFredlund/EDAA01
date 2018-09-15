package schedule;


import java.util.ArrayList;

public class TestScheduler {

	public static void main(String[] args) {
		Machine[] m = new Machine[3];
		for (int i = 0; i < m.length; i++) {
			m[i] = new Machine(i + 1);
		}
		
		ArrayList<Job> jobList = new ArrayList<Job>();
		String [] names = {"j4", "j2", "j5", "j6", "j3", "j7", "j1"};
		int[] times = {16, 14, 6, 5, 4, 3, 2};
		for (int i = 0; i < names.length; i++) {
			jobList.add(new Job(names[i], times[i]));
		}
		
		Scheduler s = new Scheduler(m);
		s.makeSchedule(jobList);
		s.printSchedule();
	}

}
