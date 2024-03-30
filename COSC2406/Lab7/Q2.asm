COMMENT !
	Author: Jeel Tikiwala
	Student Number: 239659420
	Lab7, Q2
	Any work in this file is my own.
!
INCLUDE C:\Irvine\Irvine32.inc

.data

	prompttext BYTE " Enter the number of Month ( Jan = 1 ; Dec = 12 ; Exit = 0) :",0
	wtext BYTE " It's WINTER !!!!",0			;text to display winters
	sptext BYTE " It's SPRING !!!!",0			;text to display spring
	sutext BYTE " It's SUMMER !!!!",0			;text to display summer
	ftext BYTE " It's FALL !!!!",0				;text to display fall

.code

ShowSeason PROC			; procedure to display the text(season)

	PUSHFD		; preserve flags

	CMP EAX,0		; compare if input == 0 and jump to end
	JE endprog

	CMP EAX, 2		; compare if input <3 and determine season or print the appropiate msg
	JG elsespring

	MOV AL, 0Fh			; set text color for winter
	CALL SetTextColor
	MOV EDX, OFFSET wtext	 
	CALL WriteString	;reset color text
	MOV AL, 07h				
	CALL SetTextColor
	CALL CRLF
	JMP main				; jump back to main procedure for next input

elsespring:
							; else code for different seasons corresponding to inputs
	CMP EAX, 5				;if input greater than 5, check for summers
	JG elsesummer

	MOV AL, 09h			; set color for spring
	CALL SetTextColor
	MOV EDX, OFFSET sptext
	CALL WriteString		; display text
	MOV AL, 07h				;reset color text
	CALL SetTextColor
	CALL CRLF
	JMP main

elsesummer:

	CMP EAX, 8
	JG elsefall

	MOV AL, 0Eh			;set color text for summers
	CALL SetTextColor
	MOV EDX, OFFSET sutext
	CALL WriteString	;display text
	MOV AL, 07h
	CALL SetTextColor
	CALL CRLF
	JMP main

elsefall:

	CMP EAX, 11
	JG elsewinter

	MOV AL, 06h			;set color text for fall
	CALL SetTextColor
	MOV EDX, OFFSET ftext
	CALL WriteString	;displat test
	MOV AL, 07h
	CALL SetTextColor
	CALL CRLF
	JMP main

elsewinter:

	CMP EAX, 12
	JG main

	MOV AL, 0Fh		;set color text for winters
	CALL SetTextColor
	MOV EDX, OFFSET wtext
	CALL WriteString		;display text
	MOV AL, 07h		;reset color
	CALL SetTextColor
	CALL CRLF
	JMP main
	
endprog:			;end program

	POPFD		;restore the OG flag state
	
	RET
ShowSeason ENDP

main PROC							; main procedure
	
	MOV EDX, OFFSET prompttext		; prompt user for input
	CALL WriteString
	CALL ReadInt					; get input in EAX

	CALL ShowSeason					; call procedure

	CALL CRLF
	EXIT							;exit the program
main ENDP
end main