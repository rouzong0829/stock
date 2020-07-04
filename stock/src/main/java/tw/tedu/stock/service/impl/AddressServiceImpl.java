package tw.tedu.stock.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.tedu.stock.entity.Address;
import tw.tedu.stock.mapper.AddressMapper;
import tw.tedu.stock.service.IAddressService;
import tw.tedu.stock.service.exception.AccessDeniedException;
import tw.tedu.stock.service.exception.AddressNotFoundException;
import tw.tedu.stock.service.exception.DataEmptyException;
import tw.tedu.stock.service.exception.DataFormatException;
import tw.tedu.stock.service.exception.DeleteException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.service.exception.UserNotFoundException;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public Address create(String username, Address address) throws InsertException, DataFormatException, DataEmptyException {
		// 判斷是否有數據
		if(address.getName() == "" || address.getAddress() == "" || address.getTag() == ""){
			throw new DataEmptyException("資料尚未輸入完!");
		}
		// 判斷姓名格式
		if(address.getName().matches(".*\\d+.*")){
			throw new DataFormatException("姓名格式錯誤!");
		}
		if(address.getName().length() < 2){
			throw new DataFormatException("姓名格式錯誤!");
		}
		// 判斷郵遞區號格式
		if(!address.getZip().matches("\\d{5,6}")){
			throw new DataFormatException("郵遞區號格式錯誤!");
		}
		// 判斷手機號碼格式
		if(!address.getPhone().matches("\\d{4}-\\d{6}")){
			throw new DataFormatException("手機號碼格式錯誤!");
		}
		// 判斷家用電話格式
		if(!address.getTel().matches("\\d{2,4}-\\d{6,8}")){
			throw new DataFormatException("家用電話格式錯誤!");
		}
		// 判斷地址類型格式
		if(address.getTag().matches(".*\\d+.*")){
			throw new DataFormatException("地址類型格式錯誤!");
		}
		// 查詢該用戶的地址數量
		Integer count = getCountByUid(address.getUid());
		// 判斷數量是否設成默認
		address.setIsDefault(count == 0 ? 1 : 0);
		// 封裝日誌
		Date now = new Date();
		address.setCreatedUser(username);
		address.setCreatedTime(now);
		address.setModifiedUser(username);
		address.setModifiedTime(now);
		// 執行創建新地址
		addnew(address);
		return address;
	}
	
	@Override
	@Transactional
	public void setDefault(Integer id, Integer uid)
			throws UpdateException, AddressNotFoundException, AccessDeniedException {
		// 根據id查詢地址數據
		Address data = findById(id);
		// 判斷數據是否為null
		if(data == null){
			throw new AddressNotFoundException("設置默認地址失敗!嘗試訪問的地址數據不存在");
		}
		// 判斷查詢到的uid與參數uid是否一致
		if(data.getUid() != uid){
			throw new AccessDeniedException("設置默認地址失敗!訪問數據權限驗證不通過!");
		}
		
		// 將該用戶所有地址設為非默認
		updateNoDefault(uid);
		// 將指定id的地址設為默認
		updateDefault(id);
	}
	
	@Override
	public List<Address> getListByUid(Integer uid) {
		return findByUid(uid);	
	}
	
	@Override
	public Address getById(Integer id) {
		return findById(id);
	}
	
	@Override
	@Transactional
	public void delete(Integer uid, Integer id) throws DeleteException, UserNotFoundException, AccessDeniedException {
		// 根據id查詢地址數據
		Address data = findById(id);
		// 檢查數據是否為null
		if(data == null){
			throw new AddressNotFoundException("刪除失敗!該數據不存在!");
		}
		// 檢查數據歸屬是否有誤
		if(data.getUid() != uid){
			throw new AccessDeniedException("刪除失敗!不允許訪問此數據!");
		}
		// 執行刪除
		deleteById(id);
		
		// 檢查是否還有其他地址數據
		if(getCountByUid(uid) > 0){
			// 判斷剛才的是否為默認地址
			if(data.getIsDefault() == 1){
				// 獲取最後修改的地址
				Integer lastModifiedId = findLastModified(uid).getId();
				// 最後修改的地址設為默認
				setDefault(lastModifiedId, uid);
			}
		}
	}
	
	/**
	 * 增加新的地址
	 * @param address 地址數據
	 */
	private void addnew(Address address){
		Integer rows = addressMapper.addnew(address);
		if(rows != 1){
			throw new InsertException("增加地址數據時出現未知錯誤!");
		}
	}
	
	/**
	 * 將用戶的所有地址設為非默認
	 * @param uid 用戶id
	 */
	private void updateNoDefault(Integer uid){
		Integer rows = addressMapper.updateNoDefault(uid);
		if(rows < 1){
			throw new UpdateException("修改默認地址時出現未知錯誤!");
		}
	}
	
	/**
	 * 將指定id的地址設為默認
	 * @param id 數據id
	 */
	private void updateDefault(Integer id){
		Integer rows = addressMapper.updateDefault(id);
		if(rows != 1){
			throw new UpdateException("修改默認地址時出現未知錯誤!");
		}
	}
	
	/**
	 * 根據用戶id獲取該用戶的地址數據的數量
	 * @param uid 用戶id
	 * @return 該用戶的地址數據的數量，如果沒有數據，則返回0
	 */
	private Integer getCountByUid(Integer uid){
		return addressMapper.getCountByUid(uid);
	}
	
	/**
	 * 獲取某用戶的地址列表
	 * @param uid 用戶id
	 * @return 地址列表
	 */
	private List<Address> findByUid(Integer uid){
		return addressMapper.findByUid(uid);
	}
	
	/**
	 * 根據id查詢數據地址
	 * @param id 地址id
	 * @return 匹配的地址數據，如果沒有匹配的數據，則返回null
	 */
	private Address findById(Integer id){
		return addressMapper.findById(id);
	}
	
	/**
	 * 根據用戶id查詢最後修改的地址數據
	 * @param uid 用戶id
	 * @return 匹配的地址數據，如果沒有匹配的數據，則返回null
	 */
	private Address findLastModified(Integer uid){
		return addressMapper.findLastModified(uid);
	}
	
	/**
	 * 根據id刪除地址數據
	 * @param id 地址id
	 */
	private void deleteById(Integer id){
		Integer rows = addressMapper.deleteById(id);
		if(rows != 1){
			throw new DeleteException("刪除地址時出現未知錯誤!");
		}
	}
	
}
