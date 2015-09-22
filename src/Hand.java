import java.util.*;

/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 * 
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String c) {
        cards = new ArrayList<Card>();
        String split[] = c.split(" ");
        for (String s : split){
        	cards.add(new Card(s));
        }
    }
    
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
    	HashMap<Card.Rank, Integer> count = new HashMap<Card.Rank, Integer>();
    	for (Card c : cards){
    		if (!count.containsKey(c.getRank())){
    			count.put(c.getRank(), 0);
    		}
    		count.put(c.getRank(), count.get(c.getRank()) + 1);
    	}
    	for (Card.Rank r : count.keySet()){
    		if (count.get(r) == n){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
    	return false;
    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    public boolean isStraight() {
    	Collections.sort(cards);
    	
    	if (cards.get(cards.size() - 1).getRank().ordinal() - cards.get(0).getRank().ordinal() == 4){
    		return true;
    	}
    	if (cards.get(0).getRank().equals(Card.Rank.DEUCE) &&
    			cards.get(cards.size() - 1).getRank().equals(Card.Rank.ACE) && 
    			cards.get(cards.size() - 2).getRank().equals(Card.Rank.FIVE)){
    		return true;
    	}
    	return false;
    }
    
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
    	HashSet<Card.Suit> suits = new HashSet<Card.Suit>();
    	for (Card c : cards){
    		suits.add(c.getSuit());
    	}
    	return suits.size() == 1;
    }
    
    @Override
    public int compareTo(Hand h) {
        return this.kind().compareTo(h.kind());
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

    @Override
    public String toString(){
    	String s = "";
    	for (Card c : cards){
    		s += c.toString() + " ";
    	}
    	return s;
    }
}