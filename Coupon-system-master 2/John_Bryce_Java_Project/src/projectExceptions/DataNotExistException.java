package projectExceptions;

/**
 * @author Alexander Logovinsky "AlexLogo"
 * @version 1.2.0 November 11, 2018.
 */
public class DataNotExistException extends Exception {

	/**
	 * constructs the exception and calling the super on the given parameter.
	 * 
	 * @param message
	 *            - the message to show when the exception is thrown.
	 */
	public DataNotExistException(String message) {

		super(message);
	}
}