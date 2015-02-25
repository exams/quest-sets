*--main.prg
SET TALK OFF
SET SAFE OFF
SET SYSMENU TO
SET STATUS OFF
SET STATUS BAR ON 
SET NOTIFY OFF
SET DEFAULT TO SYS(5)+SYS(2003)

*--全局变量定义
PUBL gcCaption,gcInfo,GcUserName

gcCaption='通用数卡录入系统'
gcInfo="　　欢迎使用  通用数卡录入系统　　　　　此接口由南昊公司软件部刘富强提供，联系电话：0318-8159516"
GcUserName = ""

*--程序是否已启动
DECLARE INTEGER FindWindow IN win32api STRING lpClassName ,STRING lpWindowName
winname=findwindow(NULL,gcCaption)
IF winname<>0
	= MESSAGEBOX('系统已启动！',48,'提示')
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
= WriteIni("option.ini","单位名称","Value","")

CLEAR DLLS

DO mainmenu.mpr

READ EVENTS
QUIT
