*mysubsproc.prg
*-- ===============================================================
*!!* 自定义函数完成常用的一些功能*!!*
*!!* 刘富强　　于2003年11月6日
*-- ===============================================================

*-- ===============================================================
*-- 显示 wait 信息
*-- ===============================================================
FUNC ShowWait
	PARA wait_info,wait_second
	LOCAL lcWaitMode
	IF EMPTY(wait_info)
		WAIT CLEAR
		RETU
	ENDIF
	IF TYPE("wait_info") <> "C"
		wait_info = "请等待..."
	ENDIF
	IF TYPE("wait_second") <> "N"
		lcWaitMode = "nowait"
	ELSE
		lcWaitMode = "timeout "+ALLT(STR(wait_second))
	ENDIF
	SET MESSAGE TO wait_info
*-- wait window wait_info &lcWaitMode
*-- 使提示的信息居中
	lcInfoCaption = "          === 提示信息 ===          "
	lnInfoLen	= LEN(lcInfoCaption)
	lnWaitInfo	= LEN(wait_info)
	IF	lnInfoLen	>	lnWaitInfo
		lcAddCaption	= ""
		lcAddWaitInfo	= REPL(" ",(lnInfoLen-lnWaitInfo)/2)
	ELSE
		lcAddCaption	= REPL(" ",(lnWaitInfo-lnInfoLen)/2)
		lcAddWaitInfo	= ""
	ENDIF

	WAIT WINDOW lcAddCaption + lcInfoCaption ;
		+CHR(13)+CHR(13)+ ;
		lcAddWaitInfo + wait_info ;
		AT ;
		SYSMETRIC(2)/17/2 - 4 ,;
		SYSMETRIC(1)/6.4/2-IIF(lnWaitInfo>lnInfoLen,lnWaitInfo,lnInfoLen)/2 ;
		&lcWaitMode
	RETU
*-- ===============================================================

*-- ===============================================================
*-- 调用方式：=zymc(tczydm)
FUNC zymc
	PARA tcZydm
	lcZydm=ALLT(tcZydm)
	SELE zyjc FROM sysdbf\zyzd.DBF WHERE ALLT(zydm)=lcZydm INTO ARRAY laZytmp
	IF _TALLY=0
		RETU ''
	ELSE
		RETU laZytmp(1)
	ENDIF

*-- ===============================================================
*-- 将一个数字前面补零
FUNC AddZero
*-- ===============================================================
	PARA tcOldChar,tnMaxLen

	IF	LEN(ALLT(tcOldChar)) < tnMaxLen AND !EMPTY(tcOldChar)
		tcOldChar=REPL('0',tnMaxLen-LEN(ALLT(tcOldChar)) ) + ALLT(tcOldChar)
	ENDIF

	RETU tcOldChar

*-- ===============================================================
*-- ===============================================================
*程序名称：AutoAddOne.prg
*程序功能：给字符串中含有数字的部分+1
*使用方法：AutoAddOne(cCode,nLen)
*变量说明：cCode是要转换的字符串；nLen是字符串中数字的宽度
*程序说明：许多时候我们需要对字符型数据进行编号的自动累加， 象000001，ABC0001，X-001
*          等格式，处理这些数据的关键是针对字符串中数字一段的部分进行累加计算，并给
*          出空缺的数字高位上的0，即必须前导0。
*-- ===============================================================
* 程序清单：
FUNC AutoAddOne
	PARA cCode,nLen
	PRIV cRightCode,cLeftCode,cNewCode,n0
*cRightCode 为字符串中右边数字部分
*cLeftCode 为字符串中左边的不参与运算的部分，一般为字母
*cNewCode 程序中运算得到的新的数据
*n0 即前导0的个数。
	cCode=RTRIM(cCode)
	cRightCode=RIGHT(cCode,nLen)
	cLeftCode=LEFT(cCode,LEN(cCode)-nLen)
	IF LEN(cRightCode)<nLen
		MESSAGEBOX("自动增加的字符宽度("+ALLT(STR(LEN(cRightCode)))+")小于设定的宽度("+ALLT(STR(nLen))+")！",16,"警告")
		RETU ""
	ENDIF
	cNewCode=ALLT(STR(VAL(cRightCode)+1))
	n0=nLen-LEN(cNewCode)
	IF n0>=0
		cNewCode=REPL('0',n0)+cNewCode
	ELSE
		MESSAGEBOX("字符宽度已超出了预先设定的最大值("+REPL('9',nLen)+")！",16,"警告")
		RETU ""
	ENDIF
	cCode=cLeftCode+cNewCode
	RETU	cCode
*-- ===============================================================
*-- ===============================================================
*-- 关闭数据表函数
*-- ===============================================================
FUNC CloseDB
	PARA db_name   &&字符型
	IF USED("&db_name")
		SELE "&db_name"
		USE
	ENDIF
	RETU
*-- ===============================================================
*-- ===============================================================
*-- 打开连接
*-- ===============================================================
FUNC OpenURL
	PARA cURL

	DECLARE INTEGER ShellExecute ;
		IN SHELL32.DLL ;
		INTEGER nWinHandle,;
		STRING cOperation,;
		STRING cFileName,;
		STRING cParameters,;
		STRING cDirectory,;
		INTEGER nShowWindow
	RETURN shellexecute(0,"open","&cURL","","",1)
*-- ===============================================================
*-- ===============================================================
*-- 文章标题：让程序自动去完成MSGBOX的确认操作
*-- 程序说明：建立一个MESSAGEBOX对话框，当没有用户去响应时，自动在一定时间内响应回车事件
*-- 原作：Matt Weinbender SoftServ, Inc. 5/3/2000
*-- 由红虎简化该程序
*-- 使用： ?MsgBoxTmr("对话框信息","对话框标题",按纽类型(参考messagebox()帮助),等待时间(单位:秒))
*-- 返回： 同messagebox()一样
*-- 注意： 如果在 VFP5 中运行，需要 FoxTools.FLL
*--        如果在 VFP6 中，就无需了。
*------------------------------------------------------------------
*-- ===============================================================
FUNCTION MsgBoxTmr
*-- 接受参数，最多4个
	LPARAMETERS lcMsgText, lcMsgTitle, lnButtons, lnWaitSecs

*-- 检查传递的参数
*-- 等待时间必须大于等于0，如果等于0，为不等待
	IF TYPE("lnWaitSecs") # "N"
		lnWaitSecs = 0
	ELSE
		IF lnWaitSecs < 0
			lnWaitSecs = 0
		ENDIF
	ENDIF
*-- 按纽类型为，0,1,1+16,2+32+256...等形式
	IF TYPE("lnButtons") # "N"
		lnButtons	= 0
	ENDIF
*-- 标题为字符，默认用主窗口标题
	IF TYPE("lcMsgTitle") # "C"
		lcMsgTitle = _SCREEN.CAPTION
	ENDIF
*-- 信息内容为字符
	IF TYPE("lcMsgText") # "C"
		lcMsgText  = "无提示信息"
	ENDIF

*-- 创建时钟对象
*!*		showwait("自动确认对话框...",1)
*!*		do form test_auto_msg with lnWaitSecs
*!*		do definetimer
	ofrmLeftTime = CREATEOBJECT('frmLeftTime',lnWaitSecs)
	IF lnWaitsecs > 0
		ofrmLeftTime.SHOW
	ENDIF
*-- 提示对话框
	lnRetVal = MESSAGEBOX( lcMsgText, lnButtons, lcMsgTitle)

*!*	  ofrmLeftTime.release
*!*	  RELEASE ALL LIKE frmLeftTime
	showwait("")

	RETURN lnRetVal

*-- 定义到记时对象
**************************************************
*-- 基类:    form
*
DEFINE CLASS frmLeftTime AS FORM


	TOP = 12
	LEFT = 314
	HEIGHT = 40
	WIDTH = 119
	SHOWWINDOW = 1
	DOCREATE = .T.
	CAPTION = "倒记时中..."
	CONTROLBOX = .F.
	CLOSABLE = .F.
	MAXBUTTON = .F.
	MINBUTTON = .F.
	TITLEBAR = 1
	ALWAYSONTOP = .T.
	lntotalsecs = 0
	NAME = "frmLeftTime"
	tStartSecond = SECOND()


	ADD OBJECT timer1 AS TIMER WITH ;
		TOP = 0, ;
		LEFT = 84, ;
		HEIGHT = 23, ;
		WIDTH = 23, ;
		INTERVAL = 500, ;
		NAME = "Timer1"


	ADD OBJECT label1 AS LABEL WITH ;
		AUTOSIZE = .T., ;
		FONTBOLD = .T., ;
		FONTSIZE = 26, ;
		ALIGNMENT = 1, ;
		BACKSTYLE = 0, ;
		CAPTION = "0", ;
		HEIGHT = 42, ;
		LEFT = 20, ;
		TOP = 3, ;
		WIDTH = 22, ;
		FORECOLOR = RGB(255,0,0), ;
		NAME = "Label1"


	ADD OBJECT label2 AS LABEL WITH ;
		AUTOSIZE = .T., ;
		CAPTION = "秒剩余...", ;
		HEIGHT = 16, ;
		LEFT = 51, ;
		TOP = 23, ;
		WIDTH = 56, ;
		NAME = "Label2"


	PROCEDURE INIT
		PARA lnTotalTime
		THIS.lnTotalSecs	= lnTotalTime
		THIS.tStartSecond = SECOND()

		IF lnTotalTime = 0
			THIS.timer1.ENABLED = .F.
		ENDIF
		THISFORM.label1.CAPTION = ALLT(STR(lnTotalTime))
	ENDPROC

	PROCEDURE QUERYUNLOAD
		IF THISFORM.timer1.ENABLED = .F.
			KEYBOARD '{ENTER}' PLAIN
			THISFORM.RELEASE
		ENDIF
	ENDPROC

	PROCEDURE timer1.TIMER
		N = THISFORM.lnTotalSecs
		lnTimer = N - (SECOND() - THISFORM.tStartSecond)

		IF lnTimer <= 0
			THIS.ENABLED = .F.
			THISFORM.QUERYUNLOAD
		ELSE
			THISFORM.label1.CAPTION = ALLT(STR(lnTimer))
*			showwait ("将在 "+allt(str(lnTimer)) + " 秒后自动确认...")
		ENDIF


	ENDPROC


ENDDEFINE
*
*-- ===============================================================
*-- ===============================================================
*!!* 最大化窗口预览报表
*!!* 调用方法　do ReportPreview with "reportname","titlecaption"
*!!* 调用的的报表文件应在当前目录的 report子目录下
*-- ===============================================================
PROC ReportPreview
	PARA cReportName,cTitleName  &&定义参数报表名，标题
	SET MESSAGE TO "预览报表..."
DEFINE WINDOW WinRptPre FROM 0,0 TO SROWS()-10,SCOLS()-10 SYSTEM CLOSE FLOAT GROW ZOOM TITLE "预览报表："+cTitleName   &&SROWS()返回VF主窗口可用的行数
SET MESSAGE TO "正在计算报表总页数..."
REPORT FORM REPORT\&cReportName NOCONS ENVIRONMENT
nTotalPAGEs=_PAGENO
ACTIVATE WINDOWS WinRptPre
DEAC WIND WinRptPre
ZOOM WINDOW WinRptPre MAX   &&放大窗口到VF主窗口
REPORT FORM REPORT\&cReportName PREVIEW WINDOW WinRptPre NOWAIT
RELEASE WINDOW WinRptPre
SET MESSAGE TO "预览报表完成"
ENDPROC
*-- ===============================================================

*-- ===============================================================
*-- 读写 ini 文件
*-- ===============================================================
*---- 向 ini 文件中写入内容
*---- 调用方式： = WriteIni(pcIniFile,pcHeader,pcEntry,pcValue)
	FUNCTION WriteIni
		PARA pcIniFile,pcHeader,pcEntry,pcValue
		lcInifile  = pcIniFile    && 要操作的INI文件名
		lcHeader   = pcHeader   && 放在INI文件中的小节名
		lcEntry    = pcEntry     && 在某小节中的变量名称
		lcValue    = pcValue     && 在某变量下的具体内容
		DECLARE INTEGER WritePrivateProfileString IN Win32API AS WritePrivStr ;
			STRING cSection, STRING cKey, STRING cValue, STRING cINIFile
		= WritePrivStr(lcHeader, lcEntry, lcValue,CURDIR()+lcIniFile)
*---- 调用方式： = ReadIni(pcIniFile,pcHeader,pcEntry,pcBuffer)
	FUNCTION ReadIni
		PARA pcIniFile,pcHeader,pcEntry,pcBuffer
		lcInifile  = pcIniFile    && 要操作的INI文件名
		lcHeader   = pcHeader   && 放在INI文件中的小节名
		lcEntry    = pcEntry     && 在某小节中的变量名称
		lcBuffer   = pcBuffer     && 在某变量下的具体内容
		DECLARE INTEGER GetPrivateProfileString IN Win32API  AS GetPrivStr ;
			STRING cSection, STRING cKey, STRING cDefault, STRING @cBuffer, ;
			INTEGER nBufferSize, STRING cINIFile
		= GetPrivStr(lcHeader, lcEntry, "", @lcBuffer, LEN(lcBuffer), CURDIR()+lcIniFile)
		RETU lcBuffer
*-- ===============================================================
FUNC getfactfilename
	LPARAMETER cFileName
	LOCAL lcfactname
	lcfactname=SUBS(cFileName,RAT('\',cFileName)+1,LEN(cFileName)-RAT('\',cFileName)-4)
	RETU lcfactname
