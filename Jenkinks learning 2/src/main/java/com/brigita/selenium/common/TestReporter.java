package com.brigita.selenium.common;

import org.testng.Assert;
import org.testng.Reporter;
/**
 * @author Mahesh
 * 
 */
    public class TestReporter {

	private static boolean printToConsole = true;
	/**
	 * No additional info printed to console
	 */
	public static final int NONE = 0;

	/**
	 * Will print some useful information to console such as URL's, parameters,
	 * and RQ/RS
	 */
	public static final int INFO = 1;

	/**
	 * Will print some low-level granular steps to console
	 */
	public static final int DEBUG = 2;
	private static ThreadLocal<Boolean> assertFailed = new ThreadLocal<Boolean>();

	private static String getTimestamp() {
		String date = SimpleDate.getTimestamp().toString().substring(11);
		return date + " :: ";
	}

	private static String trimHtml(String log) {
		return log.replaceAll("<[^>]*>", "");
	}
	
	private static String getClassPath() {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		int x = 0;
		String filename = "";
		String path = "";
		for (StackTraceElement element : elements) {
			filename = element.getClassName().toString();
			if (x == 0 || x == 1 || x == 2) {
				x++;
				continue;
			} else if (!filename.contains("java.lang.reflect") && !filename.contains("java.lang.Thread")
					&& !filename.contains("interfaces.impl.internal.ElementHandler")
					&& !filename.contains("org.testng") && !filename.contains("java.util.concurrent.ThreadPoolExecutor")) {
				path = element.getClassName() + "#" + element.getMethodName();
				break;
			}

		}
		return path;
	}

	public static void setPrintToConsole(boolean printToConsole) {
		TestReporter.printToConsole = printToConsole;
	}

	public static boolean getPrintToConsole() {
		return printToConsole;
	}

	/**
	 * Prints log into the TestNg report
	 * 
	 * @param step
	 */
	public static void logStep(String step) {
		Reporter.log(
				"<br/><b><font size = 4>-------------------------------------------------------------------------------</font></b><br/>");
		Reporter.log("<br/><b><font size = 4>Step: " + step + "</font></b>");
		Reporter.log(
				"<br/><b><font size = 4>-------------------------------------------------------------------------------</font></b><br/>");
		if (getPrintToConsole())
			System.out.println(trimHtml(step));
	}

	/**
	 * Prints log into the TestNg report
	 * 
	 * @param message
	 */
	public static void log(String message) {
		Reporter.log(getTimestamp() + getClassPath() + " > " + message.trim() + "<br />");
		if (getPrintToConsole())
			System.out.println(getTimestamp() + getClassPath() + " > " + trimHtml(message.trim()));
	}
	
	/**
	 * Prints Testmo log into the TestNg report
	 * 
	 * @param log
	 */
	public static void testmoLogstep(String log) {

		Reporter.log(log + "<span style=\"background-color: #00FF00\"> Passed</span>" + "<br>");

	}

	public static void logFailure(String message) {
		Reporter.log(getTimestamp() + getClassPath() + " > " + " <font size = 2 color=\"red\"><b><u> FAILURE: "
				+ message + "</font></u></b><br />");
		if (getPrintToConsole())
			System.out.println(getTimestamp() + getClassPath() + " > " + trimHtml(message.trim()));
	}

	public static void assertTrue(boolean condition, String description) {
		try {
			Assert.assertTrue(condition, description);
		} catch (AssertionError failure) {
			logFailure("Assert True - " + description);
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert True - " + trimHtml(description));
			Assert.fail(description);
		}
		System.out.println(getTimestamp() + "Assert True - " + trimHtml(description));
	}

	public static void assertFalse(boolean condition, String description) {
		try {
			Assert.assertFalse(condition, description);
		} catch (AssertionError failure) {
			logFailure("Assert False - " + description);
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert False - " + trimHtml(description));
			Assert.fail(description);
		}
	}

	public static void assertEquals(Object value1, Object value2, String description) {
		try {
			Assert.assertEquals(value1, value2, description);
		} catch (AssertionError failure) {
			logFailure("Assert Equals - " + description);
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert Equals - " + trimHtml(description));
			Assert.fail(description);
		}
	}

	public static void assertNotEquals(Object value1, Object value2, String description) {
		try {
			Assert.assertNotEquals(value1, value2, description);
		} catch (AssertionError failure) {
			logFailure("Assert Not Equals - " + description);
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert Not Equals - " + trimHtml(description));
			Assert.fail(description);
		}
	}

	public static void assertGreaterThanZero(int value) {
		try {
			Assert.assertTrue(value > 0);
		} catch (AssertionError failure) {
			logFailure("Assert Greater Than Zero - " + value);
			if (getPrintToConsole())
				System.out.println(
						getTimestamp() + "Assert Greater Than Zero - Assert " + value + " is greater than zero");
			Assert.fail("Assert " + value + " is greater than zero");
		}

	}

	public static void assertGreaterThanZero(float value) {
		assertGreaterThanZero((int) value);
	}

	public static void assertGreaterThanZero(double value) {
		assertGreaterThanZero((int) value);
	}

	public static void assertNull(Object condition, String description) {
		try {
			Assert.assertNull(condition, description);
		} catch (AssertionError failure) {
			logFailure("Assert Null - " + description);
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert Null - " + trimHtml(description));
			Assert.fail(description);
		}

	}

	public static void assertNotNull(Object condition, String description) {
		try {
			Assert.assertNotNull(condition, description);
		} catch (AssertionError failure) {
			logFailure("Assert Not Null - " + description);
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert Not Null - " + trimHtml(description));
			Assert.fail(description);
		}

	}

	public static boolean softAssertTrue(boolean condition, String description) {
		try {
			Assert.assertTrue(condition, description);
			Reporter.log(getTimestamp() + " <font size = 2 color=\"green\"><b><u>Assert True - " + description
					+ "</font></u></b><br />");
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert True - " + trimHtml(description));
		} catch (AssertionError failure) {
			Reporter.log(getTimestamp() + "<font size = 2 color=\"red\"><b><u>Assert True - " + description
					+ "</b></u></font><br />");
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert True - " + trimHtml(description));
			assertFailed.set(true);
			return false;
		}
		return true;
	}

	public static boolean softAssertEquals(Object value1, Object value2, String description) {

		try {
			Assert.assertEquals(value1, value2, description);
			Reporter.log(getTimestamp() + " <font size = 2 color=\"green\"><b><u>Assert Equals - " + description
					+ "</font></u></b><br />");
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert Equals - " + trimHtml(description));
		} catch (AssertionError failure) {
			Reporter.log(getTimestamp() + "<font size = 2 color=\"red\"><b><u>Assert Equals - " + description
					+ "</b></u></font><br />");
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert Equals - " + trimHtml(description));
			assertFailed.set(true);
			return false;
		}
		return true;

	}

	public static boolean softAssertFalse(boolean condition, String description) {
		try {
			Assert.assertFalse(condition, description);
			Reporter.log(getTimestamp() + " <font size = 2 color=\"green\"><b><u>Assert False - " + description
					+ "</font></u></b><br />");
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert False - " + trimHtml(description));
		} catch (AssertionError failure) {
			Reporter.log(getTimestamp() + "<font size = 2 color=\"red\"><b><u>Assert False - " + description
					+ "</b></u></font><br />");
			if (getPrintToConsole())
				System.out.println(getTimestamp() + "Assert False - " + trimHtml(description));
			assertFailed.set(true);
			return false;
		}
		return true;
	}

	public static void assertAll() {
		boolean failed = assertFailed.get() == null ? false : assertFailed.get();
		if (failed) {
			assertFailed.set(false);
			Reporter.log(getTimestamp()
					+ "<font size = 2 color=\"red\"><b>Soft assertions failed - see failures above</font></u></b><br />");
			Assert.fail("Soft assertions failed - see testNG report for details");
		}

	}
}
