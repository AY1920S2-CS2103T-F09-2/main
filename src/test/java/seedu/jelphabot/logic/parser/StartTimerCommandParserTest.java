// @@author Clouddoggo

package seedu.jelphabot.logic.parser;

import static seedu.jelphabot.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.jelphabot.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.jelphabot.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.jelphabot.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import org.junit.jupiter.api.Test;

import seedu.jelphabot.logic.commands.StartTimerCommand;


/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the StartTimerCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the StartTimerCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
class StartTimerCommandParserTest {

    private StartTimerCommandParser parser = new StartTimerCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(
            parser, "   ",
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, StartTimerCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsStartTimerCommand() {
        assertParseSuccess(parser, "1", new StartTimerCommand(INDEX_FIRST_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, StartTimerCommand.MESSAGE_USAGE));
    }

}
