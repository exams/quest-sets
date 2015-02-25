// nhiiomrDlg.h : header file
//

#if !defined(AFX_NHIIOMRDLG_H__F623D524_7106_45A9_BE8A_8F7C184B6F95__INCLUDED_)
#define AFX_NHIIOMRDLG_H__F623D524_7106_45A9_BE8A_8F7C184B6F95__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

/////////////////////////////////////////////////////////////////////////////
// CNhiiomrDlg dialog

class CNhiiomrDlg : public CDialog
{
// Construction
public:
	CNhiiomrDlg(CWnd* pParent = NULL);	// standard constructor

// Dialog Data
	//{{AFX_DATA(CNhiiomrDlg)
	enum { IDD = IDD_NHIIOMR_DIALOG };
		// NOTE: the ClassWizard will add data members here
	//}}AFX_DATA

	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CNhiiomrDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV support
	//}}AFX_VIRTUAL

	private:
		HINSTANCE OMRLIB;

// Implementation
protected:
	HICON m_hIcon;

	// Generated message map functions
	//{{AFX_MSG(CNhiiomrDlg)
	virtual BOOL OnInitDialog();
	afx_msg void OnSysCommand(UINT nID, LPARAM lParam);
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	afx_msg void OnButton1();
	afx_msg void OnClose();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_NHIIOMRDLG_H__F623D524_7106_45A9_BE8A_8F7C184B6F95__INCLUDED_)
