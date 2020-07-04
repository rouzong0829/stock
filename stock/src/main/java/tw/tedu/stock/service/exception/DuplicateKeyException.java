package tw.tedu.stock.service.exception;

/**
 * 違反了Unique約束的異常
 */
public class DuplicateKeyException extends ServiceException {

	private static final long serialVersionUID = 6528233922885308732L;

	public DuplicateKeyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuplicateKeyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateKeyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateKeyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
