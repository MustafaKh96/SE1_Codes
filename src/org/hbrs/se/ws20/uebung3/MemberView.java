package org.hbrs.se.ws20.uebung3;

import org.hbrs.se.ws20.uebung2.Member;

import java.util.List;

public class MemberView {
    public void dump(List<Member> list) {
        for (Member a : list) {
            System.out.println(a.toString());
        }
    }
}