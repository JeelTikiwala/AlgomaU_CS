COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab3, Q1
	Any work in this file is my own.
!
INCLUDE Irvine32.inc
.data
hello BYTE "Hello Assembly World! ",0    //changed from "Hello Assembly!" to "Hello Assembly World!"
.code
main PROC
	MOV EDX, OFFSET hello ;Print the Hello Message
	CALL WriteString
	CALL CRLF
	EXIT
	main ENDP
END main