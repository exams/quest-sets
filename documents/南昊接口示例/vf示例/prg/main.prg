*--main.prg
SET TALK OFF
SET SAFE OFF
SET SYSMENU TO
SET STATUS OFF
SET STATUS BAR ON 
SET NOTIFY OFF
SET DEFAULT TO SYS(5)+SYS(2003)

*--ȫ�ֱ�������
PUBL gcCaption,gcInfo,GcUserName

gcCaption='ͨ������¼��ϵͳ'
gcInfo="������ӭʹ��  ͨ������¼��ϵͳ�����������˽ӿ�����껹�˾���������ǿ�ṩ����ϵ�绰��0318-8159516"
GcUserName = ""

*--�����Ƿ�������
DECLARE INTEGER FindWindow IN win32api STRING lpClassName ,STRING lpWindowName
winname=findwindow(NULL,gcCaption)
IF winname<>0
	= MESSAGEBOX('ϵͳ��������',48,'��ʾ')
	QUIT
ENDIF

_SCREEN.LOCKSCREEN = .T.
_SCREEN.WINDOWSTATE=2
_SCREEN.CLOSABLE = .F.
_SCREEN.MAXBUTTON = .F.
_SCREEN.MINBUTTON = .T.
_SCREEN.MOVABLE = .F.
_SCREEN.CAPTION = gcCaption
_SCREEN.ICON='.\ico\topic.ico'
_SCREEN.ADDOBJECT('fengm','image')
_SCREEN.FENGM.HEIGHT = _SCREEN.HEIGHT
_SCREEN.FENGM.WIDTH =_SCREEN.WIDTH
_SCREEN.FENGM.TOP = 0
_SCREEN.FENGM.LEFT = 0
_SCREEN.FENGM.STRETCH = 2

USE .\data\piclib
lcpic=ALLT(picname)
_SCREEN.FENGM.PICTURE=lcpic
SELE piclib
USE

_SCREEN.FENGM.VISIBLE = .T.
_SCREEN.LOCKSCREEN = .F.

SET MESSAGE TO gcInfo
SET PROC TO prg\mysubsproc
= WriteIni("option.ini","��λ����","Value","")

CLEAR DLLS

DO mainmenu.mpr

READ EVENTS
QUIT
