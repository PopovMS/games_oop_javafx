package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Assert;

public class LogicTest {
    @Test
    public void testLogicAddMethod() {
        Cell source = Cell.A1;
        Cell dest = Cell.C3;
        Logic logic = new Logic();
        logic.add(new BishopBlack(source));
        assertThat(logic.move(source,dest), is(true));
    }
    @Test
    public void testLogicMoveMethod() {
        Cell source = Cell.A1;
        Cell dest = Cell.C3;
        Cell dest2 = Cell.E5;
        Logic logic = new Logic();
        logic.add(new BishopBlack(source));
        logic.move(source,dest);
        assertThat(logic.move(dest,dest2), is(true));
    }

}