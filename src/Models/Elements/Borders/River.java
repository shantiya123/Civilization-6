package Models.Elements.Borders;

import Models.Elements.Hex.Hex;

public class River extends Border {
    private int movingCost = 2;
    public River(Hex firstHex, Hex secondHex) {
        super(firstHex, secondHex);
    }
}
