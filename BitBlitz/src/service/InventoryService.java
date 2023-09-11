package service;

import model.BidBlitzInventory;
import model.Event;
import model.Member;

import java.util.ArrayList;

public class InventoryService {

    BidBlitzInventory bidBlitzInventory;

    public InventoryService(BidBlitzInventory bidBlitzInventory) {
        this.bidBlitzInventory = bidBlitzInventory;
    }

    public void addMember(Member member) {
        ArrayList<Member> memberList = this.bidBlitzInventory.getMemberList();
        if(memberList.contains(member)) {
            System.out.println("Member already exists in the system");
        } else {
            memberList.add(member);
        }
    }

    public void addEvent(Event event) {
        ArrayList<Event> eventList = this.bidBlitzInventory.getEventList();
        if(eventList.contains(event)) {
            System.out.println("Event already exists in the system");
        } else {
            eventList.add(event);
        }
    }

}
