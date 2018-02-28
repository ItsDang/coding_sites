// Poor Pigs
// Difficulty:Easy

// There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

// Answer this question, and write an algorithm for the follow-up general case.

// Follow-up:

// If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.

// brute force is have each pig try it
// faster is have each pig try 1 bucket per minute in order, up to p-m minutes, so minimun number of pigs is ceil(n/(p-m)).
// so pig1 would try bucket 1->(p-m) pig2 would try bucket (p-m)+1->2(p-m)... ()+1->(n), 

// In the case of 1000, 15, 60: ceil(1000/(60-15)) = 23

// Seems faster to log it, spliting the buckets amoung the number of pigs, causing 1 to die each round
// up to p/m levels, though towards the end it's faster to have a single pig try

// Adding test comment for git
class Poor_Pigs {
    public static int numPigs(int buckets, int minutesToDie, int minutesToTest) {
    	int levels = minutesToTest/minutesToDie;
    	int pigs = 0;
    	int bucketsLeft = buckets;
    	// calculate buckets left before last level.
    	do {
    		// reset for new calculation
    		pigs++;
    		bucketsLeft = buckets;
    		// find out how many buckets left before last round.
    		for(int level = 1; level < levels; level++) {
    			// System.out.println(pigs - level + 2);
    			bucketsLeft = (int)Math.ceil(bucketsLeft * 1.0 / (level + pigs - 2));
    		}

    		// find out if last round can clear all remaining buckets, if not continue
    		// buckets left vs number of buckets a pig can check before times up times number of remaining pigs.
    	} while(bucketsLeft > (minutesToDie / 2) * (pigs + 1 - levels));
        return pigs;
    }
    public static void main(String args[]) {
    	int num = numPigs(2000,15,60);
    	System.out.println(num);
    }
}