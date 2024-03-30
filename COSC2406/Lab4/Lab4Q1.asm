COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab4, Q2
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data
promptA BYTE "Enter the value A: ", 0
promptB BYTE "Enter the value B: ", 0
promptC BYTE "Enter the value C: ", 0
promptD BYTE "Enter the value D: ", 0
promptE BYTE "Enter the value E: ", 0

numA DWORD ?
numB DWORD ?
numC DWORD ?
numD DWORD ?
numE DWORD ?

answerA BYTE "(a) A + B - (C - D) + E = ", 0
answerB BYTE "(b) (A - B) + (C + D) - E = ", 0
answerC BYTE "(c) A + (B - C) + (D + E) = ",0

.code
main PROC
	MOV EDX, OFFSET promptA						;Collect and save value of A
	CALL WriteString 
	CALL ReadInt
	MOV numA, EAX
	
	MOV EDX, OFFSET promptB						;Collect and save value of B
	CALL WriteString 
	CALL ReadInt
	MOV numB, EAX

	MOV EDX, OFFSET promptC						;Collect and save value of C
	CALL WriteString 
	CALL ReadInt
	MOV numC, EAX

	MOV EDX, OFFSET promptD						;Collect and save value of D
	CALL WriteString 
	CALL ReadInt
	MOV numD, EAX

	MOV EDX, OFFSET promptE						;Collect and save value of E
	CALL WriteString 
	CALL ReadInt
	MOV numE, EAX


	;Calculate answer (a)
	MOV EBX, numC								;EBX = C
	SUB EBX, numD								;EBX = C - D
	MOV EAX, numA								;EAX = A
	ADD EAX, numB								;EAX = A + B
	SUB EAX, EBX								;EAX = A + B - (C - D)
	ADD EAX, numE								;EAX = E
	
	;Display answer (a)
	MOV EDX, OFFSET answerA
	CALL WriteString 
	CALL WriteInt
	CALL CrLf

	; Calculate answer (b)
    MOV EAX, numA
    SUB EAX, numB
    MOV EBX, numC
    ADD EBX, numD
    ADD EAX, EBX
    SUB EAX, numE

    ; Display answer (b)
    MOV EDX, OFFSET answerB
    CALL WriteString 
    CALL WriteInt
    CALL CrLf

    ; Calculate answer (c)
    MOV EAX, numA
    MOV EBX, numB
    SUB EBX, numC
    ADD EAX, EBX
    MOV EBX, numD
    ADD EBX, numE
    ADD EAX, EBX

    ; Display answer (c)
    MOV EDX, OFFSET answerC
    CALL WriteString 
    CALL WriteInt
    CALL CrLf
	
	EXIT
main ENDP
END main
