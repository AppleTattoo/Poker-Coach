package com.example.alex_.pokercoach;

/**
 * Created by alex_ on 26/04/2018.
 */

public class SingleCard extends PlayScreen {
    private short rank;
    private short suit;

    public static String[] suits = {
            "hearts",
            "spades",
            "diamonds",
            "clubs"
    };

    public static String[] ranks  = {
            "Ace",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "Jack",
            "Queen",
            "King"
    };

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }

    SingleCard(short suit, short rank) {
        this.rank=rank;
        this.suit=suit;
    }

    public @Override String toString() {
        return ranks[rank] + " of " + suits[suit];
    }

    public short getRank() {
        return rank;
    }

    public short getSuit() {
        return suit;
    }
}
