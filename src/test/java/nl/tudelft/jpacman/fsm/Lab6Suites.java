package nl.tudelft.jpacman.fsm;

import java.util.List;

/**
 * Lab 6 --- encode your three test suites here as input strings over {'a','b'}.
 * Example: the path X-a->Y-a->Z is the string "aa".
 * CI is green only when TS_s visits all states and TS_t, TS_tt fire all six
 * transitions. (Do NOT edit GhostModeFSM.)
 */
public final class Lab6Suites {

    private Lab6Suites() { }

    /** All-States adequate suite. */
    public static List<String> tsS() {
        return List.of(/* TODO: e.g. "aa" */);
    }

    /** All-Transitions adequate suite. */
    public static List<String> tsT() {
        return List.of(/* TODO */);
    }

    /** Transition-Tree (Chow) adequate suite. */
    public static List<String> tsTt() {
        return List.of(/* TODO */);
    }
}
