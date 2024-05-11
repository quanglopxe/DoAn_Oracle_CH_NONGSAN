-- phân quyền
CREATE USER ADMIN IDENTIFIED BY "admin123";
CREATE USER CUONG IDENTIFIED BY "123";
CREATE USER LINH IDENTIFIED BY "123";
CREATE USER MINH IDENTIFIED BY "123";

CREATE ROLE CHNONGSAN_NHANVIEN;

GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.hanghoa TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.nhanvien TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.nhomhang TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.chitiethoadon TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.chitietphieunhap TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.hoadon TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.khachhang TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.phieunhap TO CHNONGSAN_NHANVIEN;
GRANT SELECT, INSERT, UPDATE, DELETE ON CHNongSan.nhacungcap TO CHNONGSAN_NHANVIEN;

GRANT EXECUTE ON CHNONGSAN.INSERTHANGHOA TO CHNONGSAN_NHANVIEN;
GRANT EXECUTE ON CHNONGSAN.UPDATEHANGHOA TO CHNONGSAN_NHANVIEN;

GRANT CREATE SESSION TO CUONG;
GRANT CREATE SESSION TO LINH;
GRANT CREATE SESSION TO MINH;
GRANT CREATE SESSION TO ADMIN;

GRANT CHNONGSAN_NHANVIEN TO CUONG;
GRANT CHNONGSAN_NHANVIEN TO LINH;
GRANT CHNONGSAN_NHANVIEN TO MINH;
GRANT CHNONGSAN_NHANVIEN TO ADMIN;

GRANT SYSDBA TO ADMIN;

SELECT granted_role 
FROM dba_role_privs
WHERE GRANTEE = 'CUONG';

SELECT *
FROM dba_tab_privs  
WHERE GRANTEE = 'CHNONGSAN_NHANVIEN';

-- Session 
-- đếm số session
select count(*) from v$session;
-- Xem thông tin cụ thể các session đang đăng nhập
SELECT s.sid, s.serial#, s.username, s.program from v$session s where type != 'BACKGROUND';
-- Xóa session
ALTER SYSTEM KILL SESSION 'sid,serial#' IMMEDIATE;
-- Xác định process ứng với session đang đăng nhập
select s.sid, s.serial#, p.spid, s.username, s.program from v$session s,
v$process p where p.addr=s.paddr and s.type!='BACKGROUND';

-- Audit, Policy
-- Kiểm tra các policy hiện có
select * from dba_audit_policies;
-- Thiết lập ít nhất 4 policy trên các bảng và các cột do sv tùy chọn phù hợp với đồ án
begin
dbms_fga.add_policy(
 object_schema=>'hr',
 object_name=>'countries',
 policy_name=>'fga_countries',
 statement_types=>'select, insert, update,delete'
);
end;
-- xuất báo cáo quá trình audit dữ liệu của các policy có liên quan đã thiết lập
select * from dba_fga_audit_trail;
-- Hoặc
select SESSION_ID , timestamp, object_name, sql_text,extended_timestamp
from dba_fga_audit_trail;
-- Thiết lập audit liên quan đến một user nào đó.
AUDIT SELECT, INSERT, UPDATE, DELETE ON table_name BY user_name;




