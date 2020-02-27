package seedu.jelphabot.model.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.jelphabot.testutil.Assert.assertThrows;

public class ModuleCodeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ModuleCode(null));
    }

    @Test
    public void constructor_invalidModuleCode_throwsIllegalArgumentException() {
        String invalidModuleCode = "";
        assertThrows(IllegalArgumentException.class, () -> new ModuleCode(invalidModuleCode));
    }

    @Test
    public void isValidModuleCode() {
        // null address
        assertThrows(NullPointerException.class, () -> ModuleCode.isValidModuleCode(null));

        // invalid addresses
        assertFalse(ModuleCode.isValidModuleCode("")); // empty string
        assertFalse(ModuleCode.isValidModuleCode(" ")); // spaces only
        assertFalse(ModuleCode.isValidModuleCode("CS")); // No numbers only
        assertFalse(ModuleCode.isValidModuleCode("2101S")); // No Faculty code
        assertFalse(ModuleCode.isValidModuleCode("A2101")); // Invalid Faculty code

        // valid addresses
        assertTrue(ModuleCode.isValidModuleCode("CS2101")); // No ending tag
        assertTrue(ModuleCode.isValidModuleCode("CS2103T")); // yes module tag
        assertTrue(ModuleCode.isValidModuleCode("ACC1301")); // module code has max 3 chars
    }
}
