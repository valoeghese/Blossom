package blossomtest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ManualJUnitLauncher {
	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(BlossomTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.getDescription());
		}

		System.out.println(result.wasSuccessful() ? "Test successful!" : "Test failed!");
	}
}
