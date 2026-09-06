package Game.Client.Controllers;

import Base.Request.AcceptMissionRequest;
import Base.Request.CancelMissionRequest;
import Base.Request.ClaimMissionRewardRequest;
import Base.Request.CreateTradeOfferRequest;
import Base.Request.DeclareWarRequest;
import Base.Request.PayMissionResourcesRequest;
import Base.Request.RequestAllianceRequest;
import Base.Request.RequestPeaceRequest;
import Base.Request.SendGiftRequest;
import Base.Request.TradeRequest;
import Game.Client.Managers.ClientServerManager;
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Trade.TradeOffer;


public final class TribeController {
    private final ClientServerManager server;

    public TribeController(ClientServerManager server) { this.server = server; }

    public void sendGift(Tribe tribe, Class<? extends Resource> type, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        SendGiftRequest request = new SendGiftRequest(null, tribe, type, amount);
        server.sendRequest(request);
    }

    public TradeOffer createTradeOffer(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        CreateTradeOfferRequest request = new CreateTradeOfferRequest(null, tribe, give, receive, amount);
        server.sendRequest(request);
        // TODO: no response channel yet, so the resulting TradeOffer isn't available client-side.
        return null;
    }

    public void trade(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        TradeRequest request = new TradeRequest(null, tribe, give, receive, amount);
        server.sendRequest(request);
    }

    public void acceptMission(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        AcceptMissionRequest request = new AcceptMissionRequest(null, tribe);
        server.sendRequest(request);
    }

    public void payMissionResources(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        PayMissionResourcesRequest request = new PayMissionResourcesRequest(null, tribe);
        server.sendRequest(request);
    }

    public void claimMissionReward(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ClaimMissionRewardRequest request = new ClaimMissionRewardRequest(null, tribe);
        server.sendRequest(request);
    }

    public void cancelMission(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        CancelMissionRequest request = new CancelMissionRequest(null, tribe);
        server.sendRequest(request);
    }

    public void declareWar(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        DeclareWarRequest request = new DeclareWarRequest(null, tribe);
        server.sendRequest(request);
    }

    public void requestPeace(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        RequestPeaceRequest request = new RequestPeaceRequest(null, tribe);
        server.sendRequest(request);
    }

    public void requestAlliance(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        RequestAllianceRequest request = new RequestAllianceRequest(null, tribe);
        server.sendRequest(request);
    }
}
