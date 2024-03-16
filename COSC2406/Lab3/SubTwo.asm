COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab3, Q2
	Any work in this file is my own.
!
INCLUDE Irvine32.inc
.data
prompt1 BYTE "Enter the first number: ",0
prompt2 BYTE "Enter the second number: ",0
num1 DWORD ?
num2 DWORD ?
answer DWORD ?
answer1 BYTE " - ",0
answer2 BYTE " = ", 0
.code
main PROC
	MOV EDX, OFFSET prompt1		;Prompt for the first number
	CALL WriteString
	CALL ReadInt                  ;I changed this from ReadDec to Readint, readDec is used for reading unsigned integers
	MOV num1, EAX

	MOV EDX, OFFSET prompt2		;Prompt for the second number
	CALL WriteString
	CALL ReadInt				 ;I changed this from ReadDec to Readint
	MOV num2, EAX

	SUB EAX, num1		 ;Calculate num2 – num1
	MOV answer, EAX

	MOV EAX, num2		;Print the answer
	CALL WriteInt
	MOV EDX, OFFSET answer1
	CALL WriteString
	MOV EAX, num1
	CALL WriteInt
	MOV EDX, OFFSET answer2
	CALL WriteString
	MOV EAX, answer
	CALL WriteInt
	CALL CRLF
	EXIT
main ENDP
end main
