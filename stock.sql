DROP DATABASE IF EXISTS tedu_stock;

CREATE DATABASE tedu_stock;

USE tedu_stock;

DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user(
	id INT AUTO_INCREMENT COMMENT 'id',
	username VARCHAR(20) UNIQUE NOT NULL COMMENT '用戶名',
	password CHAR(32) NOT NULL COMMENT '密碼',
	salt CHAR(36) NOT NULL COMMENT '鹽值',
	gender INT COMMENT '性別',
	phone VARCHAR(20) COMMENT '手機號碼',
	email VARCHAR(50) COMMENT '電子郵箱',
	avatar VARCHAR(100) COMMENT '頭像',
	is_delete INT DEFAULT 0 COMMENT '是否刪除,0-未刪除,1-已刪除',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY(id)
)DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_address;

CREATE TABLE t_address (
	id INT AUTO_INCREMENT COMMENT 'id',
	uid INT NOT NULL COMMENT '數據歸屬的用戶id',
	name VARCHAR(20) COMMENT '收貨人',
	zip CHAR(6) COMMENT '郵遞區號',
	address VARCHAR(50) COMMENT '詳細地址',
	phone VARCHAR(20) COMMENT '手機',
	tel VARCHAR(20) COMMENT '家用電話',
	tag VARCHAR(10) COMMENT '標籤',
	is_default INT COMMENT '是否默認，0-非默認，1-默認',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_goods_category;

CREATE TABLE t_goods_category (
  	id INT AUTO_INCREMENT COMMENT 'id',
	name VARCHAR(30) COMMENT '名稱',
	status INT DEFAULT '0' COMMENT '狀態,0-未刪除,1-已刪除',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_goods;

CREATE TABLE t_goods (
	id INT AUTO_INCREMENT COMMENT '商品id',
	category_id INT COMMENT '分類id',
	code VARCHAR(20) COMMENT '商品代號',
	stock VARCHAR(30) COMMENT '商品名稱',
	main_business VARCHAR(100) COMMENT '主要業務',
	price DOUBLE COMMENT '價錢',
	volume BIGINT COMMENT '交易量',
	status INT DEFAULT '0' COMMENT '狀態,0-未刪除,1-已刪除',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY(id)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_favorite;

CREATE TABLE t_favorite (
	id INT AUTO_INCREMENT COMMENT '收藏id',
	uid INT NOT NULL COMMENT '用戶id',
	gid INT NOT NULL COMMENT '商品id',
	price DOUBLE COMMENT '價錢',
	volume BIGINT COMMENT '交易量',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY (id)
)  DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_order;

CREATE TABLE t_order(
	id INT AUTO_INCREMENT COMMENT 'id',
	uid INT COMMENT '數據歸屬用戶id',
	recv_name VARCHAR(20) COMMENT '收貨人姓名',
	recv_address VARCHAR(50) COMMENT '詳細地址',
	pay BIGINT COMMENT '支付金額',
	buy_sell INT COMMENT '0-買,1-賣',
	order_time DATETIME COMMENT '下單時間',
	status INT COMMENT '訂單狀態:0-未支付,1-已支付,2-已取消',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY (id)
) DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_order_item;

CREATE TABLE t_order_item(
	id INT AUTO_INCREMENT COMMENT 'id',
	oid INT COMMENT '歸屬訂單的id',
	goods_id INT COMMENT '商品id',
	goods_code VARCHAR(20) COMMENT '商品代號',
	goods_stock VARCHAR(30) COMMENT '商品名稱',
	goods_count INT COMMENT '商品數量',
	goods_price DOUBLE COMMENT '商品價錢',
	created_user VARCHAR(20) COMMENT '創建者',
	created_time DATETIME COMMENT '創建時間',
	modified_user VARCHAR(20) COMMENT '最後修改者',
	modified_time DATETIME COMMENT '最後修改時間',
	PRIMARY KEY (id)
) DEFAULT CHARSET=UTF8;

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'半導體業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'其他電子業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'通信網路業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'油電燃氣業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'光電業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'塑膠工業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'金融保險業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'食品工業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'電子零組件業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'鋼鐵工業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'汽車工業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'貿易百貨'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'電腦及週邊設備業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'水泥工業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'電子零組件業'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'其他'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'紡織纖維'
	);

	INSERT INTO t_goods_category(
		name
	)VALUES(
		'橡膠工業'
	);



	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 2330, '台積電', '	依客戶之訂單與其提供之產品設計說明，以從事製造與銷售積體電路
以及其他晶圓半導體裝置。提供前述產品之封裝與測試服務、積體電
路之電腦輔助設計技術服務。提供製造光罩及其設計服務。', 270.00, 156269
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		2, 2317, '鴻海', '電腦系統設備及其週邊之連接器等。
線纜組件及殼體,基座之開發、設計、製造及銷售等。
精密模具之製造及銷售等。', 70.80, 102192
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		3, 2412, '中華電', '第一、二類電信事業', 106.50, 24622
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		4, 6505, '台塑化', '石油化工原料製造業(C801020)、
基本化學工業製造業(C801010)', 71.50, 7600
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		5, 3008, '大立光', '各式光學鏡頭模組、
觀景器模組與光電零組件、
以上產品之研發設計生產銷售與技術服務等', 3575.00, 1512
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		6, 1301, '台塑', '聚氯乙烯(PVC)、氯乙烯、液(石咸)、聚丙烯、高密度聚乙烯;
聚乙烯醋酸乙烯酯、低密度聚乙烯、線性低密度聚乙烯、丙烯酸酯;
高吸水性樹脂、碳素纖維、丙烯睛、甲基丙烯酸甲酯及環氧氯丙烷等', 68.80, 27086
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 2454, '聯發科', '多媒體IC 、電腦週邊IC、高階消費性IC、其他特殊應用IC', 301.00, 17020
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		6, 1303, '南亞', '各種塑膠加工品、塑膠原料、電子材料、聚酯纖維之製銷
及染整加工 、配電盤', 50.10, 25669
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2882, '國泰金', '投資、
管理', 35.10, 46149
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		6, 1326, '台化', '純對苯二甲酸、聚苯乙烯、苯乙烯、鄰二甲苯、對二甲苯、苯、
合成酚、丙酮、聚丙烯、二甲基甲醯胺、ABS、嫘縈棉、
合成纖維紗、布、耐隆絲、耐隆絲布及其染整加工等製銷', 65.10, 18232
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2881, '富邦金', '金融控股公司業', 37.50, 44058
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2891, '中信金', '投資金融相關事業、
經主管機關核准辦理之其他有關業務', 17.10, 131755
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2886, '兆豐金', '金融控股公司業', 27.95, 62993
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		8, 1216, '統一', '食品事業、便利商店事業、流通事業，
包裝容器事業、食糧事業、油品事業，
其他(製藥事業、休閒開發事業、物流事業等)。', 65.00, 24670
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		3, 3045, '台灣大', '通訊業', 99.90, 12581
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		9, 2308, '台達電', '電源供應系統、無刷直流風扇、散熱系統、微型化關鍵零組件，
工業自動化、視訊顯示、資訊、網路通訊、消費性電子、節能照明，
電動車充電設備、能源技術服務及智慧樓宇管理與控制解決方案。', 117.50, 13600
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		10, 2002, '中鋼', '鋼品設計製造買賣儲運及其他相關業務(含輕金屬,尖端材料)。
鋼廠之籌建。
鋼鐵及相關工業之工程顧問管理資詢。', 19.80, 52612
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		11, 2207, '和泰車', '各種車輛、車輛用冷暖氣機及其零件之裝配、買賣、修理、保養及進出口業務。', 368.00, 1686
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2884, '玉山金', '金融控股公司業', 22.00, 186036
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 3711, '日月光投控', 'H201010 一般投資業', 54.20, 28973
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		12, 2912, '統一超', '超級商店之經營;煙酒.家庭用品之零售', 281.00, 3614
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2892, '第一金', '金融控股公司業', 18.65, 68917
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 5880, '合庫金', '金融控股公司業', 17.40, 60123
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2880, '華南金', '金融控股公司業、
投資經主管機關核准之事業、
對被投資事業之管理', 17.65, 54773
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		13, 2382, '廣達', '電子、筆記型電腦及相關產品', 54.80, 17781
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 2408, '南亞科', '電子零組件製造業、
國際貿易業、
其他顧問服務業', 48.65, 29838
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2801, '彰銀', '存、放款、外匯及其他銀行業可辦業務', 18.70, 24111
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		14, 1101, '台泥', '有關水泥及水泥製品之生產及運銷。
有關水泥原料及水泥製品原料之開採製造運銷及附屬礦石之開採經銷。
經營有關水泥工業及其附屬事業。', 36.95, 32760
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 5876, '上海商銀', '商業銀行業(經目的事業主管機關核准營業項目為限)', 37.45, 13999
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2885, '元大金', '金融控股公司業', 15.25, 60752
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		3, 4904, '遠傳', '行動電話業務、行動電話手機及其零配件之買賣及裝修業務', 62.00, 8839
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		13, 2395, '研華', '工業測控產品。
工業用電腦/工業用工作站。
嵌入式電腦卡/超薄液晶電腦。', 240.50, 2151
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		2, 2474, '可成', '機殼及內構件各式相關產品之生產、銷售與開發。', 188.00, 8216
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 2303, '聯電', '積體電路、各種半導體相關零組件', 13.85, 156999
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		15, 2327, '國巨', '被動元件、電阻原料半成品。
天線、主動元件。
機器設備、零件製造及銷售。', 252.00, 25187
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		13, 4938, '和碩', '電信管制射頻器材製造業。
電信管制射頻器材輸入業。
除許可業務外，得經營法令非禁止或限制之業務。', 51.80, 12589
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		13, 2357, '華碩', '3C 資訊產品(含電腦系統產品、主機板及各類板卡、平板電腦
及智慧型手機等手持裝置等)之設計、研發及銷售', 175.00, 6160
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		16, 5871, '中租-KY', '租賃業務、
分期付款買賣、
融資及應收帳款收買暨管理業務', 85.40, 14489
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2887, '台新金', '金融控股公司業', 10.85, 84653
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		17, 1402, '遠東新', '石化纖維原料、半成品及製成品。
纖維紗(布)、混紡紗(布)、假撚絲、棉布、被單。
紡織成衣、針織成衣。', 21.85, 18830
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		14, 1102, '亞泥', '水泥,水泥之半成品,水泥製品,預拌混凝土及其添加劑之生產運銷。
水泥原料,水泥製品原料及砂石開採及爐石粉,石灰石粉之製造運銷。
其他未述及之項目請參照本公司營業執照之所營事業。', 39.20, 13751
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2890, '永豐金', '	本公司得投資下列事業：銀行業、票券金融業、信用卡業、信託業、
保險業、證券業、期貨業、創業投資事業、經主管機關核准投資之外
國金融機構、其他經主管機關認定與金融業相關之事業。', 10.60, 55584
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2883, '開發金', '投資及被投資公司之管理', 7.35, 72557
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		18, 2105, '正新', '輪胎橡膠製品等', 30.25, 10928
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		13, 6669, '緯穎', '資料中心產品', 611.00, 3730
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		16, 9910, '豐泰', '製鞋、機械設備製造、模具製造、
產品設計、國際貿易、企業經營管理顧問。
除許可業務外，得經營法令非禁止或限制之業務。', 123.00, 2818
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 3034, '聯詠', '研究、開發、製造、銷售下列產品:A.通訊積體電路B.內嵌式微控制器C.數位訊號處理器D.電腦週邊控制積體電路E.液晶顯示器驅動積體電路及系統', 152.00, 14637
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2888, '新光金', 'H801011金融控股公司業', 7.34, 113278
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		1, 2379, '瑞昱', '研究開發生產、製造、銷售各種積體電路', 171.00, 6830
	);

	INSERT INTO t_goods(
		category_id, code, stock, main_business, price, volume
	)VALUES(
		7, 2823, '中壽', '人身保險', 15.75, 28979
	);
