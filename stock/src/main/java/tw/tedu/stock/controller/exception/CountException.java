package tw.tedu.stock.controller.exception;

/**
 * 數量異常
 */
public class CountException extends RequestException {

	private static final long serialVersionUID = -5017246918795019195L;

	public CountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
