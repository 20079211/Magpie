/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
{
	/**
	 * Get a default greeting
	 * 
	 * @return a greeting
	 */
	public String getGreeting()
	{
    findKeyword("yesterday is today's day before.", "day", 0);
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		statement = statement.toLowerCase(); 
    // makes it easier to parse through strings with mixed-casing
		String response = "";
    if(!((statement.trim()).length()>0)) {
      response = "Say something, please.";
    }
    else if(findKeyword(statement, "shawver", 0) >= 0 || findKeyword(statement, "Shawver", 0) >= 0) {
      response = "She sounds like a great teacher!";
    }
		else if (findKeyword(statement, "mother", 0) >= 0
				|| findKeyword(statement, "father", 0) >= 0
				|| findKeyword(statement, "sister", 0) >= 0
				|| findKeyword(statement, "brother", 0) >= 0)
		{
			response = "Tell me more about your family.";
		}
    else if((findKeyword(statement, "dog", 0) >= 0) || findKeyword(statement, "cat", 0) >= 0) {
        response = "Tell me more about your pets.";
      }
    else if(findKeyword(statement, "how are you", 0) >=0) {
      response = "Fantastic. How about you?";
    }

    else if(findKeyword(statement, "sports", 0) >=0 || findKeyword(statement, "sport", 0) >=0) {
      response = "What are your favorite sports?";
    }
    else if(findKeyword(statement, "what is", 0) >=0 || findKeyword(statement, "why is", 0) >=0 || findKeyword(statement, "when was", 0) >=0 || findKeyword(statement, "who is", 0) >=0)
    {
      response = "I don't know... have you tried Google?";
    }
    else if (findKeyword(statement, "no", 0) >= 0) // Since a lot of words have 'no' in them, I believe that this is the least important keyword
		{
			response = "Why so negative?";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.toLowerCase().indexOf(
				goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn)
						.toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1)
						.toLowerCase();
			}
      
			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(),
					psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		// This code's if-logic was unnecessary considering it just pulls a random value.
    String[] responses = {"Interesting, tell me more.", "Hmmm.", "Do you really think so?", "You don't say.", "Wow... I never knew.", "Mhm, go on."}; 
    // Two additional responses
    // #1 Wow... I never knew.
    // #2 Mhm, go on.
		final int NUMBER_OF_RESPONSES = responses.length;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = responses[whichResponse];

		return response;
	}

}
