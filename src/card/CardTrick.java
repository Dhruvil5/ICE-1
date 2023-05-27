/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Author:Dhruvil Prajapati
 * Student Number: 991711146
 * Description: A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card.
 */
package card;
import java.util.Scanner;

public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
         for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(RandNum());
            c.setSuit(Card.SUITS[RandNum(0, 3)]);
            magicHand[i] = c;
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of your card (0-13): ");
        int Value = scanner.nextInt();
        System.out.print("Enter the suit of the card (Heart-0,Diamond-1,Spade-2,Club-3) (0-3): ");
        int Suit = scanner.nextInt();
        
        Card myCard = new Card();
        myCard.setValue(Value);
        myCard.setSuit(Card.SUITS[Suit]);
        
        boolean isThere = search(magicHand, myCard);
        
        if (isThere) {
            System.out.println("Congratulations....Your card is in the magic hand. :)");
        } else {
            System.out.println("Sorry.....Your card is not in the magic hand. :(");
        }
    }
    
    private static int RandNum() {
        return (int) (Math.random() * 13) + 1;
    }
    
    private static int RandNum(int minimum, int maximum) {
        return (int) (Math.random() * (maximum - minimum + 1)) + minimum;
    }
    
    private static boolean search(Card[] hand, Card card) {
    for (Card handCard : hand) {
        boolean isEqual = handCard.equals(card);
        if (isEqual) {
            return true;
        }
    }
    return false;
}
}
    
