package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    /**
     * возвращает позицию слона
     * @return
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * медот подсчитывает ход по диагонали
     * @param source
     * @param dest
     * @return
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = dest.x - source.x > 0 ? dest.x - source.x : source.x - dest.x;
        Cell[] steps = new Cell[size];
        int deltaX = dest.x - source.x > 0 ? 1 : -1;
        int deltaY = dest.y - source.y > 0 ? 1 : -1;
        int i = source.ordinal();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.values()[i = i + deltaX + deltaY + (7 * deltaX)];
        }
        return steps;
    }

    /**
     * проверка координат на диагональ
     * @param source
     * @param dest
     * @return
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int StepsX = dest.x - source.x > 0 ? dest.x - source.x : source.x - dest.x;
        int StepsY = dest.y - source.y > 0 ? dest.y - source.y : source.y - dest.y;
        if(StepsX == StepsY) {
            result = true;
        }
        return result;
    }

    /**
     * создает фигуру с новым расположением
     * @param dest
     * @return
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
