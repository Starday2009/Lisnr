package Lisnr.Project.configs;

import Lisnr.Project.utility.ApplicationManager;
import io.qameta.allure.Attachment;
import org.testng.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.testng.ITestResult.FAILURE;
import static org.testng.ITestResult.SUCCESS;

public class TestListener implements ITestListener {
    private Date startTime = null;
    private ApplicationManager lisnr = null;
    String filePath = "target/screenshotsFolder";

    @Override
    public void onTestStart(ITestResult result) {
        lisnr = (ApplicationManager) result.getTestContext().getAttribute("lisnr");
        LisLogger.getInstance().loggerPrint("On method " + getTestMethodName(result) + " start");
        startTime = returnDate();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LisLogger.getInstance().loggerPrint("On method " + getTestMethodName(result) + " success");
        generateReportFile(result);
    }

    public static String splitLine(String args) {
        String sentence = args;

        if (sentence.contains(", ")) {
            sentence = sentence.substring(0, sentence.indexOf(", "));
            System.out.println(sentence);
        }

        return sentence;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LisLogger.getInstance().loggerPrint("On method " + getTestMethodName(result) + " failure " );
//        generateReportFile(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext result) {}

    @Override
    public void onFinish(ITestContext result) {}

    String res = "";
    Boolean passed = false;
    String testFold = "";

    private void generateReportFile(ITestResult result) {
        res = printInfoStatus(result);
        passed = res.equals("passed") ? true : false;
        String mark = res.equals("passed") ? "/" : "/";
//        String absPath = lisnr.properties.getProperty("absolutePath");
//        String suit = String.format("/%s", lisnr.properties.getProperty("suit"));
//        testFold = absPath + suit + mark + lisnr.properties.getProperty("nameTestL");
//        LisLogger.getInstance().loggerPrint("Total time: " + howLong(startTime, returnDate()));
//        String logText = saveLogsDataToFile(LisLogger.getInstance().getLog(), result);
//        try {
//            if (!passed || passed) {
//                lisnr.createFolder(testFold);
//                z_xWriteToFile(testFold + lisnr.properties.getProperty("lastLog"), logText);
//            }
//        } catch (Exception e) {
//            System.out.println(
//                    "can not create folder: " + lisnr.properties.getProperty("testReportFolder"));
//        }
    }
    public void failTest(String message) {
        LisLogger.getInstance().loggerPrint(message);
        Assert.fail(message);
    }
    private String printInfoStatus(ITestResult result) {
        String testName = result.getName();
        if (result.getStatus() == FAILURE) {
            System.out.println("");
            LisLogger.getInstance().loggerPrint("Failed ****  ¯\\_(ツ)_/¯  **** " + testName);
            System.out.println("");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            LisLogger.getInstance().loggerPrint("Passed ****  ◕‿◕  **** " + testName);
            return "passed";
        }
        return testName;
    }

    private String howLong(Date startTime, Date endTime) {
        long diff = startTime.getTime() - endTime.getTime();
        int seconds = (int) (diff / 1000) % 60;
        int minutes = (int) ((diff / (1000 * 60)) % 60);
        String timeDurat = minutes + "m|" + seconds + "s";
        return timeDurat;
    }

    public String saveLogsDataToFile(List<String> arrLog2, ITestResult result) {
        StringBuilder list = new StringBuilder();
        for (String line : arrLog2) {
            list.append(line + "\n");
        }
        String log =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<testsuite name=\""
                        + result.getName()
                        +"\""
                        +" status=\""
                        + result.getStatus()
                        +"\">"
                        +"\n"
                        + list.toString()
                        + "</testsuite>";

        return log;
    }

    public void z_xWriteToFile(String path, String text) {
        try {
            PrintWriter outputfile = new PrintWriter(new FileWriter(path, true));
            outputfile.print(text);
            outputfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Date returnDate() {
        Date date = new Date();
        return date;
    }

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }
}
