
CREATE OR REPLACE Type EMP_Record Is Object(EMPNO Varchar2(30),ENAME Varchar2(30));

CREATE OR REPLACE Type emp_Table Is Table Of EMP_Record;


CREATE OR REPLACE Procedure TABLE_CHANGE_CURSOR(retcur out Sys_refcursor)
Is
datatab EMP_Table := EMP_Table();
Begin
 --下面是批量插入数据的方法
 --Bulk collect 批查询 将查询结果一次性地加载到collections中
 --select into,fetch into,returning into 等语句中使用
 --注意这里的方式
Select EMP_RECORD(EMPNO,ENAME) Bulk collect into datatab From EMP;
--打开游标返回数据
Open retcur For select * from table(datatab);

End TABLE_CHANGE_CURSOR;
/
