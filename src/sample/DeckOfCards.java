package sample;

import javafx.scene.image.Image;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Richie
 */
public class DeckOfCards {
    private Stack<Card> deck;
    private Image backOfCardImage;

    //1. define the class
    //2. define the instance variables
    //3. create Constructor - this will define the object in the system
    //4. create get/set methods
    //5. create any custom methods


    /**
     * This is a 1 argument constructor that passes in a collection
     * of Card objects
     *
     * @param deck
     */
    public DeckOfCards(Stack<Card> deck) {
        this.deck = deck;
        backOfCardImage = new Image(new File("src/card/res/backOfCard.png").toURI().toString());

    }

    /**
     * This is a zero argument constructor that will build a full Deck of Cards
     */
    public DeckOfCards() {
        List<String> suits = Card.getValidSuits();
        //so we do NOT need an instance of Card
        //to call it
        List<String> faceNames = Card.getValidFaceNames();

        deck = new Stack<>();

        for (String suit : suits) {
            for (String faceName : faceNames)
                deck.add(new Card(faceName, suit));
        }
        backOfCardImage = new Image(new File("C:/Users/Coding/Desktop/cardDemo/src/images/backOfCard.png").toURI().toString());
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    public Image getBackOfCardImage() {
        return backOfCardImage;
    }

    public void setBackOfCardImage(Image backOfCardImage) {
        this.backOfCardImage = backOfCardImage;
    }

    public boolean isEmpty() {
        if (getDeck().size() == 0) {
            return true;
        } else return false;
    }

    /**
     * This method will "deal" the top card off the deck
     */
    public Card dealTopCard() {
        if (deck.size() > 0)
            return deck.pop();
        else
            return null;
    }

    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }
}
