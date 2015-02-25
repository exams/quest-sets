*mysubsproc.prg
*-- ===============================================================
*!!* �Զ��庯����ɳ��õ�һЩ����*!!*
*!!* ����ǿ������2003��11��6��
*-- ===============================================================

*-- ===============================================================
*-- ��ʾ wait ��Ϣ
*-- ===============================================================
FUNC ShowWait
	PARA wait_info,wait_second
	LOCAL lcWaitMode
	IF EMPTY(wait_info)
		WAIT CLEAR
		RETU
	ENDIF
	IF TYPE("wait_info") <> "C"
		wait_info = "��ȴ�..."
	ENDIF
	IF TYPE("wait_second") <> "N"
		lcWaitMode = "nowait"
	ELSE
		lcWaitMode = "timeout "+ALLT(STR(wait_second))
	ENDIF
	SET MESSAGE TO wait_info
*-- wait window wait_info &lcWaitMode
*-- ʹ��ʾ����Ϣ����
	lcInfoCaption = "          === ��ʾ��Ϣ ===          "
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
*-- ���÷�ʽ��=zymc(tczydm)
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
*-- ��һ������ǰ�油��
FUNC AddZero
*-- ===============================================================
	PARA tcOldChar,tnMaxLen

	IF	LEN(ALLT(tcOldChar)) < tnMaxLen AND !EMPTY(tcOldChar)
		tcOldChar=REPL('0',tnMaxLen-LEN(ALLT(tcOldChar)) ) + ALLT(tcOldChar)
	ENDIF

	RETU tcOldChar

*-- ===============================================================
*-- ===============================================================
*�������ƣ�AutoAddOne.prg
*�����ܣ����ַ����к������ֵĲ���+1
*ʹ�÷�����AutoAddOne(cCode,nLen)
*����˵����cCode��Ҫת�����ַ�����nLen���ַ��������ֵĿ��
*����˵�������ʱ��������Ҫ���ַ������ݽ��б�ŵ��Զ��ۼӣ� ��000001��ABC0001��X-001
*          �ȸ�ʽ��������Щ���ݵĹؼ�������ַ���������һ�εĲ��ֽ����ۼӼ��㣬����
*          ����ȱ�����ָ�λ�ϵ�0��������ǰ��0��
*-- ===============================================================
* �����嵥��
FUNC AutoAddOne
	PARA cCode,nLen
	PRIV cRightCode,cLeftCode,cNewCode,n0
*cRightCode Ϊ�ַ������ұ����ֲ���
*cLeftCode Ϊ�ַ�������ߵĲ���������Ĳ��֣�һ��Ϊ��ĸ
*cNewCode ����������õ����µ�����
*n0 ��ǰ��0�ĸ�����
	cCode=RTRIM(cCode)
	cRightCode=RIGHT(cCode,nLen)
	cLeftCode=LEFT(cCode,LEN(cCode)-nLen)
	IF LEN(cRightCode)<nLen
		MESSAGEBOX("�Զ����ӵ��ַ����("+ALLT(STR(LEN(cRightCode)))+")С���趨�Ŀ��("+ALLT(STR(nLen))+")��",16,"����")
		RETU ""
	ENDIF
	cNewCode=ALLT(STR(VAL(cRightCode)+1))
	n0=nLen-LEN(cNewCode)
	IF n0>=0
		cNewCode=REPL('0',n0)+cNewCode
	ELSE
		MESSAGEBOX("�ַ�����ѳ�����Ԥ���趨�����ֵ("+REPL('9',nLen)+")��",16,"����")
		RETU ""
	ENDIF
	cCode=cLeftCode+cNewCode
	RETU	cCode
*-- ===============================================================
*-- ===============================================================
*-- �ر����ݱ���
*-- ===============================================================
FUNC CloseDB
	PARA db_name   &&�ַ���
	IF USED("&db_name")
		SELE "&db_name"
		USE
	ENDIF
	RETU
*-- ===============================================================
*-- ===============================================================
*-- ������
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
*-- ���±��⣺�ó����Զ�ȥ���MSGBOX��ȷ�ϲ���
*-- ����˵��������һ��MESSAGEBOX�Ի��򣬵�û���û�ȥ��Ӧʱ���Զ���һ��ʱ������Ӧ�س��¼�
*-- ԭ����Matt Weinbender SoftServ, Inc. 5/3/2000
*-- �ɺ컢�򻯸ó���
*-- ʹ�ã� ?MsgBoxTmr("�Ի�����Ϣ","�Ի������",��Ŧ����(�ο�messagebox()����),�ȴ�ʱ��(��λ:��))
*-- ���أ� ͬmessagebox()һ��
*-- ע�⣺ ����� VFP5 �����У���Ҫ FoxTools.FLL
*--        ����� VFP6 �У��������ˡ�
*------------------------------------------------------------------
*-- ===============================================================
FUNCTION MsgBoxTmr
*-- ���ܲ��������4��
	LPARAMETERS lcMsgText, lcMsgTitle, lnButtons, lnWaitSecs

*-- ��鴫�ݵĲ���
*-- �ȴ�ʱ�������ڵ���0���������0��Ϊ���ȴ�
	IF TYPE("lnWaitSecs") # "N"
		lnWaitSecs = 0
	ELSE
		IF lnWaitSecs < 0
			lnWaitSecs = 0
		ENDIF
	ENDIF
*-- ��Ŧ����Ϊ��0,1,1+16,2+32+256...����ʽ
	IF TYPE("lnButtons") # "N"
		lnButtons	= 0
	ENDIF
*-- ����Ϊ�ַ���Ĭ���������ڱ���
	IF TYPE("lcMsgTitle") # "C"
		lcMsgTitle = _SCREEN.CAPTION
	ENDIF
*-- ��Ϣ����Ϊ�ַ�
	IF TYPE("lcMsgText") # "C"
		lcMsgText  = "����ʾ��Ϣ"
	ENDIF

*-- ����ʱ�Ӷ���
*!*		showwait("�Զ�ȷ�϶Ի���...",1)
*!*		do form test_auto_msg with lnWaitSecs
*!*		do definetimer
	ofrmLeftTime = CREATEOBJECT('frmLeftTime',lnWaitSecs)
	IF lnWaitsecs > 0
		ofrmLeftTime.SHOW
	ENDIF
*-- ��ʾ�Ի���
	lnRetVal = MESSAGEBOX( lcMsgText, lnButtons, lcMsgTitle)

*!*	  ofrmLeftTime.release
*!*	  RELEASE ALL LIKE frmLeftTime
	showwait("")

	RETURN lnRetVal

*-- ���嵽��ʱ����
**************************************************
*-- ����:    form
*
DEFINE CLASS frmLeftTime AS FORM


	TOP = 12
	LEFT = 314
	HEIGHT = 40
	WIDTH = 119
	SHOWWINDOW = 1
	DOCREATE = .T.
	CAPTION = "����ʱ��..."
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
		CAPTION = "��ʣ��...", ;
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
*			showwait ("���� "+allt(str(lnTimer)) + " ����Զ�ȷ��...")
		ENDIF


	ENDPROC


ENDDEFINE
*
*-- ===============================================================
*-- ===============================================================
*!!* ��󻯴���Ԥ������
*!!* ���÷�����do ReportPreview with "reportname","titlecaption"
*!!* ���õĵı����ļ�Ӧ�ڵ�ǰĿ¼�� report��Ŀ¼��
*-- ===============================================================
PROC ReportPreview
	PARA cReportName,cTitleName  &&�������������������
	SET MESSAGE TO "Ԥ������..."
DEFINE WINDOW WinRptPre FROM 0,0 TO SROWS()-10,SCOLS()-10 SYSTEM CLOSE FLOAT GROW ZOOM TITLE "Ԥ������"+cTitleName   &&SROWS()����VF�����ڿ��õ�����
SET MESSAGE TO "���ڼ��㱨����ҳ��..."
REPORT FORM REPORT\&cReportName NOCONS ENVIRONMENT
nTotalPAGEs=_PAGENO
ACTIVATE WINDOWS WinRptPre
DEAC WIND WinRptPre
ZOOM WINDOW WinRptPre MAX   &&�Ŵ󴰿ڵ�VF������
REPORT FORM REPORT\&cReportName PREVIEW WINDOW WinRptPre NOWAIT
RELEASE WINDOW WinRptPre
SET MESSAGE TO "Ԥ���������"
ENDPROC
*-- ===============================================================

*-- ===============================================================
*-- ��д ini �ļ�
*-- ===============================================================
*---- �� ini �ļ���д������
*---- ���÷�ʽ�� = WriteIni(pcIniFile,pcHeader,pcEntry,pcValue)
	FUNCTION WriteIni
		PARA pcIniFile,pcHeader,pcEntry,pcValue
		lcInifile  = pcIniFile    && Ҫ������INI�ļ���
		lcHeader   = pcHeader   && ����INI�ļ��е�С����
		lcEntry    = pcEntry     && ��ĳС���еı�������
		lcValue    = pcValue     && ��ĳ�����µľ�������
		DECLARE INTEGER WritePrivateProfileString IN Win32API AS WritePrivStr ;
			STRING cSection, STRING cKey, STRING cValue, STRING cINIFile
		= WritePrivStr(lcHeader, lcEntry, lcValue,CURDIR()+lcIniFile)
*---- ���÷�ʽ�� = ReadIni(pcIniFile,pcHeader,pcEntry,pcBuffer)
	FUNCTION ReadIni
		PARA pcIniFile,pcHeader,pcEntry,pcBuffer
		lcInifile  = pcIniFile    && Ҫ������INI�ļ���
		lcHeader   = pcHeader   && ����INI�ļ��е�С����
		lcEntry    = pcEntry     && ��ĳС���еı�������
		lcBuffer   = pcBuffer     && ��ĳ�����µľ�������
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
