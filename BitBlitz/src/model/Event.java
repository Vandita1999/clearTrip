package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Event {

    String eventId;
    String eventName;
    String prizeName;
    ArrayList<Member> members;
    Map<String, ArrayList<Bid>> memberMap;

    //100,500,400,800,900
    //500, 100, 300, 400

    Map<String, Map<Bid,Integer>> minimumBid;

    // ("m1" , ("100", "1"))
    // ("m2" , ("100", "2"))

    public Event(String eventId, String eventName, ArrayList<Member> members,String prizeName) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.members = members;
        this.prizeName = prizeName;
        this.memberMap = new HashMap<>();
        this.minimumBid = new HashMap<>();

    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Map<String, ArrayList<Bid>> getMemberMap() {
        return memberMap;
    }

    public Map<String, Map<Bid, Integer>> getMinimumBid() {
        return minimumBid;
    }

    public String getEventName() {
        return eventName;
    }

    public String getPrizeName() {
        return prizeName;
    }
}
