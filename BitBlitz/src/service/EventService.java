package service;

import model.Bid;
import model.Event;
import model.Member;

import java.util.*;

public class EventService {

    Event event;

    public EventService(Event event) {
        this.event = event;
    }

    public void registerMember(Member member) {
        ArrayList<Member> memberList = this.event.getMembers();
        memberList.add(member);
    }

    public boolean submitBid(String memberId, ArrayList<Bid> bids) {
        Map<String, ArrayList<Bid>> bidList = this.event.getMemberMap(); //("m1" -> {100,200,300})
        Map<String, Map<Bid, Integer>> lowestBidMap = this.event.getMinimumBid(); //()
        int minBid;
        Bid bid = null;
        int pos = -1;
        if(bidList.containsKey(memberId)) {
            return false; // bid cannot be made again for that member
        } else {
            boolean isBidValid = checkForValidBid(bids, memberId);
            populateMinBid(lowestBidMap, bids, memberId);
            bidList.put(memberId, bids);
            return true;
        }
    }

    private void populateMinBid(Map<String, Map<Bid, Integer>> lowestBidMap, ArrayList<Bid> bids, String memberId) {
        int min = -1;
        int pos = -1;
        Bid minBid = null;
        for(int i=0; i <= bids.size() ; i++) {
            if(bids.get(i).getBidValue() < min) {
                min = bids.get(i).getBidValue();
                pos = i;
                minBid = bids.get(i);
            }
        }
        if(lowestBidMap.containsKey(memberId)) {
            Map<Bid, Integer> lowestBid = lowestBidMap.get(memberId);
            lowestBid.put(minBid,pos);
        } else {
            Map<Bid, Integer> lowestBid = new HashMap<>();
            lowestBid.put(minBid,pos);
            lowestBidMap.put(memberId, lowestBid);
        }
    }

    private boolean checkForValidBid(ArrayList<Bid> bids, String memberId) {
        List<Member> memberList = this.event.getMembers();
        Member memberFound = null;
        for(Member member : memberList) {
            if(member.getMemberId().equals(memberId)) {
                memberFound = member;
                break;
            }
        }
        if(memberFound!=null) {
            for (Bid bid : bids) {
                if (bid.getBidValue() > memberFound.getSuperCoins()) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public void declareWinner() {
        Map<String, ArrayList<Bid>> bidMap = this.event.getMemberMap();
        int minBid = -1;
        String winner = "";
        Map<String, Map<Bid, Integer>> lowestBid = this.event.getMinimumBid();

        for(Map.Entry<String, Map<Bid, Integer>> lowest : lowestBid.entrySet()) {
            for(Map.Entry<Bid, Integer> bids : lowest.getValue().entrySet()) {
                if(bids.getKey().getBidValue() < minBid) {
                    minBid = bids.getKey().getBidValue();
                    winner = lowest.getKey();
                }
            }
        }
        System.out.println( winner +  " wins the " + this.event.getPrizeName() + " with lowest bid "+ minBid);

    }

}
