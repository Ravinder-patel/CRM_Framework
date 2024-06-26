package com.comcast.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplimentation implements IRetryAnalyzer {

	int count = 0;
	int limit = 5;

	@Override
	public boolean retry(ITestResult result) {
		result.getMethod().getMethodName();
		if (count < limit) {
			count++;
			return true;
		}

		return false;
	}

}
