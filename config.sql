-- phân quy�?n
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

GRANT CREATE TABLESPACE TO CHNONGSAN_NHANVIEN

GRANT EXECUTE ON CHNONGSAN.INSERTHANGHOA TO CHNONGSAN_NHANVIEN;
GRANT EXECUTE ON CHNONGSAN.UPDATEHANGHOA TO CHNONGSAN_NHANVIEN;

GRANT CREATE SESSION TO CUONG;
GRANT CREATE SESSION TO LINH;
GRANT CREATE SESSION TO MINH;
GRANT CREATE SESSION TO ADMIN;
GRANT SELECT ON DBA_USERS TO CUONG;
GRANT SELECT ON DBA_USERS TO LINH;
GRANT SELECT ON DBA_USERS TO MINH;
GRANT SELECT ON DBA_USERS TO ADMIN;

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

SELECT USERNAME, CREATED, EXPIRY_DATE, ACCOUNT_STATUS, LAST_LOGIN, PROFILE FROM DBA_USERS;
select * from dba_users
SELECT 
  USERNAME
FROM DBA_USERS
WHERE USERNAME LIKE 'CHNONGSAN%';
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
select * from all_tables where owner = 'CHNONGSAN';
select * from CHNONGSAN.nhanvien
SELECT policy_name, object_schema, object_name, policy_owner, SEL, INS, UPD, DEL, policy_column_options FROM dba_audit_policies; 
-- Thiết lập ít nhất 4 policy trên các bảng và các cột do sv tùy ch�?n phù hợp với đồ án
begin
dbms_fga.add_policy(
 policy_name => 'FGA_NHANVIEN',
 object_schema => 'CHNONGSAN',
 object_name => 'NHANVIEN', 
 
 statement_types => 'select,insert,update,delete'
);
end;

BEGIN
  DBMS_FGA.DROP_POLICY(
    object_schema => 'CHNONGSAN',
    object_name   => 'NHANVIEN',
    policy_name   => 'FGA_NHANVIEN'
  );
END;

-- xuất báo cáo quá trình audit dữ liệu của các policy co�? liên quan đã thiết lập
select timestamp, sql_text, db_user, object_schema, object_name, policy_name from dba_fga_audit_trail;
select * from dba_common_audit_trail
-- Hoặc
select SESSION_ID , timestamp, object_name, sql_text,extended_timestamp
from dba_fga_audit_trail;
-- Thiết lập audit liên quan đến một user nào đó.
AUDIT SELECT, INSERT, UPDATE, DELETE ON table_name BY user_name;
AUDIT CREATE SESSION BY CUONG;
NOAUDIT SELECT ON CHNONGSAN.HANGHOA BY CUONG;
SELECT *
FROM DBA_AUDIT_TRAIL
show parameter audit
SELECT *
FROM DBA_USERS
SELECT username FROM 

select * from CHNONGSAN.NhanVien

