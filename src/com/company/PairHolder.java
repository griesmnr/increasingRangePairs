package com.company;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by nicoleg on 12/7/15.
 */
public class PairHolder {
    private int startIx; //going to use this when i start a range.
    private int val;
    private Integer increaseIx; //every time i find a higher number i will add this.
    private Integer stopIx; //when i get to a number that is now lower, i will set stopIx to increaseIx.
    //my valid pair is then startIx, stopIx.
    private boolean isInvalid;

    public PairHolder(int startIx, int val){
        this.startIx = startIx;
        this.val = val;
        this.isInvalid = false;
    }

    public boolean hasValidPair(){
        return stopIx !=null;
    }

    public void processNum(int ix, int num, boolean isLastInArray){
        if (num >= val){
            //we'll go ahead and say equal numbers are still increasing.
            // 3445 should be considered increasing for instance.
            this.increaseIx = ix;
            this.val = num;
        } else { //found a lower number.
            if (increaseIx !=null){
                this.stopIx = increaseIx;
            } else {
                //we've detected a smaller number, and it hasn't increased at all since it started.
                //this range needs to be scrapped.
                this.isInvalid = true;
            }
        }
        if (isLastInArray && increaseIx !=null){
            this.stopIx = increaseIx;
        }
    }

    public boolean isInvalid() {
        return isInvalid;
    }

    public Map.Entry<Integer,Integer> getPair(){
        return new AbstractMap.SimpleImmutableEntry<Integer, Integer>(startIx,stopIx);
    }
}
