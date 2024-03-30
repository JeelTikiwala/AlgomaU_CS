COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab4, Q2
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data
array DWORD 5 DUP(0) ; array of 5 DWORDs

.code
main PROC
    MOV array[0], 12
    MOV array[4], 13
    MOV array[8], 20
    MOV array[12], 14
    MOV array[16], 31

    MOV EAX, array + 0
    CALL WriteDec
    MOV EAX, ','
    CALL WriteChar

    MOV EAX, array + 4
    CALL WriteDec
    MOV EAX, ','
    CALL WriteChar

    MOV EAX, array + 8
    CALL WriteDec
    MOV EAX, ','
    CALL WriteChar

    MOV EAX, array + 12
    CALL WriteDec
    MOV EAX, ','
    CALL WriteChar

    MOV EAX, array + 16
    CALL WriteDec

    CALL CrLf

    EXIT
main ENDP
END main