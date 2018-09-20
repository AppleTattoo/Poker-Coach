package com.example.alex_.pokercoach;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alex_ on 26/04/2018.
 */

public class Deck  {
    public static ArrayList<SingleCard> cardsList;

    Deck() {
        cardsList = new ArrayList<SingleCard>();
        int index_1, index_2;
        Random randCard = new Random();
        SingleCard placehold;

        for (short x = 0; x <= 3; x++) {
            for (short y = 0; y <= 12; y++) {
                cardsList.add( new SingleCard(x, y) );
            }
        }

        int size = cardsList.size() -1;

        for (short i=0; i<100; i++) {
            index_1 = randCard.nextInt( size );
            index_2 = randCard.nextInt( size );

            placehold = (SingleCard) cardsList.get( index_2 );
            cardsList.set( index_2 , cardsList.get( index_1 ) );
            cardsList.set( index_1, placehold);
        }
    }

    public SingleCard drawFromDeck() {
        return cardsList.remove( cardsList.size()-1 );
    }

    public int getTotalCards() {
        return cardsList.size();
    }
}