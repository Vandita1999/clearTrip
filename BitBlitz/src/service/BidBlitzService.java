package service;

import com.sun.jdi.IntegerValue;
import model.BidBlitzInventory;
import model.Event;
import model.Member;

import javax.swing.text.BadLocationException;
import java.util.ArrayList;


public class BidBlitzService {


    Member member = new Member("123", "Vandita", 900);
    Member member2 = new Member("124", "Ananya", 400);

    ArrayList<Member> members = new ArrayList<Member>();

    members.add(member);
    members.add(member2);

    Event event1 = new Event("1","Blitz",members , "Iphone 12");

    EventService eventService = new EventService(event1);
    InventoryService inventoryService;



}
