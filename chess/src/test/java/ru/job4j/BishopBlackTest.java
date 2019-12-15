package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

public class BishopBlackTest {
    @Test
    public void validatePositionMethod() {
        Cell position = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(position);
        assertThat(bishopBlack.position(), is(position));
    }
    @Test
    public void validateCopyMethod() {
        Cell position = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(position);
        Figure copyBishopBlack = bishopBlack.copy(position);
        assertThat(copyBishopBlack.position(), is(position));
    }
    @Test
    public void validateWayMethod() {
        Cell srcPos = Cell.C1;
        Cell destPos = Cell.H6;
        Cell[] result = {Cell.D2, Cell.E3, Cell.F4, Cell.G5,Cell.H6};
        BishopBlack bishopBlack = new BishopBlack(srcPos);
        Cell[] expect = bishopBlack.way(srcPos,destPos);
        assertThat(expect, is(result));

    }
    @Test
    public void ifNotDiagonal() throws IllegalStateException {
        Cell srcPos = Cell.C1;
        Cell destPos = Cell.H5;
        try {
            BishopBlack bishopBlack = new BishopBlack(srcPos);
            Cell[] expect = bishopBlack.way(srcPos,destPos);
            Assert.fail("IllegalStateException" );
        } catch (IllegalStateException thrown){
            Assert.assertNotEquals(String.format("Could not way by diagonal from %s to %s", srcPos, destPos),thrown.toString());
        }


    }
}

