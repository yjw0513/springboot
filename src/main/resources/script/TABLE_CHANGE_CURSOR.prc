
CREATE OR REPLACE Type EMP_Record Is Object(EMPNO Varchar2(30),ENAME Varchar2(30));

CREATE OR REPLACE Type emp_Table Is Table Of EMP_Record;


CREATE OR REPLACE Procedure TABLE_CHANGE_CURSOR(retcur out Sys_refcursor)
Is
datatab EMP_Table := EMP_Table();
Begin
 --�����������������ݵķ���
 --Bulk collect ����ѯ ����ѯ���һ���Եؼ��ص�collections��
 --select into,fetch into,returning into �������ʹ��
 --ע������ķ�ʽ
Select EMP_RECORD(EMPNO,ENAME) Bulk collect into datatab From EMP;
--���α귵������
Open retcur For select * from table(datatab);

End TABLE_CHANGE_CURSOR;
/
