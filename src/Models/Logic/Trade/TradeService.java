package Models.Logic.Trade;

import Game.World;
import Models.Elements.Resources.Resource;
import java.util.List;

public final class TradeService {
    public void execute(World world, TradeOffer offer) throws Exception {
        List<Resource> stock = world.getResourceRecord().getAll(offer.giveType());
        if (stock.size() < offer.giveAmount())
            throw new Exception("Not enough " + offer.giveType().getSimpleName());
        Integer capacity = world.getTownHall().getStorageCapacity().get(offer.receiveType());
        if (capacity != null && world.getResourceRecord().getAll(offer.receiveType()).size() + offer.receiveAmount() > capacity)
            throw new Exception("Not enough storage capacity");
        for (int i = 0; i < offer.giveAmount(); i++)
            world.getResourceRecord().remove(stock.get(i));
        for (int i = 0; i < offer.receiveAmount(); i++)
            world.getResourceRecord().add(offer.receiveType().getDeclaredConstructor().newInstance());
    }
}
