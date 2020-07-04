package tw.tedu.stock.util;

import java.io.Serializable;

/**
 * 服務器端向客戶端響應結果的類型
 * 
 * @param <T> 服務器端向客戶端響應數據的類型
 */
public class ResponseResult<T> implements Serializable {
	
	private static final long serialVersionUID = 753161940416494352L;
	
	private Integer state;
	private String message;
	private T data;
	
	// 無參數構造方法
	public ResponseResult() {
		super();
	}
	
	// 構造方法 : 表示操作成功
	public ResponseResult(Integer state) {
		super();
		setState(state);
	}
	
	// 構造方法 : 表示操作失敗
	public ResponseResult(Integer state, String message) {
		this(state);
		setMessage(message);
	}
	
	// 構造方法 : 表示操作失敗
	public ResponseResult(Integer state, Exception e) {
		this(state, e.getMessage());
	}
	
	// 構造方法 : 表示用戶請求數據成功時
	public ResponseResult(Integer state, T data) {
		this(state);
		setData(data);
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}
