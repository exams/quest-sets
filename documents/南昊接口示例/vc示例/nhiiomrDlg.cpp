// nhiiomrDlg.cpp : implementation file
//

#include "stdafx.h"
#include "nhiiomr.h"
#include "nhiiomrDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CAboutDlg dialog used for App About

class CAboutDlg : public CDialog
{
public:
	CAboutDlg();

// Dialog Data
	//{{AFX_DATA(CAboutDlg)
	enum { IDD = IDD_ABOUTBOX };
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CAboutDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:
	//{{AFX_MSG(CAboutDlg)
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialog(CAboutDlg::IDD)
{
	//{{AFX_DATA_INIT(CAboutDlg)
	//}}AFX_DATA_INIT
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CAboutDlg)
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialog)
	//{{AFX_MSG_MAP(CAboutDlg)
		// No message handlers
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CNhiiomrDlg dialog

CNhiiomrDlg::CNhiiomrDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CNhiiomrDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(CNhiiomrDlg)
		// NOTE: the ClassWizard will add member initialization here
	//}}AFX_DATA_INIT
	// Note that LoadIcon does not require a subsequent DestroyIcon in Win32
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CNhiiomrDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(CNhiiomrDlg)
		// NOTE: the ClassWizard will add DDX and DDV calls here
	//}}AFX_DATA_MAP
}

BEGIN_MESSAGE_MAP(CNhiiomrDlg, CDialog)
	//{{AFX_MSG_MAP(CNhiiomrDlg)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	ON_BN_CLICKED(IDC_BUTTON1, OnButton1)
	ON_WM_CLOSE()
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CNhiiomrDlg message handlers

BOOL CNhiiomrDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// Add "About..." menu item to system menu.

	// IDM_ABOUTBOX must be in the system command range.
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != NULL)
	{
		CString strAboutMenu;
		strAboutMenu.LoadString(IDS_ABOUTBOX);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// Set the icon for this dialog.  The framework does this automatically
	//  when the application's main window is not a dialog
	SetIcon(m_hIcon, TRUE);			// Set big icon
	SetIcon(m_hIcon, FALSE);		// Set small icon
	
	// TODO: Add extra initialization here
	//HINSTANCE OMRLIB;
	/*OMRLIB=::LoadLibrary("OmrClient.dll");
	if(!OMRLIB)
	{
		AfxMessageBox("dll error");
		return;
	}
	typedef int(_stdcall *OmrSG)(char* buffer);
	OmrSG OmrS,OmrG;
	OmrS=(OmrSG)::GetProcAddress(OMRLIB,"OmrS");
	OmrG=(OmrSG)::GetProcAddress(OMRLIB,"OmrG");
	*/
	return TRUE;  // return TRUE  unless you set the focus to a control
}

void CNhiiomrDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialog::OnSysCommand(nID, lParam);
	}
}

// If you add a minimize button to your dialog, you will need the code below
//  to draw the icon.  For MFC applications using the document/view model,
//  this is automatically done for you by the framework.

void CNhiiomrDlg::OnPaint() 
{
	if (IsIconic())
	{
		CPaintDC dc(this); // device context for painting

		SendMessage(WM_ICONERASEBKGND, (WPARAM) dc.GetSafeHdc(), 0);

		// Center icon in client rectangle
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// Draw the icon
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

// The system calls this to obtain the cursor to display while the user drags
//  the minimized window.
HCURSOR CNhiiomrDlg::OnQueryDragIcon()
{
	return (HCURSOR) m_hIcon;
}

void CNhiiomrDlg::OnButton1() 
{
	// TODO: Add your control notification handler code here
	//HINSTANCE OMRLIB;
	OMRLIB=::LoadLibrary("OmrUsb.dll");
	if(!OMRLIB)
	{
		AfxMessageBox("dll error");
		return;
	}
	typedef int(_stdcall *OmrSG)(char* buffer);
	typedef int(_stdcall *PassCard)(int syncs,int standard,char*error);
	typedef int(_stdcall *OmrInit)();

	OmrSG OmrS,OmrG;
	PassCard PassOneCard;
	OmrInit OmrOpen;
	OmrS=(OmrSG)::GetProcAddress(OMRLIB,"OmrS");
	OmrG=(OmrSG)::GetProcAddress(OMRLIB,"OmrG");
	PassOneCard=(PassCard)::GetProcAddress(OMRLIB,"PassOneCard");
	OmrOpen=(OmrInit)::GetProcAddress(OMRLIB,"OmrInit");
	//int res=OmrS("S .\\105ti.txt/");
	char temp[3]; temp[2]='\0';
	int count=0;
	int res=0;
	res=OmrOpen();
	if (res>0)
	{
		AfxMessageBox("联机成功");
	}
	else
	{
		AfxMessageBox("联机失败");
		return;
	}
	while(true)
	{
		res=PassOneCard(51,40,temp);
		if (res<=0)
		{
			AfxMessageBox(temp);
			break;
		}
		else
			count++;
	}
	char info[50];
	sprintf(info,"共度卡%d张",count);
	AfxMessageBox(info);
}

void CNhiiomrDlg::OnClose() 
{
	// TODO: Add your message handler code here and/or call default
	::FreeLibrary(OMRLIB);
	CDialog::OnClose();
}
