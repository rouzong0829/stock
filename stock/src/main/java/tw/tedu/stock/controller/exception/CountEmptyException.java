package tw.tedu.stock.controller.exception;

/**
 * 數量為空的異常
 */
public class CountEmptyException extends RequestException {

	private static final long serialVersionUID = 6129472601918984427L;

	public CountEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CountEmptyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CountEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CountEmptyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
