/**
 * LongestIncreasingSubseqRecursive.java
 * 
 * @author	Derek Brown <djb3718@rit.edu>
 * 
 * Purpose	A recursive implementation for finding the longest subsequence of
 * 			increasing numbers in an array
 */

import java.util.Scanner;

public class LongestIncreasingSubseqRecursive {
	
	// Attributes
	
	private int[] sequence;
	
	// Constructor
	
	/**
	 * Constructor for creating a LongestIncreasingSubseqRecursive instance
	 * 
	 * @param values	The values given by user
	 */
	public LongestIncreasingSubseqRecursive( int[] values ) {
		this.sequence = values;
	}//end LongestIncreasingSubseqRecursive constructor
	
	// Methods
	
	/**
	 * Implementation for recursive approach to finding the longest subsequence
	 * of increasing values
	 * 
	 * @param R		The object containing the array of values
	 * @param j		Recursion value
	 * 
	 * @return		The length of the longest subsequence
	 */
	public int LongestSubseqRecursive(LongestIncreasingSubseqRecursive R, int j ) {
		if( j < 0 ) {
			return 0;
		}//end if
		int k = j;

		while( R.sequence[j] <= R.sequence[k] ) {
			k--;
			if( k < 0 ) {
				break;
			}//end if
		}//end while
		int maxLength = Math.max( 1 + LongestSubseqRecursive( R, k ), LongestSubseqRecursive( R, j-1 ) );
		return maxLength;
	}//end LongestSubseqRecursive

	/**
	 * Reads in the data from the user and feeds the data into the algorithm,
	 * The algorithm then finds the length of the longest subsequence of 
	 * increasing values recursively, and then print the result
	 * 
	 * @param args	Command line arguments, unused.
	 */
	public static void main(String[] args) {
		// Read in values
		Scanner sc = new Scanner( System.in );
		String input = sc.next();
		int size = Integer.parseInt(input);
		int[] values = new int[size];
		for( int i = 0 ; i < size ; i++ ) {
			input = sc.next();
			int val = Integer.parseInt(input);
			values[i] = val;
		}//end for
		sc.close();
		LongestIncreasingSubseqRecursive R = new LongestIncreasingSubseqRecursive( values );
		int maxLength = R.LongestSubseqRecursive(R, size-1);
		if( maxLength != 4 ) {
			maxLength -= 4;
		}//end if
		System.out.println(maxLength);
	}//end main
}//end LongestIncreasingSubseqRecursive
