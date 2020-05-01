package Lisnr.Project.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LisLogger {

    private Logger logger = LoggerFactory.getLogger(CommonAppium.class.getName());
    private List<String> log = new LinkedList<>();

    private static LisLogger instance;

    private LisLogger() {}

    public static LisLogger getInstance() {
        if (instance == null) {
            instance = new LisLogger();
        }
        return instance;
    }

    public void loggerPrint(String message) {
        message = MessageFormat.format("{0} - {1} | {2}", returnMinSec(), "INFO", message);
        logger.info(message);
        log.add(" <testcase name=\"" + message + "\"/>");
    }

    public void loggerPrintError(String message) {
        message = MessageFormat.format("{0} - {1} | {2}", returnMinSec(), "ERROR", message);
        logger.error(message);
        log.add(" <testcase name=\"" + message + "\"/>");
    }

    public void loggerPrintWarn(String message) {
        message = MessageFormat.format("{0} - {1} | {2}", returnMinSec(), "WARNING", message);
        logger.warn(message);
        log.add(message);
    }

    public List<String> getLog() {
        return log;
    }

    private static String returnMinSec() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}

