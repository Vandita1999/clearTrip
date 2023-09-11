package model;

public class Member {

    String memberId;
    String memberName;
    int superCoins;

    public Member(String memberId, String memberName, int superCoins) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.superCoins = superCoins;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }
}
