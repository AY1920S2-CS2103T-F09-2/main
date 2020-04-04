package seedu.jelphabot.logic.commands;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.YearMonth;

import seedu.jelphabot.commons.core.Messages;
import seedu.jelphabot.model.Model;
import seedu.jelphabot.model.task.predicates.TaskDueWithinDayPredicate;
import seedu.jelphabot.ui.CalendarPanel;
import seedu.jelphabot.ui.MainWindow;

/**
 * Lists all tasks in task list whose date corresponds with the specified date.
 * Shows the tasks that are due on the specified date.
 */
public class CalendarCommand extends Command {

    public static final String COMMAND_WORD = "calendar";
    public static final String COMMAND_SHORTCUT_UPPER = ":C";
    public static final String COMMAND_SHORTCUT_LOWER = ":c";

    //update this
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all task that is under the due date specified.\n"
                                                   + "Parameters: DATE \n"
                                                   + "Example: " + COMMAND_WORD + " Jan-1-2020";

    public static final String MESSAGE_SWITCH_PANEL_ACKNOWLEDGEMENT = "Switched to calendar panel.";

    public static final String MESSAGE_SWITCH_CALENDAR_VIEW_ACKNOWLEDGEMENT = "Switched calendar panel to : %s";
    public static final String MESSAGE_SWITCH_CALENDAR_TODAY_ACKNOWLEDGEMENT = "Switched calendar panel to : %s, "
                                                                                   + "displaying all your tasks "
                                                                                   + "due today!";

    private final TaskDueWithinDayPredicate predicate;
    private final YearMonth yearMonth;

    private CalendarPanel calendarPanel = MainWindow.getCalendarPanel();

    public CalendarCommand() {
        predicate = null;
        yearMonth = null;
    }

    public CalendarCommand(TaskDueWithinDayPredicate predicate) {
        this.predicate = predicate;
        yearMonth = null;
    }

    public CalendarCommand(YearMonth yearMonth) {
        this.predicate = null;
        this.yearMonth = yearMonth;
    }

    public CalendarCommand(TaskDueWithinDayPredicate predicate, YearMonth yearMonth) {
        this.predicate = predicate;
        this.yearMonth = yearMonth;
    }

    @Override
    public CommandResult execute(Model model) {
        if (predicate == null && yearMonth == null) {
            return new CommandResult(MESSAGE_SWITCH_PANEL_ACKNOWLEDGEMENT, false, false).isShowCalendar();
        } else if (yearMonth == null) { //switch task list for specific dates
            requireNonNull(model);
            model.updateFilteredCalendarTaskList(predicate);
            LocalDate date = predicate.getDate();
            return new CommandResult(
                String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW,
                    model.getFilteredCalendarTaskList().size()), date, null);
        } else if (predicate == null) { //switch calendar view
            //TODO tasklist should update to display first day of the month
            return new CommandResult(String.format(MESSAGE_SWITCH_CALENDAR_VIEW_ACKNOWLEDGEMENT,
                calendarPanel.getMonthYear()), null, yearMonth);
        } else { //switch calendar view and task list for today
            requireNonNull(model);
            model.updateFilteredCalendarTaskList(predicate);
            return new CommandResult(String.format(MESSAGE_SWITCH_CALENDAR_TODAY_ACKNOWLEDGEMENT,
                calendarPanel.getMonthYear()), null, null);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                   || (other instanceof CalendarCommand // instanceof handles nulls
                           && predicate.equals(((CalendarCommand) other).predicate)
                           && yearMonth.equals(((CalendarCommand) other).yearMonth)); // state check
    }

}

