package nl.tudelft.jpacman.fsm;

import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Ghost-mode controller FSM (Lab 6 specification) --- do not modify.
 * States: X = SCATTER (initial), Y = CHASE, Z = FRIGHTENED.
 * Inputs: 'a' (mode event), 'b' (timer tick).
 *   T1: X -a/0-> Y     T2: X -b/1-> X
 *   T3: Y -a/1-> Z     T4: Y -b/0-> X
 *   T5: Z -a/0-> Z     T6: Z -b/1-> Y
 */
public final class GhostModeFSM {

    public enum State { X, Y, Z }

    private State current;
    private final Set<State> visited = new LinkedHashSet<>();
    private final Set<String> fired = new LinkedHashSet<>();

    public GhostModeFSM() {
        reset();
    }

    public void reset() {
        current = State.X;
        visited.clear();
        fired.clear();
        visited.add(current);
    }

    public int step(char input) {
        final State from = current;
        final int out;
        final String transition;
        switch (from) {
            case X:
                if (input == 'a') { current = State.Y; out = 0; transition = "T1"; }
                else              { current = State.X; out = 1; transition = "T2"; }
                break;
            case Y:
                if (input == 'a') { current = State.Z; out = 1; transition = "T3"; }
                else              { current = State.X; out = 0; transition = "T4"; }
                break;
            case Z:
                if (input == 'a') { current = State.Z; out = 0; transition = "T5"; }
                else              { current = State.Y; out = 1; transition = "T6"; }
                break;
            default:
                throw new IllegalStateException("unreachable");
        }
        fired.add(transition);
        visited.add(current);
        return out;
    }

    public String run(String inputs) {
        reset();
        final StringBuilder sb = new StringBuilder();
        for (final char c : inputs.toCharArray()) {
            if (c != 'a' && c != 'b') {
                throw new IllegalArgumentException("inputs must be 'a' or 'b', got: " + c);
            }
            sb.append(step(c));
        }
        return sb.toString();
    }

    public State current() {
        return current;
    }

    public static Set<State> statesCoveredBy(Iterable<String> suite) {
        final Set<State> all = EnumSet.noneOf(State.class);
        for (final String path : suite) {
            final GhostModeFSM m = new GhostModeFSM();
            m.run(path);
            all.addAll(m.visited);
        }
        return all;
    }

    public static Set<String> transitionsCoveredBy(Iterable<String> suite) {
        final Set<String> all = new LinkedHashSet<>();
        for (final String path : suite) {
            final GhostModeFSM m = new GhostModeFSM();
            m.run(path);
            all.addAll(m.fired);
        }
        return all;
    }
}
