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
--procedure getPrivsList
CREATE OR REPLACE PROCEDURE getPrivsList(
    p_privs OUT SYS_REFCURSOR
)
IS
BEGIN
    OPEN p_privs FOR
        SELECT grantee, privilege
        FROM dba_sys_privs;
END;
/
--procedure cap quyen
CREATE OR REPLACE PROCEDURE grant_permission(
  p_username IN VARCHAR2,
  p_privilege IN VARCHAR2
)
IS
BEGIN
  EXECUTE IMMEDIATE 'GRANT ' || p_privilege || ' TO ' || p_username;
END grant_permission;
/
--xem quyen cua user
CREATE OR REPLACE PROCEDURE view_user_permissions(
  p_username IN VARCHAR2,
  p_privileges OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN p_privileges FOR
    SELECT grantee, privilege
    FROM dba_sys_privs
    WHERE grantee = p_username;
END view_user_permissions;
/
--xoa quyen
CREATE OR REPLACE PROCEDURE revoke_user_privilege(
  p_username IN VARCHAR2,
  p_privilege IN VARCHAR2
)
IS
BEGIN
  EXECUTE IMMEDIATE 'REVOKE ' || p_privilege || ' FROM ' || p_username;
  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END revoke_user_privilege;
/
CREATE OR REPLACE PROCEDURE get_local_open_users(
  p_users OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN p_users FOR
    SELECT USERNAME
    FROM dba_users
    WHERE account_status = 'OPEN'
      AND common = 'NO';
END get_local_open_users;
/ 
    
    
    