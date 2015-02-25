VERSION 5.00
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   3090
   ClientLeft      =   60
   ClientTop       =   450
   ClientWidth     =   4680
   LinkTopic       =   "Form1"
   ScaleHeight     =   3090
   ScaleWidth      =   4680
   StartUpPosition =   3  'Windows Default
   Begin VB.Frame Frame1 
      Caption         =   "Frame1"
      Height          =   855
      Left            =   2280
      TabIndex        =   1
      Top             =   720
      Width           =   1695
      Begin VB.OptionButton Option1 
         Caption         =   "usb��"
         Height          =   375
         Left            =   240
         TabIndex        =   3
         Top             =   480
         Width           =   1095
      End
      Begin VB.OptionButton port1 
         Caption         =   "����"
         Height          =   255
         Left            =   240
         TabIndex        =   2
         Top             =   240
         Width           =   1215
      End
   End
   Begin VB.CommandButton Command1 
      Caption         =   "��������"
      Height          =   495
      Left            =   480
      TabIndex        =   0
      Top             =   480
      Width           =   855
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim port As Boolean
'Private Declare Function OmrInit Lib "OmrUsb.dll" () As Integer
Private Declare Function Omr_Init_com Lib "OmrComm.dll" Alias "OmrInit" (ByVal nPort As Integer) As Integer
Private Declare Function Omr_Init_usb Lib "OmrUsb.dll" Alias "OmrInit" () As Integer
Private Declare Function DownLoadFormatFile_com Lib "OmrComm.dll" Alias "DownLoadFormatFile" (ByVal buffer As String) As Integer
Private Declare Function DownLoadFormatFile_usb Lib "OmrUsb.dll" Alias "DownLoadFormatFile" (ByVal buffer As String) As Integer
Private Declare Function ReadOneCard_com Lib "OmrComm.dll" Alias "ReadOneCard" (ByVal begin As Integer, ByVal length As Integer, ByVal buffer As String) As Integer
Private Declare Function ReadOneCard_usb Lib "OmrUsb.dll" Alias "ReadOneCard" (ByVal begin As Integer, ByVal length As Integer, ByVal buffer As String) As Integer

Private Sub Command1_Click()
Dim result As Integer
result = 0
Dim sign As Boolean
sign = False

'�����Ӳ���
If port = False Then  'ʹ�ô���
     result = Omr_Init_com(1)
Else
     result = Omr_Init_usb()
End If

If result <= 0 Then        '��ʧ��
     MsgBox "����ʧ��"
     sign = False          '��ʧ�ܺ󣬲�Ӧ��OMR���������Ĳ���
Else
    MsgBox "�����ɹ�"
    sign = True
End If

'���ظ�ʽ�ļ�
If sign = True Then       '���Լ��ظ�ʽ�ļ�
    If port = False Then
        result = DownLoadFormatFile_com("105ti.txt")    'ע��Ҫ��׼ȷ��·��·��
    Else
        result = DownLoadFormatFile_usb("105ti.txt")    'ע��Ҫ��׼ȷ��·��·��
    End If
    
    If result <= 0 Then   '��ʽ�ļ�����ʧ��
       MsgBox "��ʽ�ļ�����ʧ��"
       sign = False
    Else
        MsgBox "��ʽ�ļ����سɹ�"
        sign = True
    End If
End If

'��ʼ���� ֻ��һ�ſ�
Dim buf As String
buf = Space(255)          'ע�⣺Ҫ�и���ʼ����Ϊ������㹻�Ŀռ����洢��Ҫ���յ��ַ���
If sign = True Then
    If port = False Then
        result = ReadOneCard_com(1, 255, buf)
    Else
        result = ReadOneCard_usb(1, 255, buf)
    End If
    
    If result <= 0 Then  '��������
        MsgBox buf       '���������buf�д洢
    Else
        MsgBox buf       '�����ַ�����Ϣ
    End If
End If


End Sub



Private Sub Form_Load()
port = False
End Sub

Private Sub Option1_Click()
port = True
End Sub

Private Sub ����_Click()
port = False
End Sub
