package seedu.jelphabot.logic.parser;

import static seedu.jelphabot.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import seedu.jelphabot.commons.core.Messages;
import seedu.jelphabot.logic.commands.CalendarCommand;
import seedu.jelphabot.logic.parser.exceptions.ParseException;
import seedu.jelphabot.model.task.DateTimeContainsDatePredicate;

/**
 * Parses input argument and creates a new CalendarCommand object
 */
public class CalendarCommandParser implements Parser<CalendarCommand> {

    private static final List<DateFormat> dateFormats =
        Arrays.asList(
            new SimpleDateFormat("MMM-d-yyyy"),
            new SimpleDateFormat("MMM/d/yyyy"),
            new SimpleDateFormat("d/M/y"),
            new SimpleDateFormat("d-MMM-yyyy"),
            new SimpleDateFormat("d MMM yyyy")
        );

    /**
     * Parses the given {@code String} of argument in the context of the CalendarCommand
     * and returns a CalendarCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CalendarCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalendarCommand.MESSAGE_USAGE));
        }
        String standardDateString = "";
        try {
            if (!isValidDate(trimmedArgs)) {
                throw new ParseException(Messages.MESSAGE_INVALID_DATE_FORMAT);
            }
            DateFormat currentFormat = getDateFormatOfString(trimmedArgs);
            Date date = currentFormat.parse(trimmedArgs);
            standardDateString = new SimpleDateFormat("MMM-d-yyyy").format(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return new CalendarCommand(new DateTimeContainsDatePredicate(standardDateString));
    }

    private static DateFormat getDateFormatOfString(String dateTimeString) {
        for (DateFormat df : dateFormats) {
            try {
                df.parse(dateTimeString);
                return df;
            } catch (java.text.ParseException e) {
                // do nothing, try next
            }
        }
        return null;
    }

    /**
     * Returns if the given string is a valid date format, specified in the List dateFormatStrings.
     *
     * @param test The date to be checked.
     * @return The boolean representing whether the date provided is valid.
     */
    public static boolean isValidDate(String test) {
        for (DateFormat df : dateFormats) {
            try {
                df.parse(test);
                return true;
            } catch (java.text.ParseException e) {
                // do nothing, try next
            }
        }
        return false;
    }
}