package model;

import java.util.ArrayList;

public class BidBlitzInventory {

    ArrayList<Member> memberList;
    ArrayList<Event> eventList;

    public BidBlitzInventory(ArrayList<Member> memberList, ArrayList<Event> eventList) {
        this.memberList = memberList;
        this.eventList = eventList;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }
}

