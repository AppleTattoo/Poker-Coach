package com.example.alex_.pokercoach;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class PlayScreen extends StartPageActivity {

    private Spinner deckSpinner;
    public StartPageActivity startVar = new StartPageActivity();
    private TextView tvCurrentHand;
    private View raise;
    private View fold;
    private View check;


    public Button cardTouch1;
    public Button cardTouch2;
    public Button cardTouch3;
    public Button cardTouch4;
    public Button cardTouch5;
    public Button cardTouch6;
    public Button cardTouch7;
    public ImageButton card1;
    public ImageButton card2;
    public ImageButton card3;
    public ImageButton card4;
    public ImageButton card5;
    public ImageButton card6;
    public ImageButton card7;

    public Bitmap ace_clubs;
    public Bitmap two_clubs;
    public Bitmap three_clubs;
    public Bitmap four_clubs;
    public Bitmap five_clubs;
    public Bitmap six_clubs;
    public Bitmap seven_clubs;
    public Bitmap eight_clubs;
    public Bitmap nine_clubs;
    public Bitmap ten_clubs;
    public Bitmap jack_clubs;
    public Bitmap queen_clubs;
    public Bitmap king_clubs;
    public Bitmap ace_spades;
    public Bitmap two_spades;
    public Bitmap three_spades;
    public Bitmap four_spades;
    public Bitmap five_spades;
    public Bitmap six_spades;
    public Bitmap seven_spades;
    public Bitmap eight_spades;
    public Bitmap nine_spades;
    public Bitmap ten_spades;
    public Bitmap jack_spades;
    public Bitmap queen_spades;
    public Bitmap king_spades;
    public Bitmap ace_diamonds;
    public Bitmap two_diamonds;
    public Bitmap three_diamonds;
    public Bitmap four_diamonds;
    public Bitmap five_diamonds;
    public Bitmap six_diamonds;
    public Bitmap seven_diamonds;
    public Bitmap eight_diamonds;
    public Bitmap nine_diamonds;
    public Bitmap ten_diamonds;
    public Bitmap jack_diamonds;
    public Bitmap queen_diamonds;
    public Bitmap king_diamonds;
    public Bitmap ace_hearts;
    public Bitmap two_hearts;
    public Bitmap three_hearts;
    public Bitmap four_hearts;
    public Bitmap five_hearts;
    public Bitmap six_hearts;
    public Bitmap seven_hearts;
    public Bitmap eight_hearts;
    public Bitmap nine_hearts;
    public Bitmap ten_hearts;
    public Bitmap jack_hearts;
    public Bitmap queen_hearts;
    public Bitmap king_hearts;

    public String tempCard1;
    public String tempCard2;
    public String tempCard3;
    public String tempCard4;
    public String tempCard5;
    public String tempCard6;
    public String tempCard7;
    public String card1Rank;
    public String card1Suit;
    public String card2Rank;
    public String card2Suit;
    public String card3Rank;
    public String card3Suit;
    public String card4Rank;
    public String card4Suit;
    public String card5Rank;
    public String card5Suit;
    public String card6Rank;
    public String card6Suit;
    public String card7Rank;
    public String card7Suit;
    public String[] parts1;
    public boolean allDrawn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ace_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ace_clubs);
        two_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_two_clubs);
        three_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_three_clubs);
        four_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_four_clubs);
        five_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_five_clubs);
        six_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_six_clubs);
        seven_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_seven_clubs);
        eight_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_eight_clubs);
        nine_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_nine_clubs);
        ten_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ten_clubs);
        jack_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_jack_clubs);
        queen_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_queen_clubs);
        king_clubs = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_king_clubs);
        ace_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ace_spades);
        two_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_two_spades);
        three_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_three_spades);
        four_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_four_spades);
        five_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_five_spades);
        six_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_six_spades);
        seven_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_seven_spades);
        eight_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_eight_spades);
        nine_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_nine_spades);
        ten_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ten_spades);
        jack_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_jack_spades);
        queen_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_queen_spades);
        king_spades = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_king_spades);
        ace_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ace_diamonds);
        two_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_two_diamonds);
        three_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_three_diamonds);
        four_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_four_diamonds);
        five_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_five_diamonds);
        six_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_six_diamonds);
        seven_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_seven_diamonds);
        eight_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_eight_diamonds);
        nine_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_nine_diamonds);
        ten_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ten_diamonds);
        jack_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_jack_diamonds);
        queen_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_queen_diamonds);
        king_diamonds = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_king_diamonds);
        ace_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ace_hearts);
        two_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_two_hearts);
        three_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_three_hearts);
        four_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_four_hearts);
        five_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_five_hearts);
        six_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_six_hearts);
        seven_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_seven_hearts);
        eight_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_eight_hearts);
        nine_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_nine_hearts);
        ten_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_ten_hearts);
        jack_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_jack_hearts);
        queen_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_queen_hearts);
        king_hearts = BitmapFactory.decodeResource(getResources(), R.drawable.onlineimageresize_com_king_hearts);

        cardTouch1 = (Button) findViewById(R.id.buttonCardTouch1);
        cardTouch2 = (Button) findViewById(R.id.buttonCardTouch2);
        cardTouch3 = (Button) findViewById(R.id.buttonCardTouch3);
        cardTouch4 = (Button) findViewById(R.id.buttonCardTouch4);
        cardTouch5 = (Button) findViewById(R.id.buttonCardTouch5);
        cardTouch6 = (Button) findViewById(R.id.buttonCardTouch6);
        cardTouch7 = (Button) findViewById(R.id.buttonCardTouch7);
        card1 = (ImageButton) findViewById(R.id.imageButtonC1);
        card2 = (ImageButton) findViewById(R.id.imageButtonC2);
        card3 = (ImageButton) findViewById(R.id.imageButtonC3);
        card4 = (ImageButton) findViewById(R.id.imageButtonC4);
        card5 = (ImageButton) findViewById(R.id.imageButtonC5);
        card6 = (ImageButton) findViewById(R.id.imageButtonC6);
        card7 = (ImageButton) findViewById(R.id.imageButtonC7);

        tvCurrentHand = (TextView) findViewById(R.id.tvCurrentHand);

        Deck deck = new Deck();
        SingleCard C;
        System.out.println(deck.getTotalCards());

        while (deck.getTotalCards() != 0) {
            C = deck.drawFromDeck();
            System.out.println(C.toString());
        }


        deck = new Deck();
        final Hand hand = new Hand(deck);
        Hand hand2 = new Hand(deck);
        System.out.println("Your hand is ");
        hand.display();
        hand.displayAll();
        System.out.println("Opponents hand is ");
        hand2.display();
        hand2.displayAll();
        System.out.println("HAND COMPARE " + hand.compareTo(hand2));
        if (hand != null || hand2 != null) {
            if ((hand.compareTo(hand2) == 1) && (allDrawn = true)) {
                tvCurrentHand.setText("You win with a " + Hand.handValue);
                hand.display();
            }
            else if ((hand.compareTo(hand2) == -1) && (allDrawn = true)) {
                tvCurrentHand.setText("Opponent wins with a " + Hand.handValue);
                hand2.display();
            }
            else if ((hand.compareTo(hand2) == 0) && (allDrawn = true)) {
                tvCurrentHand.setText("It's a draw, you both have a " + Hand.handValue);
            }
        } else {
            startActivity(new Intent(PlayScreen.this, StartPageActivity.class));
            Toast.makeText(PlayScreen.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {startActivity(new Intent(PlayScreen.this, StartPageActivity.class));
                }
            });

        tempCard1 = Hand.allHandValue1;
        tempCard2 = Hand.allHandValue2;
        tempCard3 = Hand.allHandValue3;
        tempCard4 = Hand.allHandValue4;
        tempCard5 = Hand.allHandValue5;
        tempCard6 = Hand.allHandValue6;
        tempCard7 = Hand.allHandValue7;

        parts1 = tempCard1.split(" of ");
        card1Rank = parts1[0];
        card1Suit = parts1[1];

        String[] parts2 = tempCard2.split(" of ");
        card2Rank = parts2[0];
        card2Suit = parts2[1];

        String[] parts3 = tempCard3.split(" of ");
        card3Rank = parts3[0];
        card3Suit = parts3[1];

        String[] parts4 = tempCard4.split(" of ");
        card4Rank = parts4[0];
        card4Suit = parts4[1];

        String[] parts5 = tempCard5.split(" of ");
        card5Rank = parts5[0];
        card5Suit = parts5[1];

        String[] parts6 = tempCard6.split(" of ");
        card6Rank = parts6[0];
        card6Suit = parts6[1];

        String[] parts7 = tempCard7.split(" of ");
        card7Rank = parts7[0];
        card7Suit = parts7[1];

    }

    public void onClick (View view) {
        int selectedCard = 1;
        if ((view == cardTouch1) && (selectedCard == 1)) {
            if (card1Suit.equals("clubs")) {
                switch (card1Rank) {
                    case "ace":
                        card1.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card1.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card1.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card1.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card1.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card1.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card1.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card1.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card1.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card1.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card1.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card1.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card1.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card1Suit.equals("spades")) {
                switch (card1Rank) {
                    case "ace":
                        card1.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card1.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card1.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card1.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card1.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card1.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card1.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card1.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card1.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card1.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card1.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card1.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card1.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card1Suit.equals("diamonds")) {
                switch (card1Rank) {
                    case "ace":
                        card1.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card1.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card1.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card1.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card1.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card1.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card1.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card1.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card1.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card1.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card1.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card1.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card1.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card1Suit.equals("hearts")) {
                switch (card1Rank) {
                    case "ace":
                        card1.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card1.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card1.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card1.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card1.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card1.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card1.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card1.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card1.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card1.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card1.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card1.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card1.setImageBitmap(king_hearts);
                        break;
                }

            }

        }
        selectedCard = selectedCard + 1;

        if ((view == cardTouch2) && (selectedCard == 2)) {
            if (card2Suit.equals("clubs")) {
                switch (card2Rank) {
                    case "ace":
                        card2.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card2.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card2.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card2.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card2.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card2.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card2.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card2.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card2.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card2.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card2.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card2.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card2.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card2Suit.equals("spades")) {
                switch (card2Rank) {
                    case "ace":
                        card2.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card2.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card2.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card2.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card2.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card2.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card2.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card2.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card2.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card2.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card2.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card2.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card2.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card2Suit.equals("diamonds")) {
                switch (card2Rank) {
                    case "ace":
                        card2.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card2.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card2.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card2.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card2.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card2.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card2.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card2.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card2.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card2.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card2.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card2.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card2.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card2Suit.equals("hearts")) {
                switch (card2Rank) {
                    case "ace":
                        card2.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card2.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card2.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card2.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card2.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card2.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card2.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card2.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card2.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card2.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card2.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card2.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card2.setImageBitmap(king_hearts);
                        break;
                }

            }

        }
        selectedCard = selectedCard + 1;

        if ((view == cardTouch3) && (selectedCard == 3)) {
            if (card3Suit.equals("clubs")) {
                switch (card3Rank) {
                    case "ace":
                        card3.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card3.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card3.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card3.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card3.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card3.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card3.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card3.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card3.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card3.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card3.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card3.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card3.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card3Suit.equals("spades")) {
                switch (card3Rank) {
                    case "ace":
                        card3.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card3.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card3.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card3.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card3.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card3.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card3.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card3.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card3.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card3.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card3.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card3.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card3.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card3Suit.equals("diamonds")) {
                switch (card3Rank) {
                    case "ace":
                        card3.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card3.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card3.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card3.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card3.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card3.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card3.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card3.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card3.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card3.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card3.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card3.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card3.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card3Suit.equals("hearts")) {
                switch (card3Rank) {
                    case "ace":
                        card3.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card3.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card3.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card3.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card3.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card3.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card3.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card3.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card3.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card3.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card3.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card3.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card3.setImageBitmap(king_hearts);
                        break;
                }

            }

        }
        selectedCard = selectedCard + 1;

        if (((view == cardTouch4)) && (selectedCard == 4)) {
            if (card4Suit.equals("clubs")) {
                switch (card4Rank) {
                    case "ace":
                        card4.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card4.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card4.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card4.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card4.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card4.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card4.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card4.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card4.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card4.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card4.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card4.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card4.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card4Suit.equals("spades")) {
                switch (card4Rank) {
                    case "ace":
                        card4.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card4.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card4.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card4.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card4.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card4.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card4.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card4.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card4.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card4.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card4.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card4.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card4.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card4Suit.equals("diamonds")) {
                switch (card4Rank) {
                    case "ace":
                        card4.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card4.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card4.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card4.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card4.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card4.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card4.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card4.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card4.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card4.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card4.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card4.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card4.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card4Suit.equals("hearts")) {
                switch (card4Rank) {
                    case "ace":
                        card4.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card4.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card4.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card4.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card4.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card4.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card4.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card4.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card4.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card4.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card4.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card4.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card4.setImageBitmap(king_hearts);
                        break;
                }

            }

        }
        selectedCard = selectedCard + 1;

        if (((view == cardTouch5)) && (selectedCard == 5)) {
            if (card5Suit.equals("clubs")) {
                switch (card5Rank) {
                    case "ace":
                        card5.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card5.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card5.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card5.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card5.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card5.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card5.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card5.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card5.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card5.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card5.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card5.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card5.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card5Suit.equals("spades")) {
                switch (card5Rank) {
                    case "ace":
                        card5.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card5.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card5.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card5.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card5.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card5.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card5.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card5.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card5.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card5.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card5.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card5.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card5.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card5Suit.equals("diamonds")) {
                switch (card5Rank) {
                    case "ace":
                        card5.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card5.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card5.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card5.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card5.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card5.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card5.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card5.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card5.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card5.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card5.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card5.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card5.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card5Suit.equals("hearts")) {
                switch (card5Rank) {
                    case "ace":
                        card5.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card5.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card5.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card5.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card5.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card5.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card5.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card5.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card5.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card5.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card5.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card5.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card5.setImageBitmap(king_hearts);
                        break;
                }

            }

        }
        selectedCard = selectedCard + 1;

        if ((view == cardTouch6) && (selectedCard == 6)) {
            if (card6Suit.equals("clubs")) {
                switch (card6Rank) {
                    case "ace":
                        card6.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card6.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card6.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card6.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card6.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card6.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card6.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card6.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card6.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card6.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card6.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card6.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card6.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card6Suit.equals("spades")) {
                switch (card6Rank) {
                    case "ace":
                        card6.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card6.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card6.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card6.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card6.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card6.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card6.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card6.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card6.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card6.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card6.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card6.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card6.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card6Suit.equals("diamonds")) {
                switch (card6Rank) {
                    case "ace":
                        card6.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card6.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card6.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card6.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card6.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card6.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card6.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card6.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card6.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card6.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card6.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card6.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card6.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card6Suit.equals("hearts")) {
                switch (card6Rank) {
                    case "ace":
                        card6.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card6.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card6.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card6.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card6.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card6.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card6.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card6.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card6.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card6.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card6.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card6.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card6.setImageBitmap(king_hearts);
                        break;
                }

            }

        }
        selectedCard = selectedCard + 1;

        if ((view == cardTouch7) && (selectedCard == 7)) {
            if (card7Suit.equals("clubs")) {
                switch (card7Rank) {
                    case "ace":
                        card7.setImageBitmap(ace_clubs);
                        break;
                    case "2":
                        card7.setImageBitmap(two_clubs);
                        break;
                    case "3":
                        card7.setImageBitmap(three_clubs);
                        break;
                    case "4":
                        card7.setImageBitmap(four_clubs);
                        break;
                    case "5":
                        card7.setImageBitmap(five_clubs);
                        break;
                    case "6":
                        card7.setImageBitmap(six_clubs);
                        break;
                    case "7":
                        card7.setImageBitmap(seven_clubs);
                        break;
                    case "8":
                        card7.setImageBitmap(eight_clubs);
                        break;
                    case "9":
                        card7.setImageBitmap(nine_clubs);
                        break;
                    case "10":
                        card7.setImageBitmap(ten_clubs);
                        break;
                    case "jack":
                        card7.setImageBitmap(jack_clubs);
                        break;
                    case "queen":
                        card7.setImageBitmap(queen_clubs);
                        break;
                    case "king":
                        card7.setImageBitmap(king_clubs);
                        break;
                }

            }

            if (card7Suit.equals("spades")) {
                switch (card7Rank) {
                    case "ace":
                        card7.setImageBitmap(ace_spades);
                        break;
                    case "2":
                        card7.setImageBitmap(two_spades);
                        break;
                    case "3":
                        card7.setImageBitmap(three_spades);
                        break;
                    case "4":
                        card7.setImageBitmap(four_spades);
                        break;
                    case "5":
                        card7.setImageBitmap(five_spades);
                        break;
                    case "6":
                        card7.setImageBitmap(six_spades);
                        break;
                    case "7":
                        card7.setImageBitmap(seven_spades);
                        break;
                    case "8":
                        card7.setImageBitmap(eight_spades);
                        break;
                    case "9":
                        card7.setImageBitmap(nine_spades);
                        break;
                    case "10":
                        card7.setImageBitmap(ten_spades);
                        break;
                    case "jack":
                        card7.setImageBitmap(jack_spades);
                        break;
                    case "queen":
                        card7.setImageBitmap(queen_spades);
                        break;
                    case "king":
                        card7.setImageBitmap(king_spades);
                        break;
                }

            }

            if (card7Suit.equals("diamonds")) {
                switch (card7Rank) {
                    case "ace":
                        card7.setImageBitmap(ace_diamonds);
                        break;
                    case "2":
                        card7.setImageBitmap(two_diamonds);
                        break;
                    case "3":
                        card7.setImageBitmap(three_diamonds);
                        break;
                    case "4":
                        card7.setImageBitmap(four_diamonds);
                        break;
                    case "5":
                        card7.setImageBitmap(five_diamonds);
                        break;
                    case "6":
                        card7.setImageBitmap(six_diamonds);
                        break;
                    case "7":
                        card7.setImageBitmap(seven_diamonds);
                        break;
                    case "8":
                        card7.setImageBitmap(eight_diamonds);
                        break;
                    case "9":
                        card7.setImageBitmap(nine_diamonds);
                        break;
                    case "10":
                        card7.setImageBitmap(ten_diamonds);
                        break;
                    case "jack":
                        card7.setImageBitmap(jack_diamonds);
                        break;
                    case "queen":
                        card7.setImageBitmap(queen_diamonds);
                        break;
                    case "king":
                        card7.setImageBitmap(king_diamonds);
                        break;
                }

            }


            if (card7Suit.equals("hearts")) {
                switch (card7Rank) {
                    case "ace":
                        card7.setImageBitmap(ace_hearts);
                        break;
                    case "2":
                        card7.setImageBitmap(two_hearts);
                        break;
                    case "3":
                        card7.setImageBitmap(three_hearts);
                        break;
                    case "4":
                        card7.setImageBitmap(four_hearts);
                        break;
                    case "5":
                        card7.setImageBitmap(five_hearts);
                        break;
                    case "6":
                        card7.setImageBitmap(six_hearts);
                        break;
                    case "7":
                        card7.setImageBitmap(seven_hearts);
                        break;
                    case "8":
                        card7.setImageBitmap(eight_hearts);
                        break;
                    case "9":
                        card7.setImageBitmap(nine_hearts);
                        break;
                    case "10":
                        card7.setImageBitmap(ten_hearts);
                        break;
                    case "jack":
                        card7.setImageBitmap(jack_hearts);
                        break;
                    case "queen":
                        card7.setImageBitmap(queen_hearts);
                        break;
                    case "king":
                        card7.setImageBitmap(king_hearts);
                        break;
                }

            }
            allDrawn = true;
        }
    }
}
