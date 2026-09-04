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
import Models.Elements.Resources.Resource;
import Models.Elements.Tribes.Tribe;
import Models.Logic.Trade.TradeOffer;


public final class TribeController {

    public TribeController() { }

    public void sendGift(Tribe tribe, Class<? extends Resource> type, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        SendGiftRequest request = new SendGiftRequest(null, tribe, type, amount);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public TradeOffer createTradeOffer(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        CreateTradeOfferRequest request = new CreateTradeOfferRequest(null, tribe, give, receive, amount);
        // TODO: send `request` to the server once the client-server network connection exists.
        // TODO: no response channel yet, so the resulting TradeOffer isn't available client-side.
        return null;
    }

    public void trade(Tribe tribe, Class<? extends Resource> give, Class<? extends Resource> receive, int amount) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        TradeRequest request = new TradeRequest(null, tribe, give, receive, amount);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void acceptMission(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        AcceptMissionRequest request = new AcceptMissionRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void payMissionResources(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        PayMissionResourcesRequest request = new PayMissionResourcesRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void claimMissionReward(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        ClaimMissionRewardRequest request = new ClaimMissionRewardRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void cancelMission(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        CancelMissionRequest request = new CancelMissionRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void declareWar(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        DeclareWarRequest request = new DeclareWarRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void requestPeace(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        RequestPeaceRequest request = new RequestPeaceRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }

    public void requestAlliance(Tribe tribe) {
        // TODO: token is not yet available client-side (auth is a later phase); pass null for now.
        RequestAllianceRequest request = new RequestAllianceRequest(null, tribe);
        // TODO: send `request` to the server once the client-server network connection exists.
    }
}