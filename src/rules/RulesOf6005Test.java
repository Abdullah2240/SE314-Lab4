/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * External code is allowed when it is public, cited, not course work, and
     * the assignment does not require that feature to be implemented.
     */
    @Test
    public void testAllowsCitedPublicExternalCodeWhenImplementationIsOptional() {
        assertTrue("Expected true: properly cited public external code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /**
     * Work created for this course is not reusable, even if it can be found
     * publicly and the source is cited.
     */
    @Test
    public void testRejectsCodeWrittenAsCourseWork() {
        assertFalse("Expected false: code produced for course work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * A requested implementation must be written by the student rather than
     * reused from an external source.
     */
    @Test
    public void testRejectsExternalCodeForRequiredImplementation() {
        assertFalse("Expected false: external code for a required implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
}
