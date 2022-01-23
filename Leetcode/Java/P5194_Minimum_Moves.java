package leetcode;

public class P5194_Minimum_Moves {
	
    public int minMoves(int target, int maxDoubles) {
    	if (target == 1) return 0;
    	if (target == 2) return 1;
    	int curr = target;
    	int moves = 0;
    	while (curr > 2) {
    		if (maxDoubles > 0) {
    			if (curr % 2 == 0) {
        			curr /= 2;
        			maxDoubles--;
    			} else {
    				curr--;
    			}
    			moves++;
    		} else {
    			moves += curr - 1;
    			curr = 1;
    			break;
    		}
    	}
    	if (curr == 2) {
    		moves++;
    	}
    	return moves;
    }
}