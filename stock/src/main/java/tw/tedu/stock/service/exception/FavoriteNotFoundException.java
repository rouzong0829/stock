package tw.tedu.stock.service.exception;

/**
 * 查詢不到收藏數據異常
 */
public class FavoriteNotFoundException extends ServiceException {

	private static final long serialVersionUID = -2367298062776169421L;

	public FavoriteNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavoriteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FavoriteNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FavoriteNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FavoriteNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
