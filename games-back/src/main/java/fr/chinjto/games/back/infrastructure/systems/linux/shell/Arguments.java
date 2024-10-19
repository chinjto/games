package fr.chinjto.games.back.infrastructure.systems.linux.shell;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Cyril DEFAYE
 * @since 10.2024
 */
@Getter
public class Arguments {

    private final List<String> values;

    public Arguments() {
        this.values = new ArrayList<>();
    }

    public Arguments(final List<String> values) {
        this.values = new ArrayList<>(values);
    }

    public Arguments(final String[] values) {
        this.values = new ArrayList<>(Arrays.asList(values));
    }

    public Arguments prepend(final String arg) {
        this.values.addFirst(arg);
        return this;
    }

    public Arguments append(final String arg) {
        this.values.add(arg);
        return this;
    }

    public List<String> values() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public String toString() {
        return String.join(" ", values);
    }

}
