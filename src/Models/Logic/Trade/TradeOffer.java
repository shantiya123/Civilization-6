package Models.Logic.Trade;

import Models.Elements.Resources.Resource;

public record TradeOffer(Class<? extends Resource> giveType, int giveAmount,
                         Class<? extends Resource> receiveType, int receiveAmount) {
    public TradeOffer {
        if (giveType == null || receiveType == null || giveType == receiveType || giveAmount <= 0 || receiveAmount <= 0)
            throw new IllegalArgumentException("Invalid trade offer");
    }
}
