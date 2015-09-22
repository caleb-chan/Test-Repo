import java.util.*;
/**
 * Poker distributes the hands and can determine the winner
 * 
 * @author babak 
 * @version 0.0
 */
public class Poker {

    private Collection<Hand> hands;

    /**
     * Create a new game of poker (empty at first)
     */
    public Poker(){
        hands = new ArrayList<Hand>();
    }

    /**
     * Add a new hand
     */
    public void addHand(Hand h) {
        hands.add(h);
    }
    
    /**
     * @return the best hand 
     */
    public Hand bestHand(){
       return Collections.max(hands);
    }
    
    @Override
    public String toString(){
    	String s = "";
    	for (Hand h : hands){
    		s += h.toString() + " --> " + h.kind().toString() + "\n";
    	}
    	return s;
    }
    
    public static void main(String args[]){
    	Poker p = new Poker();
    	p.addHand(new Hand("AS 2D 3D 4H 5H"));
    	p.addHand(new Hand("AC 5C 6C 7C 8C"));
    	p.addHand(new Hand("AH AH AH 5C 4C"));
    	p.addHand(new Hand("4S 4S 4S 4S 6S"));
    	
    	System.out.println("Hands : \n" + p.toString());
    	
    	System.out.println("Best hand : " + p.bestHand().toString() + " --> " + p.bestHand().kind().toString());
    }
}