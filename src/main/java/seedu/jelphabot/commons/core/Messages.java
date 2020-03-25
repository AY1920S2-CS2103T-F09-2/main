package seedu.jelphabot.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid";
    public static final String MESSAGE_TASKS_LISTED_OVERVIEW = "%1$d tasks listed!";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "Invalid date format! "
                                                                 + "Date should be one of these possible formats:\n"
                                                                 + "[MMM-d-yyyy],\n[MMM/d/yyyy],\n[d/M/y],"
                                                                 + "\n[d-MMM-yyyy],\n[d MMM yyyy]";
    public static final String MESSAGE_CANNOT_START_MORE_TIMERS = "Unable to start more than one timer at a time!";
    public static final String MESSAGE_DELETE_TIMING_TASK_FAILURE = "Task: %s %s, DateTime: %s cannot be deleted\n"
                                                                        + "while timer is running.";
    public static final String MESSAGE_COMPLIMENT = "Good work! (:";
    public static final String MESSAGE_ENCOURAGEMENT = "You can do better than this!";
    public static final String MESSAGE_CRITICISM = "Do better! You have many unfinished tasks that are past their"
                                                       + " due date!";
    public static final String MESSAGE_CURRENT_TIMERS = "Timer is currently running for Task: %s %s, DateTime: %s";
    public static final String MESSAGE_NO_TIMERS = "There are no tasks being timed at the moment.";

}
