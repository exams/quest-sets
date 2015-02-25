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
         Caption         =   "usb口"
         Height          =   375
         Left            =   240
         TabIndex        =   3
         Top             =   480
         Width           =   1095
      End
      Begin VB.OptionButton port1 
         Caption         =   "串口"
         Height          =   255
         Left            =   240
         TabIndex        =   2
         Top             =   240
         Width           =   1215
      End
   End
   Begin VB.CommandButton Command1 
      Caption         =   "联机读卡"
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

'打开连接操作
If port = False Then  '使用串口
     result = Omr_Init_com(1)
Else
     result = Omr_Init_usb()
End If

If result <= 0 Then        '打开失败
     MsgBox "联机失败"
     sign = False          '打开失败后，不应对OMR进行其它的操作
Else
    MsgBox "联机成功"
    sign = True
End If

'加载格式文件
If sign = True Then       '可以加载格式文件
    If port = False Then
        result = DownLoadFormatFile_com("105ti.txt")    '注意要用准确的路径路径
    Else
        result = DownLoadFormatFile_usb("105ti.txt")    '注意要用准确的路径路径
    End If
    
    If result <= 0 Then   '格式文件加载失败
       MsgBox "格式文件加载失败"
       sign = False
    Else
        MsgBox "格式文件加载成功"
        sign = True
    End If
End If

'开始读卡 只读一张卡
Dim buf As String
buf = Space(255)          '注意：要有个初始化，为其分配足够的空间来存储你要接收的字符串
If sign = True Then
    If port = False Then
        result = ReadOneCard_com(1, 255, buf)
    Else
        result = ReadOneCard_usb(1, 255, buf)
    End If
    
    If result <= 0 Then  '读卡出错
        MsgBox buf       '错误代码在buf中存储
    Else
        MsgBox buf       '处理字符串信息
    End If
End If


End Sub



Private Sub Form_Load()
port = False
End Sub

Private Sub Option1_Click()
port = True
End Sub

Private Sub 串口_Click()
port = False
End Sub
