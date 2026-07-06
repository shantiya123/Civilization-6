package Models.Elements;

import Models.Elements.Element;

public interface Showable extends Element {
    int getX();
    void setX(int x);

    int getY();
    void setY(int y);

    int getSize();
    void setSize(int size);
}