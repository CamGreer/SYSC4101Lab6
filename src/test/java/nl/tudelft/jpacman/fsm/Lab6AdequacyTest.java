package nl.tudelft.jpacman.fsm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Lab6AdequacyTest {

    private static final Set<String> ALL_TRANSITIONS =
            Set.of("T1", "T2", "T3", "T4", "T5", "T6");

    @Test
    @DisplayName("TS_s is All-States adequate (visits X, Y, Z)")
    void tsSVisitsAllStates() {
        assertFalse(Lab6Suites.tsS().isEmpty(), "TS_s is empty --- fill it in.");
        Set<GhostModeFSM.State> visited =
                GhostModeFSM.statesCoveredBy(Lab6Suites.tsS());
        assertEquals(EnumSet.allOf(GhostModeFSM.State.class), visited,
                "TS_s must visit all three states X, Y, Z");
    }

    @Test
    @DisplayName("TS_t is All-Transitions adequate (fires T1..T6)")
    void tsTFiresAllTransitions() {
        assertFalse(Lab6Suites.tsT().isEmpty(), "TS_t is empty --- fill it in.");
        Set<String> fired = GhostModeFSM.transitionsCoveredBy(Lab6Suites.tsT());
        assertEquals(ALL_TRANSITIONS, fired,
                "TS_t must fire all six transitions (check the T2 and T5 self-loops)");
    }

    @Test
    @DisplayName("TS_tt (transition tree) is All-Transitions adequate")
    void tsTtFiresAllTransitions() {
        assertFalse(Lab6Suites.tsTt().isEmpty(), "TS_tt is empty --- fill it in.");
        Set<String> fired = GhostModeFSM.transitionsCoveredBy(Lab6Suites.tsTt());
        assertEquals(ALL_TRANSITIONS, fired,
                "TS_tt must fire all six transitions");
    }
}
