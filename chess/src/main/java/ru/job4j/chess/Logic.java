package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * класс проверяет наличие фигур на пути передвижения текущей фигуры
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    /**
     * добавляет фигуру в хранилище
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * проверяет нет ли фигур на пути движения проверяемой фигуры и записывает новые координаты фигуры
     * @param source
     * @param dest
     * @return
     */
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            try {
                Cell[] steps = this.figures[index].way(source, dest);
                if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                    boolean trigger = false;
                        for(int i = 0; i < steps.length; i++) {
                            if(this.findBy(steps[i]) != -1) {
                                trigger = true;
                                break;
                            }
                        }
                    if (!trigger) {
                        rst = true;
                        this.figures[index] = this.figures[index].copy(dest);
                    }

                }
            } catch (IllegalStateException ise) {
                System.out.println(ise);
            }


        }
        return rst;
    }

    /**
     * очистка хранилища фигур
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * поиск фигуры с координатами cell  в хранилище
     * @param cell
     * @return
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
