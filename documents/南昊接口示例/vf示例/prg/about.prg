* Using ShellAbout
* 关于 对话框
*------------------------------
CLEA
DECLARE INTEGER ShellAbout IN shell32;
	INTEGER HWND,;
	STRING  szApp,;
	STRING  szOtherStuff,;
	INTEGER hIcon
DECLARE INTEGER FindWindow IN user32 ;
	STRING, STRING
DECLARE INTEGER LoadImage IN user32 ;
	INTEGER, STRING, INTEGER, INTEGER, INTEGER, INTEGER

lnhwnd    = findwindow("", _SCREEN.CAPTION)
lctitle   = "南昊公司软件部刘富强"
lccaption = "Email: lfqsir80@163.com"  + ;
	" Tel: 0318 - 8159516"
lnicon    = loadimage(0, GETENV('windir')+"\Winupd.ico", 1, 0, 0, 16)
= shellabout(lnhwnd, lctitle, lccaption, lnicon)
