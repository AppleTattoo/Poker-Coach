package com.example.alex_.pokercoach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by alex_ on 26/04/2018.
 */

public class Hand extends AppCompatActivity {
    private SingleCard[] cardsList;
    private int[] cardVal;
    private TextView tvCurrentHand;
    public String currentCard;
    public static String handValue = null;
    public static String allHandValue1 = null;
    public static String allHandValue2 = null;
    public static String allHandValue3 = null;
    public static String allHandValue4 = null;
    public static String allHandValue5 = null;
    public static String allHandValue6 = null;
    public static String allHandValue7 = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_play_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvCurrentHand = findViewById(R.id.tvCurrentHand);

    }

    Hand(Deck d) {
        cardVal = new int [6];
        cardsList = new SingleCard [7];

        for (int x = 0; x <= 6; x++) {
            cardsList [x] = d.drawFromDeck();
        }

        int[] ranks = new int [14];

        for (int x = 0; x <= 13; x++) {
            ranks [x] = 0;
        }

        for (int x = 0; x <= 6; x++) {
            ranks [cardsList [x] .getRank()]++;
        }

        int sameCards = 1;
        int groupRank = 0;

        for (int x = 13; x >= 1; x--) {
            if ( ranks [x] > sameCards) {
                sameCards = ranks [x];
                groupRank = x;
            }
        }


        sameCards = 1;
        int sameCards2 = 1;
        int largeGroupRank = 0;
        int smallGroupRank = 0;

        for (int x = 13; x >= 1; x--) {
            if (ranks [x] > sameCards) {
                if (sameCards != 1) {
                    sameCards2 = sameCards;
                    smallGroupRank = largeGroupRank;
                }

                sameCards = ranks[x];
                largeGroupRank = x;

            } else if (ranks [x] > sameCards2) {
                sameCards2 = ranks[x];
                smallGroupRank = x;
            }
        }


        boolean flush = true;

        for (int x = 0; x <= 4; x++) {
            if (cardsList [x].getSuit() != cardsList [x + 1] .getSuit()) {
                flush = false;
            }
        }

        int topStraightValue = 0;
        boolean straight = false;

        for (int x = 1; x <= 9; x++) {
            if (ranks [x] == 1 && ranks [x+1] == 1 && ranks [x+2] == 1 && ranks [x+3] == 1 && ranks [x+4] == 1) {
                straight = true;
                topStraightValue = x + 4;
                break;
            }
        }

        if (ranks [10] == 1 && ranks [11] == 1 && ranks [12] == 1 && ranks [13] == 1 && ranks [1] == 1) {
            straight = true;
            topStraightValue = 14;
        }

        int[] orderedRanks = new int [7];

        int index = 0;


        if (ranks [1] == 1) {
            orderedRanks [index] = 14;
            index++;
        }

        for (int x = 13; x >= 2; x--) {
            if (ranks [x] == 1) {
                orderedRanks[index]=x;
                index++;
            }
        }

        if (sameCards == 1) {
            cardVal [0] = 1;
            cardVal [1]=orderedRanks [0];
            cardVal [2]=orderedRanks [1];
            cardVal [3]=orderedRanks [2];
            cardVal [4]=orderedRanks [3];
            cardVal [5]=orderedRanks [4];

        }

        if (sameCards == 2 && sameCards2 == 1) {
            cardVal [0] = 2;
            cardVal [1] =largeGroupRank;
            cardVal [2] =orderedRanks [0];
            cardVal [3] =orderedRanks [1];
            cardVal [4] =orderedRanks [2];

        }

        if (sameCards == 2 && sameCards2 == 2) {
            cardVal [0] = 3;
            cardVal [1] = largeGroupRank > smallGroupRank ? largeGroupRank : smallGroupRank;
            cardVal [2] = largeGroupRank < smallGroupRank ? largeGroupRank : smallGroupRank;
            cardVal [3] = orderedRanks [0];

        }

        if (sameCards == 3 && sameCards2 != 2) {
            cardVal [0] = 4;
            cardVal [1] = largeGroupRank;
            cardVal [2] = orderedRanks [0];
            cardVal [3] = orderedRanks [1];


        }

        if (straight) {
            cardVal [0] = 5;
            cardVal [1] = topStraightValue;
        }

        if (flush) {
            cardVal [0] = 6;
            cardVal [1] = orderedRanks [0];
            cardVal [2] = orderedRanks [1];
            cardVal [3] = orderedRanks [2];
            cardVal [4] = orderedRanks [3];
            cardVal [5] = orderedRanks [4];
        }

        if (sameCards == 3 && sameCards2 == 2) {
            cardVal [0] = 7;
            cardVal [1] = largeGroupRank;
            cardVal [2] = smallGroupRank;
        }

        if (sameCards == 4) {
            cardVal [0] = 8;
            cardVal [1] = largeGroupRank;
            cardVal [2] = orderedRanks [0];
        }

        if (straight && flush) {
            cardVal [0] = 9;
            cardVal [1] = topStraightValue;
        }
    }

    public void display() {
        String printHand;

        switch(cardVal [0]) {
            case 1:
                printHand = "high card";
                break;
            case 2:
                printHand = "pair of " + SingleCard.rankAsString(cardVal[1]) + "\'s";
                break;
            case 3:
                printHand = "two pairs of " + SingleCard.rankAsString(cardVal[1]) + "'s and " + SingleCard.rankAsString(cardVal[2]) + "'s";
                break;
            case 4:
                printHand = "three of a kind " + SingleCard.rankAsString(cardVal[1]) + "\'s";
                break;
            case 5:
                printHand = SingleCard.rankAsString(cardVal[1]) + " high straight";
                break;
            case 6:
                printHand = "flush";
                break;
            case 7:
                printHand = "full house " + SingleCard.rankAsString(cardVal[1]) + " over " + SingleCard.rankAsString(cardVal[2]);
                break;
            case 8:
                printHand = "four of a kind " + SingleCard.rankAsString(cardVal[1]);
                break;
            case 9:
                printHand = "straight flush " + SingleCard.rankAsString(cardVal[1]) + " high";
                break;
            default:
                printHand = "error in Hand.display: value[0] contains invalid value";
        }
        System.out.println(printHand);
        handValue = (printHand).toLowerCase();

    }

    public void displayAll() {
        for (int x = 0; x <= 6; x++) {
            System.out.println(cardsList[x]);
            allHandValue1 = (cardsList[0]).toString().toLowerCase();
            allHandValue2 = (cardsList[1]).toString().toLowerCase();
            allHandValue3 = (cardsList[2]).toString().toLowerCase();
            allHandValue4 = (cardsList[3]).toString().toLowerCase();
            allHandValue5 = (cardsList[4]).toString().toLowerCase();
            allHandValue6 = (cardsList[5]).toString().toLowerCase();//for own hand
            allHandValue7 = (cardsList[6]).toString().toLowerCase();//for own hand
        }

    }

    int compareTo(Hand oneHand) {
        for (int x = 0; x <= 7; x++) {//was <=5
            if (this.cardVal [x] > oneHand.cardVal [x] ) {
                return 1;
            }
            else if (this.cardVal [x] < oneHand.cardVal [x] )
                return -1;
        }
        return 0;
    }
}
