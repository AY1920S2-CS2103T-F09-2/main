package seedu.jelphabot.model.task;

import java.util.function.Predicate;

public class TaskCompletedPredicate implements Predicate<Task> {

    @Override
    public boolean test(Task task) {
        return task.getStatus() == Status.COMPLETE;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same objcet
                || (other instanceof TaskCompletedPredicate); // instanceof handles null
    }
}