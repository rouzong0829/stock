package tw.tedu.stock.service.exception;

/**
 * 數據為空異常
 */
public class DataEmptyException extends ServiceException {

	private static final long serialVersionUID = -5168985782745606894L;

	public DataEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataEmptyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataEmptyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
