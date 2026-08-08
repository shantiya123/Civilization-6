package Models.Logic.Trade;

import Models.Elements.Resources.Resource;
import java.util.Set;

public record TradeCatalog(Set<Class<? extends Resource>> buys, Set<Class<? extends Resource>> sells) {
    public boolean supports(Class<? extends Resource> give, Class<? extends Resource> receive) {
        return buys.contains(give) && sells.contains(receive);
    }
}
