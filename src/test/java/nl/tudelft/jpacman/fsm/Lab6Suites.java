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

    public static List<String> tsS()  { return List.of("aa"); }
    public static List<String> tsT()  { return List.of("aaab", "ab", "b"); }
    public static List<String> tsTt() { return List.of("b", "ab", "aaa", "aab"); }
}
